#! /bin/sh

git clone https://github.com/AzmtMrzbkv/Software-Engineering---CSE36401.git

cd ./Software-Engineering---CSE36401/cse364-project

mvn package

java -jar target/RecS-1.0-SNAPSHOT.jar
