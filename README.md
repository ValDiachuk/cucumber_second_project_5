For this project I created BDD Framework. 
I used Java as a programming language and Maven as a build tool.
Maven comes with easy folder stracture that help keep all my classes organized. 
Also Maven has pom.xml file, where I stored all plugins, goals, 
dependencies, profiles, versions. Maven also provide Target folder where all reports are stored. 
I integrated Maven-Surefire-Plugin in order to execute the specific suites with tags, using Maven commands 
(mvn clean test -Dcucumber.options="--tags @Smoke", mvn clean test -Dcucumber.options="--tags @Regression")
and generated reports will be stored under Target folder that I mantion before. My framework integrated with JUnit for the 
Annotations to control test flow, Assertions for verification, and reports. I used SeleniumWebDriver and WebDriverManager to
automate my web browser testing. I also implemented POM ans Singleton design paterns and used OOP principles. 
I centralized all web elements and page related methods in object repositories using PageFactory Class.
Singleton allowed me to create a single driver instance across my framework. 
I have a Hooks Class where I keep my @After annotation to quit my driver that run after each scenario. 
I have a Runner class that I linked with my feature file and their step implementation, in order to run scenarios. 
On top of each scenario I can put a @ -> tag that will defind my test suits. 
I can easily run my test suit in the Runner class, I can specify which tag (and so as the scenario(s)) I want to execute.
In my framework I have 2 suits:
@Smoke
@Regression
I can execute them with maven commands:
mvn clean test -Dcucumber.options="--tags @Smoke"
mvn clean test -Dcucumber.options="--tags @Regression"
This command will first visit the pom.xml goal and then the Runner class. 
If runner class have a different tag, it will be updated with a given suit tag, now it will go to feature file and will start execute all
the scenarios that have the same tag. 
Scenario steps will be executed with their linked implementation in the "steps" package. 
After execution is done reports will be generated and stored under the target folder.
![cucmber_second_project](https://user-images.githubusercontent.com/115370485/221976945-0261487c-693e-492d-ac74-cb3891e652d1.png)
