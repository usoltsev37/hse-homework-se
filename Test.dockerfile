FROM amazoncorretto:11-alpine-jdk

COPY build.gradle settings.gradle checkstyle.xml gradlew data/
COPY src/ data/src
COPY gradle/ data/gradle

WORKDIR /data

RUN ./gradlew build test
