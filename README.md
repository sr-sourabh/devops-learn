# Devops

### Problem Statement

Create a scientific calculator program with user menu driven operations

* Square root function
* Factorial function
* Natural logarithm
* Power function

### Devops toolchain used

1. Source control management: GitHub
2. Testing: Junit
3. Build: Maven
4. Continuos integration: Jenikins
5. Containerize: Docker and docker hub
6. Deployement and configuration management: Ansible
7. Monitoring: ElasticSearch, Logstash, Kibana

### Jenkins

 ```
 service jenkins restart
 service jenkins status
 ```

### Build

```
mvn clean install
```

### Deploy (Manual)

``` 
java -jar target/devopscalc-2021.1.war
```

### Docker

```
sudo systemctl disable docker.service
sudo systemctl disable docker.socket
sudo systemctl status docker
docker run --name test -it image_name
docker start -i test
docker build -t sourabhpayal/devops-learn:latest .
docker run --name test  -d  -p 8090:8090 sourabhpayal/devops-learn:latest
docker logs -f test
docker inspect -f "{{ .NetworkSettings.IPAddress }}" test
service sshd status
docker exec -it test top 
```

### ELK

```
sh logstash.sh -f logstash.conf
```