FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} generador-numeros-random.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/generador-numeros-random.jar"]
