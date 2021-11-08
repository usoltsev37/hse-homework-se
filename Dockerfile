FROM amazoncorretto:11-alpine-jdk

RUN mkdir /data
WORKDIR /data
COPY . /data

RUN ./gradlew build

EXPOSE 8080
    
ENTRYPOINT ["java", "-jar", "build/libs/sound-mapping-1.0-SNAPSHOT.jar"]
