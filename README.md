#

## Short description
A BDD WEB UI Test framework written in Java 8,
## Main libraries used:

#### Selenide
Built on top of Selenium, simplifies a lot of the set up for Webdriver based frameworks, and makes writing tests cleaner, while still allowing access to webdriver features if needed.

#### Cucumber 
For BDD scenario testing.

#### TestNG
To provide parralel test execution and a number of hooks that are very useful when building a more complex framework.

#### Allure
For reporting.

#### Webdriver Manager
Handles webdriver binaries.

#### Maven

## How to

Requires:
Java 1.8
Maven
Allure for report visualisation

How to run (assumes Maven and Allure were already added to the system path)
1. Clone the project
2. Open a terminal
3. Navigate to the project's root folder
4. Run `mvn clean test`
5. Run `allure serve allure-results`
