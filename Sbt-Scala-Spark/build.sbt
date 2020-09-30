name := "Sbt-Scala-Spark"
version := "1.0"

scalaVersion := "2.12.8"

// Apache Spark dependencies
libraryDependencies += "org.apache.spark" %% "spark-core" % "3.0.1" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.0.1" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "3.0.1" % "provided"

// Scalatest
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % Test

// Scalacheck
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.3" % Test

/*
Spark Testing Base -> 3.0.0 not accessible
wiki : https://github.com/holdenk/spark-testing-base/wiki
*/
libraryDependencies += "com.holdenkarau" %% "spark-testing-base" % "2.4.5_0.14.0" % Test

