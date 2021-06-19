#! /bin/sh

git clone -b aza-branch https://github.com/AzmtMrzbkv/Software-Engineering---CSE36401.git

cd ./Software-Engineering---CSE36401/Milestone4/cse364-project || exit

mvn package
mongod --fork --syslog --dbpath src/main/resources

java -jar target/RecS-1.0-SNAPSHOT.jar
