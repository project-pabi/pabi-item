FROM eclipse-temurin:17
ARG JAR_FILE=./build/libs/pabi-item.jar
EXPOSE 8100
COPY ${JAR_FILE} pabi-item.jar
ENTRYPOINT ["java", "-jar", "pabi-item.jar"]