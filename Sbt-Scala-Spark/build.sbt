ThisBuild / name := "Sbt-Scala-Spark"
ThisBuild / organization := "com.gitHub"
ThisBuild / version := "1.0"

ThisBuild / scalaVersion := "2.12.8"

// Properties build
val sparkVersion = "3.0.0"
val scalaTestVersion = "3.2.2"
val scalaCheckVersion = "1.14.3"
val scalaMeterVersion = "0.19"

// Apache Spark
val sparkCore = "org.apache.spark" %% "spark-core" % sparkVersion
val sparkSQl = "org.apache.spark" %% "spark-sql" % sparkVersion
val sparkStreaming = "org.apache.spark" %% "spark-streaming" % sparkVersion
val sparkHive = "org.apache.spark" %% "spark-hive" % sparkVersion

// Tests
val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion
val scalaCheck = "org.scalacheck" %% "scalacheck" % scalaCheckVersion
val sparkTestingBase = "com.holdenkarau" %% "spark-testing-base" % "2.4.5_0.14.0" // Wiki : https://github.com/holdenk/spark-testing-base/wiki , Spark Testing Base -> 3.0.0 does not exist

// Benchmarks
val scalaMeter = "com.storm-enroute" %% "scalameter" % scalaMeterVersion


/*
// Create subproject
lazy val benchmarking = (project in file("."))
  .aggregate(core)
  .dependsOn(core)
  .settings(

    name := "benchmarking",

  )

 */

lazy val root = (project in file("."))
  .settings(
    name := "Root Project",
    libraryDependencies ++= Seq(sparkCore % Provided,
      sparkSQl % Provided,
      sparkStreaming % Provided,
      sparkHive% Provided),
    libraryDependencies += sparkTestingBase % Test,

    libraryDependencies += scalaTest % Test,
    libraryDependencies += scalaCheck % Test,

    libraryDependencies += scalaMeter % Test
  )

/**
 * Broadcasting : (.aggreagate(...))
 * Run command on "main" will run also benchmarking
 */

/**
 * Depend on : (.dependsOn(...))
 * To add a dependency on other subprojects
 */
