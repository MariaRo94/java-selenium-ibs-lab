# java-selenium 
This project demonstrates the use of Selenium WebDriver to automate UI tests of a simple web application.


# Getting Started

## Prerequisites
Before you can run this project, you must have the following software installed on your computer:

- Java Development Kit (JDK) version 8 or later
- Apache Maven
- Google Chrome web browser

## Dependencies

This project uses the following dependencies:

- Selenium Java version 4.9.0
- TestNG version 7.7.0

## Installation
1. Clone this repository to your local machine.   
   `git clone https://github.com/marizala/java-selenium.git`
2. Navigate to the project directory using the command line.
3. Install the dependencies and run the smoke test plan (configured).   
   `mvn clean install`

## Tests

This project contains 4 sample test cases that demonstrate how to use Selenium to interact with web pages. 

### Test Cases
- `TC001_AddToCart_Checkout`: Adds product to the cart and verifies that checkout is successful.
- `TC002_AddToCart_Count`: Adds product to the cart and verifies that basket counter is correct.
- `TC003_LockedOutUser`: Invalid login and verifies that an error message is displayed.
- `TC004_Logout`: User successfully logging in and out of the application.

### Test Plans
- `TP-001_SmokeTest.xml`: Includes one test case that covers the basic functionality of the web app.
- `TP-002_Regression.xml`: Includes set of test cases that checks for overall stability and functionality of the existing features. 


## How to run the tests

#### Running a specific test case
1. Navigate to the project directory using command line.
2. Run the following command but replace "TestClass" with the name of the test case.   
   `mvn test -Dtest=TestClass`  
   E.g. `mvn test -Dtest=TC004_Logout`

#### Running a test plan
1. Navigate to the project directory using command line.
2. Run the following command but replace "TestSuite" with the file path of the test suite xml files.  
   `mvn test -DsuiteXmlFiles=TestSuite`  
   E.g. `mvn test -DsuiteXmlFiles=src/test/java/web_saucedemo/tests/testng/testplans/TP-002_Regression.xml`


