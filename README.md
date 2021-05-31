# PitMutation Testing Repository
This Repo was made to demonstrate pit mutation testing with junit and maven

This code purposefully includes errors and bad practice in order to demonstrate, that line coverage is not proportional to code quality.

The project uses Jupyter JUnit 5 and is tested with Java 11. The version may be altered for your project, no guarantee though.

## What is mutation Testing?
Even when all lines are tested, errors can remain. To find these errors, mutation testing alters the code in multiple iterations to see which errors still pass your tests.

Killed mutations show, that your tests are written specifically for your use case.

Survived mutations, however, show that your tests are not written well enough to prevent altered versions of your code from running.

## How to use mutation testing?
In order to perform pit mutation tests, JUnit tests must run beforehand.
Make sure, the JUnit tests are run for all classes in the project by setting the JUnit run configuration to "all in package".

Open the terminal in your IDE (preferably IntelliJ IDEA) and enter the following command:

mvn -DwithHistory org.pitest:pitest-maven:mutationCoverage

The results can be found in under /target/pit-reports/{timestamp}/index.html

Just open it with a browser, and the test report can be evaluated. Alternatively, results can be viewed in the terminal

A good testing result features high code coverage and high mutation coverage.
Try to adjust the unit tests in a way that maximizes both.