# Devops

### Jenkins

1. Basic
    ```
    service jenkins restart
    service jenkins status
    ```
2. Pipeline
    ```
         pipeline {
             agent any
             stages {
                 stage('Get Source') {
                     steps {
                         git 'https://github.com/sr-sourabh/devops-learn.git'
         
                     }
                 }
                 stage('Maven build stage'){
                     steps {
                         sh 'mvn clean install'
                     }
                 }
                 stage('Deploy locally'){
                     steps {
                        sh 'cd target'
                        sh 'jar -xf devopscalc-0.0.1-SNAPSHOT.jar '
                     }
                 }
             }
         }

   ```

### Build

```

mvn clean install

```

### Deploy

``` 

jar -xf devopscalc-0.0.1-SNAPSHOT.jar 
java -cp BOOT-INF/classes:BOOT-INF/lib/* com.iiitb.devopscalc.DevopscalcApplication

```
