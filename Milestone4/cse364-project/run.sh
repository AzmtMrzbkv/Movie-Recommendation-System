#! /bin/sh

git clone -b aza-branch https://github.com/AzmtMrzbkv/Software-Engineering---CSE36401.git Milestone4

cd ./Software-Engineering---CSE36401/Milestone4/cse364-project

mvn package

java -jar target/RecS-1.0-SNAPSHOT.jar
