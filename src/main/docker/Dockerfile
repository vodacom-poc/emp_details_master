FROM java:8
MAINTAINER Mahima Agarwal  <mahima.agarwal@gmail.com>

VOLUME /tmp
ADD emp_details-2.0.jar  app.jar
RUN sh -c 'touch /app.jar'

ENV JAVA_OPTS="-Xmx256m"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
