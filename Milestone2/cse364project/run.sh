#! /bin/sh

git clone https://github.com/AzmtMrzbkv/Software-Engineering---CSE36401.git

cd Software-Engineering---CSE36401/Milestone2/

mvn install

java -cp target/cse364-project-1.0-SNAPSHOT-jar-with-dependencies.jar com.recommend.YourMainClass.xyx.Tops “” “” “”
java -cp target/cse364-project-1.0-SNAPSHOT-jar-with-dependencies.jar com.recommend.YourMainClass.xyx.Tops “” “” “” “Adventure” 
