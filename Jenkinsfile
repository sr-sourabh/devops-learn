pipeline {
    environment {
            registry = "registry.hub.docker.com/sourabhpayal/devops-learn"
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
                    sh 'docker rmi -f $registry:latest &>/dev/null && echo \'Removed old latest image\' '
                    sh 'docker rmi -f sourabhpayal/devops-learn:latest &>/dev/null && echo \'Removed old latest image\' '
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
                sh 'docker rm -f test &>/dev/null && echo \'Removed old container\' '
                ansiblePlaybook disableHostKeyChecking: true, installation: 'ansible-tool', inventory: 'ansible/dev.inv', playbook: 'ansible/dev.yaml'
            }
         }
    }
    post {
            always {
                mail to: 'devops-learn@mailinator.com',
                     subject: "${currentBuild.currentResult} Pipeline: ${currentBuild.fullDisplayName}",
                     body: " "
            }
        }
}