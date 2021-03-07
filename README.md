# Devops

### Jenkins

 ```
 service jenkins restart
 service jenkins status
 ```

### Build

```

mvn clean install

```

### Deploy

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
