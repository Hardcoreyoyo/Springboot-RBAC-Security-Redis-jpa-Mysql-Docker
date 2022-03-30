FROM adoptopenjdk/openjdk11:jdk-11.0.14.1_1-alpine-slim
WORKDIR /app
COPY ShopAppJwt-1.0.1.jar /app/ShopAppJwt-1.0.1.jar
ENTRYPOINT ["java","-jar","/app/ShopAppJwt-1.0.1.jar"]
