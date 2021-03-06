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
jar -xf devopscalc-0.0.1-SNAPSHOT.jar
java -cp BOOT-INF/classes:BOOT-INF/lib/* com.iiitb.devopscalc.DevopscalcApplication
```
