FROM ubuntu:20.04
ENV DEBIAN_FRONTEND=nonintercative
RUN apt-get update && apt-get -y install git vim maven openjdk-11-jdk curl mongodb tomcat9
WORKDIR /root/project
ADD run.sh .
EXPOSE 8080
CMD ["/to/tomcat/bin/catalina.sh","run"] 
