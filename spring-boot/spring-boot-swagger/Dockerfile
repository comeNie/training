FROM java:8
WORKDIR /spring-tsers
ADD ./target/spring-boot-swagger-1.0-SNAPSHOT.jar /spring-tsers/spring-tsers.jar
CMD java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,suspend=n -jar spring-boot-swagger-1.0-SNAPSHOT.jar