# MUTANT DETECTOR

## Url 
[HEROKU: https://floating-peak-19456.herokuapp.com/](https://floating-peak-19456.herokuapp.com/).
[Is Mutant](https://floating-peak-19456.herokuapp.com/mutant/).
[Stats](https://floating-peak-19456.herokuapp.com/stats).

## Prerequisites
1. Install [Java 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html), [Maven](https://maven.apache.org/download.cgi) and [Git](https://git-scm.com/downloads)
2. Execute `git clone https://github.com/ceeconro/mutant_detector.git` and `cd mutant_detector` 
3. From project root folder folder: `mvn clean install`

## Run
1. Run `mvn spring-boot:run`

## Test
1. Run `mvn test`

## Coverage
1. Run `mvn clean verify`
2. Check `target/site/jacoco/index.html` for coverage results

## Load Test
1. Install [JMeter] (https://jmeter.apache.org/download_jmeter.cgi)
2. Open `./load_test/DnaDetectorLoadTest.jmx` with JMeter and RUN

## Author
* [Cesar Contreras](https://github.com/ceeconro)
