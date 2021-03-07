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
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
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
                sh 'docker rmi registry.hub.docker.com/$registry:$BUILD_NUMBER'
                sh 'docker rmi $registry:$BUILD_NUMBER'
            }
         }
         stage('Pushing tags to git'){
            steps{
                sh 'git tag 2021.1.$BUILD_NUMBER'
                sh 'git push origin 2021.1.$BUILD_NUMBER'
            }
         }
    }
}