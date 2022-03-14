# Selenium UI Java automation Project

This is a UI automation project implemented with:
* Java
* Selenium
* Allure reporting for html reporting

[Project location in github](https://github.com/avrumchic/SeleniumJavaAutomation)

To execute the tests please make sure the following:

* [Java 11 Installed](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A)
* [Maven installed](https://maven.apache.org/install.html)
* [Allure reporter installed](https://docs.qameta.io/allure/)
* [ChromerDriver setup](https://chromedriver.chromium.org/getting-started)


**Compile the project:**
>mvn clean install -DskipTests

**Run the tests:**
>mvn clean test

**To load the report**:
>allure generate allure-results --clean && allure open
