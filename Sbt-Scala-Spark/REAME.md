# Sbt Scala Spark

## Scalastyle
Scalastyle examines your Scala code and indicates potential problems with it. <br>
You can add checks in the "scalastyle-config.xml" file. <br>
In IntelliJ automatically detects Scalastyle and underlines directly in the code. <br>
Tou can also use an Sbt command to check your code, the output result file is located in target/scalastyle-result.xml. <br>

commands
sbt
project projectSpark
scalastyle
=> run scalastyle only on subproject spark

Here we use the default scalastyle

## Scalafmt

Choose the scalafmt formatter and IntelliJ's Reformat Code
You can follow this steps https://scalameta.org/scalafmt/docs/installation.html

Here we use scalafmt from apache spark