D476TQ Selenium Test

This repository is setup to automate key workflows on the Adactin Hotel App (Build 2). 
It follows the Page Object pattern, uses explicit waits, and includes both basic and advanced test scenarios.


#Basic(Grade 3 Required)
Fill simple form and submit (Login)  ——  `LoginPage.login(...)` + `LoginTest`
Form submission with real user       ——  Credentials from `TEST_USER`/`TEST_PASS` env vars
Logout                               ——  `SecurePage.logoutAndGoToLogin()` + `LogoutTest`
Static page test                     ——  `StaticPageTest` opens `Register.php` and asserts link
Complex XPath locators               ——  3 times: SecurePage-welcome/SecurePage-Logout/StaticPage
At least 4 classes                   ——  Java classes
Explicit waits                       ——  `WebDriverWait` + `ExpectedConditions` in all Page Objects
Reading the page title               ——  `LoginTest` asserts `driver.getTitle()` contains “Search Hotel”
Page Object pattern                  ——  All page interactions encapsulated in page classes; tests focus on flow & assertions

#Advanced
WebDriver configuration (4 points) 
Manipulate cookie to bypass popup (6 points)
