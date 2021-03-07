pipeline {
     agent any
     stages {
         stage('Maven build stage'){
             steps {
                 sh 'mvn clean install'
             }
         }
         stage('Deploy locally'){
             steps {
                dir('target') {
                  sh 'jar -xf devopscalc-0.0.1-SNAPSHOT.jar'
                }
             }
         }
     }
 }