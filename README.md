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
java -jar target/devopscalc-2021.1
```

### Docker

```
sudo systemctl disable docker.service
sudo systemctl disable docker.socket
sudo systemctl status docker
docker run --name test -it image_name
docker start -i test
docker build -t devopscalc:latest .
docker run --name test  -d  -p 8090:8090 devopscalc:latest
docker logs -f test
docker inspect -f "{{ .NetworkSettings.IPAddress }}" test
service sshd status
docker exec -it test top
```
