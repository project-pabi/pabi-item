FROM eclipse-temurin:17
ARG JAR_FILE=pabi-item.jar
ARG JAR_PATH=./
ENV JASYPT=$PABI-JASYPT
EXPOSE 8300
COPY ${JAR_PATH}${JAR_FILE} pabi-item.jar
ENTRYPOINT ["sh", "-c", "java -Djasypt.encryptor.password=${JASYPT} -jar pabi-item.jar"]