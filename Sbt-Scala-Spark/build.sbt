name := "Sbt-Scala-Spark"
version := "1.0"

scalaVersion := "2.12.8"

// Apache Spark dependencies
libraryDependencies += "org.apache.spark" %% "spark-core" % "3.0.1"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.0.1"