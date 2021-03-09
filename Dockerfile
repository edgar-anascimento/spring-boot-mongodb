FROM openjdk:11

COPY target/spring-boot-mongodb-*.jar /application/app.jar

EXPOSE 8080

CMD java -jar /application/app.jar