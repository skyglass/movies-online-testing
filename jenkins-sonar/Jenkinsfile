pipeline {
  agent any

  stages {
    stage('SCA') {
      agent {
        docker {
          image 'sonarsource/sonar-scanner-cli:latest'
        }
      }
      steps {
        echo "Steps to execute SCA"
        withSonarQubeEnv(installationName: 'sonarqube', credentialsId: 'sonarqube') {
          sh 'sonar-scanner -Dsonar.projectVersion=1.0 -Dsonar.projectKey=react-bmi-app -Dsonar.sources=src'
        }
        waitForQualityGate(abortPipeline: true, credentialsId: 'sonarqube')
      }
    }
  }
}