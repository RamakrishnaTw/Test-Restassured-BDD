# Test Automation Framework
This is a Test Automation Framework designed using Java, RestAssured, Cucumber, and Maven. The framework follows a Behavior Driven Development (BDD) methodology to automate API tests.

## Technology Stack
- Programming Language: Java
- API Testing Framework: RestAssured
- BDD Framework: Cucumber
- Build Tool: Maven

### Prerequisites
- Java 8.0 or later
- An IDE (like IntelliJ IDEA)

## Running Tests
You can run the tests from the command line or from within your IDE.

#### From the command line:
1. Navigate to the project directory.
2. Run "mvn verify" to execute the tests.

tags - relevant test tag (smoke, sanity, regression, test case number)

#### From within the IDE:
1. Navigate to "src/test/runner/TestRunner"
2. Change "tags" parameter to the relevant one
3. Run the file

The project follows a standard Maven structure and Cucumber BDD structure:
- src/test/java: This contains the test code, Page Objects, and Test Runner.
- src/test/resources: This contains feature files where the BDD scenarios are written, environment and template files.

Reporting
Upon completion of the test run, a report is automatically generated under the target folder. The report provides a comprehensive view of the executed tests with their status (passed/failed).


