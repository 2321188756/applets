FROM java:8

VOLUME /tmp

ADD applets-web/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]