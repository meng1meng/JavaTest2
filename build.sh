cd Exam1
mvn clean install
java -classpath "target/Exam1.jar" com.hand.App
echo "Exam1 done"
cd ..
cd Exam2
mvn clean install
java -classpath "target/Exam2.jar" com.hand.TestServer
java -classpath "target/Exam2.jar" com.hand.TestClient
echo "Exam2 done,,,,,,,,"

cd ..
cd Exam3
mvn clean install
java -classpath "target/Exam3.jar" com.hand.App
echo "Exam3 done........"


