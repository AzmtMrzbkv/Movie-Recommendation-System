FROM ubuntu:20.04
ENV DEBIAN_FRONTEND=nonintercative
RUN apt-get update && apt-get -y install apt-utils wget git vim maven openjdk-11-jdk curl gnupg mongodb tomcat9
#RUN wget -qO - https://www.mongodb.org/static/pgp/server-4.4.asc | apt-key add -
#RUN echo "deb [ arch=amd64,arm64 ] https://repo.mongodb.org/apt/ubuntu focal/mongodb-org/4.4 multiverse" | tee /etc/apt/sources.list.d/mongodb-org-4.4.list
#RUN apt-get update && apt-get -y install mongodb-org
WORKDIR /root/project
ADD run.sh .
EXPOSE 8080
#CMD ["/to/tomcat/bin/catalina.sh","run"]