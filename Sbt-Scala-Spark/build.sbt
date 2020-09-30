name := "Sbt-Scala-Spark"
version := "1.0"

scalaVersion := "2.12.8"

// Apache Spark dependencies
libraryDependencies += "org.apache.spark" %% "spark-core" % "3.0.1" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.0.1" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "3.0.1" % "provided"

// Scalatest
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % Test
