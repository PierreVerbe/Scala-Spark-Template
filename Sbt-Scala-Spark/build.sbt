name := "Sbt-Scala-Spark"
version := "1.0"

scalaVersion := "2.12.8"

lazy val scalaTestVersion = "3.2.2"
lazy val scalaCheckVersion = "1.14.3"
lazy val scalaMeterVersion = "0.19"

lazy val sparkVersion = "2.4.5"
lazy val sparkTestingBaseVersion = "0.14.0"

// Scalatest dependencies
libraryDependencies += "org.scalatest" %% "scalatest" % scalaTestVersion % Test

// Scalacheck dependencies
libraryDependencies += "org.scalacheck" %% "scalacheck" % scalaCheckVersion % Test

// ScalaMeter dependencies
libraryDependencies += "com.storm-enroute" %% "scalameter" % scalaMeterVersion % Test


// Apache Spark dependencies
libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion % Provided
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion % Provided
libraryDependencies += "org.apache.spark" %% "spark-streaming" % sparkVersion % Provided
libraryDependencies += "org.apache.spark" %% "spark-hive" % sparkVersion % Provided

/*
Spark Testing Base -> 3.0.0 not accessible
wiki : https://github.com/holdenk/spark-testing-base/wiki
*/
libraryDependencies += "com.holdenkarau" %% "spark-testing-base" % "2.4.5_0.14.0" % Test

// ScalaMeter dependencies
libraryDependencies += "com.storm-enroute" %% "scalameter" % scalaMeterVersion % Test
