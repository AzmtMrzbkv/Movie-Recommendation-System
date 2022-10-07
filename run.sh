#! /bin/sh

git clone https://github.com/AzmtMrzbkv/Software-Engineering---CSE36401.git

cd ./Software-Engineering---CSE36401/Milestone4/cse364-project || exit

mongod --fork --syslog --dbpath src/main/resources
mvn clean spring-boot:run