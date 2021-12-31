# Sbt Scala Spark

## Create Jar
```bash
$ sbt clean package
```

## Cucumber
On IntelliJ, you need plugins Scala, Cucumber for Java and Gherkin. <br>
To run Cucumber test go in the folder test/resources/integration. <br>
And Click on "Run 'Feature:...'". <br>

## Scalastyle
Scalastyle examines your Scala code and indicates potential problems with it. <br>
You can add checks in the "scalastyle-config.xml" file. <br>
In IntelliJ automatically detects Scalastyle and underlines directly in the code. <br>
Tou can also use an Sbt command to check your code, the output result file is located in target/scalastyle-result.xml. <br>

For example if you want to run scalastyle only in subproject projectSpark : <br>
```bash
$ sbt
$ project sparkProject
$ scalastyle
```

Here we use the default scalastyle checks. <br>

## Scalafmt
Scalafmt is a code formatter. <br>
You can add rules in the ".scalafmt.conf". <br>
To set up the formatter in IntelliJ you can follow steps in the [documentation](https://scalameta.org/scalafmt/docs/installation.html). <br>

To reformat code :
* On mac press ⌥ + ⌘ + L
* On windows Ctrl + Alt + L

Here we use the scalafmt use in the "Apache Spark" project. <br>

## Notes
* If you have issues look at this [file](../resources/ISSUE.md) <br>