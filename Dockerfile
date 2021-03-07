FROM openjdk:8-jre-alpine

COPY target/devopscalc-2021.1.war /home/app.war

CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/home/app.war"]