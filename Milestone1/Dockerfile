FROM ubuntu:20.04
ENV DEBIAN_FRONTEND=nonintercative
RUN apt-get update && apt-get -y install git vim maven openjdk-11-jdk
#RUN mkdir /root/project
WORKDIR /root/project
ADD run.sh .
