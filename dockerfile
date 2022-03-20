FROM openjdk:17-ea-jdk-oracle
COPY target/netcracker-infotech-2021-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
