#! /bin/sh

git clone https://github.com/AzmtMrzbkv/Movie-Recommendation-System.git
cd ./Movie-Recommendation-System/

mongod --fork --syslog --dbpath src/main/resources
mvn clean spring-boot:run