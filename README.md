# java-selenium 
This project demonstrates the use of Selenium WebDriver with Java to automate a simple web application.


## 🚀 Getting Started

### 🚧 Prerequisites
Before you can run this project, you must have the following software installed on your computer:

- Java Development Kit (JDK) version 11 or later
- Apache Maven
- Google Chrome web browser

### 🔗 Dependencies

This project uses the following dependencies:

- Selenium Java version 4.12.1
- TestNG version 7.7.0

### 🛠️ Installation
1. Clone this repository to your local machine.   
   ```sh
   git clone
   ```
2. Navigate to the project directory using the command line.
3. Install the dependencies and run the smoke test plan (configured).   
   ```sh
   mvn clean install
   ```

### 🌐 Application under test
* http://localhost:8080/food <br/>
  Note that this website is being used for testing purposes.
### 👨🏼‍🔬Tests

This project contains 2 sample test cases that demonstrate how to use Selenium to interact with web pages. 

#### 🧪 Test Cases
- `TC01_AddProductToList`: Adds product to the list and verifies that is successful.
- `TC02_RemoveProductFromList`: Adds product to the cart and then removes that product then - verifies that is correct.

#### 📝 Test Plans
- `TP-001_SmokeTest.xml`: Includes one test case that covers the basic functionality of the web app.
- `TP-002_Regression.xml`: Includes set of test cases that checks for overall stability and functionality of the existing features. 


#### 🏃🏽How to run the tests

#### 🚦 Running a test case
1. Navigate to the project directory using command line.
2. Run the following command but replace `<test_case>` with the name of the test case.   
   ```sh
   mvn test -Dtest=<test_case>
   ```  
   E.g. `mvn test -Dtest=TC004_Logout`

#### 🚦 Running a test plan
1. Navigate to the project directory using command line.
2. Run the following command but replace `<test_plan>` with the file path of the test suite xml files.  
   ```sh
   mvn test -DsuiteXmlFiles=<test_plan>
   ```
   E.g. `mvn test -DsuiteXmlFiles=src/test/java/web_food_demo/tests/testng/testplans/TP-002_Regression.xml`

