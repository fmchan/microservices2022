FROM openjdk:17-alpine
ENV APP_FILE config-service.jar
ENV APP_HOME /app
EXPOSE 8088
COPY build/libs/$APP_FILE $APP_HOME/
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -jar $APP_FILE --spring.profiles.active=native,docker"]