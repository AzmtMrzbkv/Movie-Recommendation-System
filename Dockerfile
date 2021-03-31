FROM ubuntu:20.04
RUN apt-get update && apt-get -y install git vim maven openjdk-11-jdk
RUN mkdir /root/project
WORKDIR /root/project
ADD run.sh .
RUN chmod +x /run.sh
