FROM maven:3.8-openjdk-17

ADD ./target/payment-api-0.0.1-SNAPSHOT.jar /payment-api.jar

ENTRYPOINT ["java", "-jar", "payment-api.jar"]