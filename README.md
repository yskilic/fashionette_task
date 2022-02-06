# fashionette_task

Requirements for running the code are listed below;
- Java 8 or higher version
- Maven
- Cucumber plugin
- Dependencies listed in pom.xml file
How to install the tools? 
Java – Download and install from https://www.java.com/en/ 
Maven – Download and install from https://maven.apache.org/download.cgi 
If any IDE is used, clone the project through version control, if not able by 
downloading the project folder.
 
How to run the code?
The code can be run in two different way:
- Through an IDE (Preferably IntelliJ): Open the project in IDE (or clone through 
version control) and run the main method in the CukesRunner Class under 
runners package. Test cases can be executed selectively. If a single scenario 
is wanted to be executed then change the tag attribute’s value in 
CucumberOptions inside CukesRunner class respectively. “@scen1”, 
“@scen2” or “@scen3” tags can be used for executing only the respective 
scenario. If “@all” tag is used then all three scenario will be executed in 
order.
- Through the command line: Open the command prompt and navigate to the 
project folder. When inside the project folder type “mvn verify” and the code 
will be executed taking the existing tag into account. If the existing tag is 
wanted to be overridden then 
-Dcucumber.options=”--tags @tagName” should be added. 
e.g. mvn verify “-Dcucumber.options=”--tags @scen1”
-Test results can be monitored through the Cucumber Report. In order to see the report, 
simply right click on the “overview-features.html” file under target>cucumber-html-reports folder 
and choose “open in browser”

