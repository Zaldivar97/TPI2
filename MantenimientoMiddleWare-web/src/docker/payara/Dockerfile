FROM payara/micro:4.181
RUN wget -O /opt/payara/postgresql-42.2.2.jar https://jdbc.postgresql.org/download/postgresql-42.2.2.jar

ADD MantenimientoMiddleWare-web-1.0-SNAPSHOT.war /opt/payara
ADD connectionPool.txt /opt/payara
  
ENTRYPOINT ["java", "-jar", "/opt/payara/payara-micro.jar", "--addJars", "/opt/payara/postgresql-42.2.2.jar", "--postbootcommandfile", "connectionPool.txt", "--deploy", "/opt/payara/MantenimientoMiddleWare-web-1.0-SNAPSHOT.war"]
#ENTRYPOINT /bin/sh


