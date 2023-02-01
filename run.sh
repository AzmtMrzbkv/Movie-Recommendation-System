#! /bin/sh

# git clone https://github.com/AzmtMrzbkv/Movie-Recommendation-System.git
# cd ./Movie-Recommendation-System/

# sed -i 's/\r//g' run.sh

mongod --fork --syslog --dbpath src/main/resources
mvn clean spring-boot:run