FROM amazoncorretto:11-alpine-jdk

COPY build.gradle settings.gradle gradlew data/
COPY src/ data/src
COPY gradle/ data/gradle

WORKDIR /data

RUN ./gradlew build -x checkstyleTest -x checkstyleMain

EXPOSE 8080
    
ENTRYPOINT ["java", "-jar", "build/libs/sound-mapping-1.0-SNAPSHOT.jar"]
