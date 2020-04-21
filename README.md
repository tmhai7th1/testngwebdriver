The purpose of this project is to have a basic project with utility to manage WebDriver instances, it helps to run multiple browsers types from a test suite
### Setting up a Project
- Install Java JDK
- Install Eclipse IDE
- Install TestNG framework in Eclipse IDE 
- Install Maven
### Test architecture
A automation project starting with a good test architecture. This project can be your initial test architecture for a faster start and easier code maintainable. We will see the following items in this architecture:
- Page Objects patters (Using Page Factory)
- DriverManager
- BaseTest
- TestListner (Capture page screenshot for the test Failed)
- Parallel execution
- Logging

#### Page Objects patters
We will transform a testcase to script automation the following our test architecture

Create successfully a appointment into calendar google
Test steps:
1. Go to https://calendar.google.com/calendar
2. SignIn successfully with existing google account
3. Calendar page is displayed
4. Click "Create" button, an appointment popup is displayed
5. Enter "Add Tilte" input into appointment popup
6. Click Save button
7. Pupop SaveSuccessful is displayed
8. Delete appointment above

For this test scenario, we create two page objects, one for the ([SignIn](https://github.com/tmhai7th1/testngwebdriver/blob/master/src/test/java/webpages/SignInPage.java)) form and one for the ([Calendar](https://github.com/tmhai7th1/testngwebdriver/blob/master/src/test/java/webpages/CalendarPage.java)). 
we must initialize the WebElements that we have annotated. We will make ([BasePage class](https://github.com/tmhai7th1/testngwebdriver/blob/master/src/test/java/webpages/BasePage.java)) to hold this small but important piece of code. 
So now we have all the pieces to start writing the actual test cases, here is a function [createTheAppointment](https://github.com/tmhai7th1/testngwebdriver/blob/master/src/test/java/testcases/CalendarGoogle.java) going through the successful test scenario above

#### DriverManager
we come up with our own abstract class – DriverManager – which test classes could use to get a driver instance from it and use them in their tests(refer [factory pattern](https://drive.google.com/file/d/1b5Q1NatKRtOirhCssZ9RuFrd2JMHy_gp/view) in creating webDriver instance)

Let's see the concrete implementation:
- [Driver Manager](https://github.com/tmhai7th1/testngwebdriver/blob/master/src/test/java/driver/DriverManager.java)
- [Chrome Driver Manager](https://github.com/tmhai7th1/testngwebdriver/blob/master/src/test/java/driver/ChromeDriverManager.java)
- [Firefox Driver Manager](https://github.com/tmhai7th1/testngwebdriver/blob/master/src/test/java/driver/FirefoxDriverManager.java)
- [IE Driver Manager](https://github.com/tmhai7th1/testngwebdriver/blob/master/src/test/java/driver/IEDriverManager.java)
- [Driver Types](https://github.com/tmhai7th1/testngwebdriver/blob/master/src/test/java/driver/DriverType.java)
- [Driver Manager Factory](https://github.com/tmhai7th1/testngwebdriver/blob/master/src/test/java/driver/DriverManagerFactory.java)

#### BaseTest
we create a [BaseTest class](https://github.com/tmhai7th1/testngwebdriver/blob/master/src/test/java/test/BaseTest.java) which will take care of download WebDriver binaries, instantiates WebDriver object, quite browser, clear cache.
Subsequent page classes then inherit from the BaseTest

#### TestListner
We create [TestListner object](https://github.com/tmhai7th1/testngwebdriver/blob/master/src/test/java/utility/TestListener.java) to Capture page screenshot for the test Failed

#### Parallel execution
TestNG provides multiple ways to execute tests in separate threads. This is defined into [test suite](https://github.com/tmhai7th1/testngwebdriver/blob/master/suites/testng.xml). 
TestNG Engine will run all the '@Test' methods in tag in the same thread, but each tag will be in a separate thread

### Multiple browsers support

Browser support: Chrome, FireFox, InternetExplorer

### Run test
We create [test suite](https://github.com/tmhai7th1/testngwebdriver/blob/master/suites/testng.xml) to trigger the testing run
we will configure basic mutable items, like:

```python
<test name = "Chrome execution">
   		<parameter name = "browser" value="CHROME"/>
   		<parameter name = "v_driver" value="80.0.3987.16"/>
```
- value of browser : will be run at CHROME browser
- value of v_driver : will be run at WebDriver binaries version 80.0.3987.16. Make sure current browser is supported by WebDriver binaries version (refer [WebDriver for Chrome](https://chromedriver.chromium.org/downloads), [WebDriver for FireFox](https://github.com/mozilla/geckodriver/releases))

#### Run test using Batch file 
We need download "testngwebdriver.zip" file form github then unzip it and next step, make sure environment build project should have ready.
Execute "Run Test.bat" file as administrator user then we get test report form target\surefire-reports\index.html
#### Run test suite in Eclipse IDE
"testngwebdriver.zip" file is ready on your machine
 - Clean and build project successfully with Eclipse IDE
 - Open Test Explorer on Eclipse IDE
 - Right click in "testng.xml" file, then choose Run As, selected TestNG Suite
 - Test project will be run with scenario above
 
We get test report form "test-output\index.html" file

