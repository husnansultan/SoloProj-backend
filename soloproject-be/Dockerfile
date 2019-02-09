FROM java:8
FROM maven:latest as maven-build
WORKDIR /build
COPY . . 
RUN mvn clean package
FROM jboss/wildfly:latest
WORKDIR /opt/jboss/wildfly/standalone/deployments
COPY --from=maven-build /build/target/soloproject-be.war .
EXPOSE 8080