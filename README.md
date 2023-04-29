# Sauce Demo Web Automation Testing With TestNG

Hello! This is a project Web Automation with study case [Sauce Demo](https://www.saucedemo.com/). In this project , I build the automation framework using Selenium to automate the website and TestNG to make the automation easy to read and maintain, also Maven to easily running the automation with JAVA. Make the report using Allure for the better report then used Selenium Grid for parallel executions

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

## Test Cases
....

### Prerequisites
What things you need to install:
- [Java](https://www.oracle.com/id/java/technologies/downloads/)
- [Maven](https://maven.apache.org/download.cgi)
- [Allure](https://github.com/allure-framework/allure2)
- [Docker](https://www.docker.com/)
- [Selenium Grid](https://www.selenium.dev/downloads/)


## Usage
* How to running on local machine
    - Clone the repository
    - Open the project using any IDE (Intellij, Eclipse, etc)
    - Download sources Maven and update the project
    - Running the project using command below or run using testng.xml file

````bash
mvn clean test
````

* How to running on Selenium grid
    - Setup the selenium grid 
        - Setup the Selenium grid Hub n Nodes in your local machine / Docker using this command <kbd>docker-compose -f docker-compose.yml up</kbd>
    - Clone the repository                                                                 
    - Open the project using any IDE (Intellij, Eclipse, etc)
    - Download sources Maven and update the project
    - Running the project using command below or run using testng.xml file

````bash
mvn clean test / mvn clean test -Drunning-on-hub=true
````


## Report
 
You can check the report [Here](https://dlouistandio.github.io/SauceDemo-TestNG/)
