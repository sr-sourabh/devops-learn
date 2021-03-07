pipeline {
    environment {
            registry = "sourabhpayal/devops-learn"
            registryCredential = 'dockerhub-credentials'
            dockerImage = ''
            dockerImageLatest = ''
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
                    dockerImageLatest = docker.build registry + ":latest"
                }
             }
         }
         stage('Push to docker hub'){
            steps{
                script{
                    docker.withRegistry('https://registry.hub.docker.com/', registryCredential){
                        dockerImage.push()
                        dockerImageLatest.push()
                    }
                }
            }
         }
         stage('Clean up'){
            steps{
                sh 'docker rmi registry.hub.docker.com/$registry:$BUILD_NUMBER'
                sh 'docker rmi $registry:$BUILD_NUMBER'
                sh 'docker rmi -f $registry:latest'
            }
         }
         stage('Pushing tags to git'){
            steps{
                sshagent(['ddddddd']) {
                    sh 'git tag 2021.1.$BUILD_NUMBER'
                    sh 'git push origin 2021.1.$BUILD_NUMBER'
                }
            }
         }
         stage('Ansible deploy to host'){
            steps{
                ansiblePlaybook disableHostKeyChecking: true, installation: 'ansible-tool', inventory: 'ansible/dev.inv', playbook: 'ansible/dev.yaml'
            }
         }
    }
}