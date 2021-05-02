#! /bin/sh

git clone https://github.com/AzmtMrzbkv/Software-Engineering---CSE36401.git

cd ./Software-Engineering---CSE36401/Milestone2/cse364project

mvn install

java -cp target/cse364-project-1.0-SNAPSHOT.jar recommend.Tops “” “” “”
java -cp target/cse364-project-1.0-SNAPSHOT.jar recommend.Tops “” “” “” “Adventure” 
