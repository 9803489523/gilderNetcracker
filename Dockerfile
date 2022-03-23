FROM openjdk:17-ea-jdk-oracle
COPY target/gilderNetcracker-0.0.1-SNAPSHOT.jar app.jar
#EXPOSE 8081
ENTRYPOINT ["java","-jar","/app.jar"]
