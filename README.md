# ThreeSixty

•	The automation code simulates the automated and prohibited products, by using POM, page factory design pattern, extent report, data driven test approach and TestNG framework, written with java OOP language. 
•	This script can be run on many browsers but it’s configured on chrome browser and work only on windows OS.
•	Extent report is added to the project which includes more details about the test cases that already run and screenshots for the failed test cases.
•	The project is uploaded on GitHub

Project architecture
With page object mode design pattern there are six packages. 
1-	Base package which include one class called the Base Class
2-	Config package which include Config.properties file
3-	Pages package which includes SignUpPage.java class
4-	TestData package which include TestData.xls file (removed because there is no test data)
5-	Utilities package which includes ReadExcelFile.java class
6-	Test package which includes a test class (SignUpPageTest.java) which contains all test cases.
How to run
Prerequisites: 
1-	jdk should be installed
2-	Eclipse IDE 
3-	TestNG framework
•	You can clone the project and run the test class as TestNG (run as TestNG)
•	There are three emails in the test script these emails should be changed to be able to sign up and proceed the next steps(add new project, add new task).
