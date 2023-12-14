FROM maven:3.8.1-openjdk-17-slim AS build
RUN mkdir "/home/currency"
COPY  . /home/currency
RUN cd /home/currency && mvn clean package
RUN cp /home/currency/target/*.jar currency.jar
ENTRYPOINT [ "java","-jar","currency.jar" ]
EXPOSE 8080