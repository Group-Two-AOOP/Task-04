pipeline {
    agent any

    environment {
        SONAR_TOKEN = credentials('sonar-token')
    }

    tools {
        jdk 'JDK17'
        maven 'Maven3'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Group-Two-AOOP/Task-07.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('SonarCloud Analysis') {
            steps {
                withSonarQubeEnv('SonarCloud') {
                    bat """
                    mvn sonar:sonar \
                      -Dsonar.organization=group-two-aoop 
                      -Dsonar.projectKey=Group-Two-AOOP_Task-04
                      -Dsonar.host.url=https://sonarcloud.io
                      -Dsonar.login=$SONAR_TOKEN
                    """
                }
            }
        }
    }
}
