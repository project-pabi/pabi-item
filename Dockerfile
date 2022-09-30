FROM eclipse-temurin:17
ARG JAR_FILE=pabi-item.jar
ARG JAR_PATH=./
EXPOSE 8300
COPY ${JAR_PATH}${JAR_FILE} pabi-item.jar
ENTRYPOINT ["java", "-jar", "pabi-item.jar"]