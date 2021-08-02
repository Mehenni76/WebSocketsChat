cd /d "%~dp0"
REM WebSocketsChat
call mvn clean install -f pom.xml
 java -jar ./target/chatforprojet1.jar
pause
