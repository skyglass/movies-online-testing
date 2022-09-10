docker volume create --name sonarqube_data
docker volume create --name sonarqube_logs
docker volume create --name sonarqube_extensions
docker volume create --name postgresql
docker volume create --name postgresql_data

docker-compose up -d