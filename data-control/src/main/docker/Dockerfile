FROM registry.cn-hangzhou.aliyuncs.com/menglou/java:8
VOLUME /tmp
ADD data-control-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8082
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]