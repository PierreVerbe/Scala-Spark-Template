# Template-Scala-Spark

## About this repository

## Prerequisite
* Install Java 8 <br>
* Install Maven <br>
* Install Simple Build Tool (SBT) <br>

## Technical stack
* Scala 2.11.8 <br>
* Spark 3.0.1 <br>
* Testing : ScalaTest, ScalaCheck, Spark-Testing-Base, Cucumber <br>
* Benchmarking : ScalaMeter <br>

## Install Apache Spark 3.0.1

## Installation
* First clone this project
```bash
git clone https://github.com/PierreVerbe/Template-Scala-Spark
```

* Choose one of the 2 folders
	* Maven-Scala-Spark
	* Sbt-Scala-Spark (Most avanced one)
	
## Create Jar
* Maven-Scala-Spark
```bash
mvn clean package
```

* Sbt-Scala-Spark project
```bash
sbt clean package
```
	
## Apache Spark UI
* Accessible localhost:4040

## Notes
* Don't forget to check "Include dependencies with "Provided" Scope" to run code

* Apache Maven <br>
	Site : https://maven.apache.org/
	
* Simple Build Tool, SBT <br>
	Site : https://www.scala-sbt.org/

* Apache Spark Website <br>
    Site : https://spark.apache.org/
	
* If you have issues look at this [file](ISSUE.md) <br>
