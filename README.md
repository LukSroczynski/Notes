# Personal Notebook

https://news.ycombinator.com/

https://uptodate.frontendrescue.org/pl/

Spring repo:
https://repo.spring.io/release/org/springframework/spring/

Spring needs also (Apache Commons Logging): 
https://commons.apache.org/proper/commons-logging/download_logging.cgi


GIT TOO LONG PATH WINDOWS: git config core.longpaths true

After: git reset --hard HEAD~1

TDD:
https://www.youtube.com/watch?v=45T32_ImO2c&list=PLBBog2r6uMCSa9_mNISSpTcbTcKlMAe6t

DataStructures: <br> 
https://medium.freecodecamp.org/10-common-data-structures-explained-with-videos-exercises-aaff6c06fb2b

MongoDB course: <br> 
https://university.mongodb.com/courses/M101J/about

fix for Spring Boot plugin requires Gradle 4.0 or later. The current version is Gradle 3.5.1
```
task wrapper(type: Wrapper) {
	gradleVersion = '4.6'
}
```
```
./gradlew assemble
```
