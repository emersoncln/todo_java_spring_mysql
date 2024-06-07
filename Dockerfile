FROM amazoncorretto:21.0.3-alpine3.19
COPY target/todoproject-0.0.1-release.jar todoproject-0.0.1-release.jar
EXPOSE 8080
CMD [ "java", "-jar", "todoproject-0.0.1-release.jar" ]