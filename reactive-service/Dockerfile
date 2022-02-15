FROM openjdk:17-alpine

ENV DOCKERIZE_VERSION v0.6.1
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz


ENV APP_FILE reactive-service.jar
ENV APP_HOME /app
EXPOSE 8040
COPY build/libs/$APP_FILE $APP_HOME/
WORKDIR $APP_HOME
ENTRYPOINT ["sh", "-c"]
CMD ["exec dockerize -timeout 5m -wait tcp://discovery-service:8061 java -jar $APP_FILE --spring.profiles.active=docker"]