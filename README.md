# BackendTestProject

# System Requirements

1. JAVA - Java [JDK or JRE - 8 or above](https://www.oracle.com/technetwork/java/javase/downloads/index.html)

# Tools Used
1. [Gradle](https://gradle.org/) (4.10)- This is the build tool used to configure and install all the required dependent libraries and run tests from command line on local and remote machines.
2. [TestNG](https://testng.org/doc/index.html) - Test framework used to organize and run tests.
3. [Java](https://www.java.com/en/)(8) - As programming language.
4. [Rest Assured](https://rest-assured.io/) - This is used to interact with the http server. 
5. [Hamcrest](https://hamcrest.org/) - This is used to simplify the request response comparison

# Steps to Setup
1. Ensure proper JAVA version is installed in the system
2. Take a clone of this repository to local machine.
3. In IntelliJ (or any IDE), goto file -> open -> browse to the folder where the clone is taken -> select the folder -> click on open.
4. Now project is ready to execute, provided the above mentioned setup of tools is done successfully and all the dependencies are downloaded in the IDE.

# Steps to run
1. To run as gradle - `./gradlew clean runTests -Dtag=createUser`

# Reports
1. TestNG report can be seen at - `/build/<tag name>/html/index.html` (open in browser)
2. Extent report can be seen at - `TestReport/Test-Automaton-Report.html` (open in browser)
