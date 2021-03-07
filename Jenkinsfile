pipeline {
    environment {
            registry = "sourabhpayal/devops-learn"
            registryCredential = 'dockerhub-credentials'
            dockerImage = ''
    }
    agent any
    stages {
         stage('Maven build stage'){
             steps {
                 sh 'mvn clean install'
             }
         }
         stage('Build Image'){
             steps {
                script{
                    dockerImage = docker.build registry + ":11"
                }
             }
         }
         stage('Push to docker hub'){
            steps{
                script{
                    docker.withRegistry('https://registry.hub.docker.com/', registryCredential){
                        dockerImage.push()
                    }
                }
            }
         }
         stage('Clean up'){
            steps{
                sh 'docker rmi registry.hub.docker.com/$registry:11'
            }
         }
    }
}