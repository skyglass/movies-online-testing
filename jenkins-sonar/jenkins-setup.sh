docker network create jenkins

docker build -t myjenkins-blueocean:2.346.3-1 .

docker volume create jenkins-data-new
docker volume create jenkins-docker-certs-new

docker container run \
  --name jenkins-docker \
  --detach \
  --restart unless-stopped \
  --privileged \
  --network jenkins \
  --network-alias docker \
  --env DOCKER_TLS_CERTDIR=/certs \
  --volume jenkins-docker-certs-new:/certs/client \
  --volume jenkins-data-new:/var/jenkins_home \
  --publish 2376:2376 \
  docker:dind --storage-driver overlay2

docker ps -a

docker run \
  -m 2000m \
  --name jenkins-blueocean \
  --restart unless-stopped \
  --privileged \
  --detach \
  --network jenkins \
  --env DOCKER_HOST=tcp://docker:2376 \
  --env DOCKER_CERT_PATH=/certs/client \
  --env DOCKER_TLS_VERIFY=1 \
  --publish 9999:8080 \
  --publish 50000:50000 \
  --volume jenkins-data-new:/var/jenkins_home \
  --volume jenkins-docker-certs-new:/certs/client:ro \
  myjenkins-blueocean:2.346.3-1