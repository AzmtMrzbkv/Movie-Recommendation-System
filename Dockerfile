FROM ubuntu:20.04
ENV DEBIAN_FRONTEND=nonintercative
RUN apt-get update && apt-get -y install apt-utils wget git vim maven openjdk-11-jdk curl gnupg mongodb tomcat9
WORKDIR /root/project
ADD run.sh .
EXPOSE 8080