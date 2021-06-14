FROM ubuntu:20.04
ENV DEBIAN_FRONTEND=nonintercative
RUN apt-get update && apt-get -y install apt-utils wget git vim maven openjdk-11-jdk curl gnupg
RUN wget -qO - https://www.mongodb.org/static/pgp/server-4.4.asc | apt-key add -
RUN echo "deb [ arch=amd64,arm64 ] https://repo.mongodb.org/apt/ubuntu focal/mongodb-org/4.4 multiverse" | tee /etc/apt/sources.list.d/mongodb-org-4.4.list
RUN apt-get update && apt-get -y install mongodb-org
WORKDIR /root/project
ADD run.sh .
