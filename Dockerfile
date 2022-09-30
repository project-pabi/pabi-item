FROM eclipse-temurin:17
ARG JAR_FILE=pabi-item.jar
ARG PATH=./
EXPOSE 8300
COPY ${PATH}${JAR_FILE} pabi-item.jar
ENTRYPOINT ["java", "-jar", "pabi-item.jar"]