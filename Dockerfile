FROM tomcat:latest

EXPOSE 8080

RUN rm -fr /usr/local/tomcat/webapps/ROOT

COPY ./nasa.war /usr/local/tomcat/webapps/nasa.war

CMD ["catalina.sh", "run"]
