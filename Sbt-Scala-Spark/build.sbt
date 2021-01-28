ThisBuild / name := "Sbt-Scala-Spark"
ThisBuild / organization := "com.gitHub"
ThisBuild / version := "1.0"

ThisBuild / scalaVersion := "2.11.8"

// Properties build
lazy val sparkVersion = "2.2.0"
lazy val scalaTestVersion = "3.0.8"
lazy val scalaCheckVersion = "1.14.3"
lazy val scalaMeterVersion = "0.19"
lazy val sparkTestingBaseVersion = sparkVersion + "_0.14.0"

// Apache Spark
val sparkCore = "org.apache.spark" %% "spark-core" % sparkVersion
val sparkSQl = "org.apache.spark" %% "spark-sql" % sparkVersion
val sparkStreaming = "org.apache.spark" %% "spark-streaming" % sparkVersion
val sparkHive = "org.apache.spark" %% "spark-hive" % sparkVersion

// Tests
val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion
val scalaCheck = "org.scalacheck" %% "scalacheck" % scalaCheckVersion
val sparkTestingBase = "com.holdenkarau" %% "spark-testing-base" % sparkTestingBaseVersion // Wiki : https://github.com/holdenk/spark-testing-base/wiki , Spark Testing Base -> 3.0.0 does not exist

// Benchmarks
val scalaMeter = "com.storm-enroute" %% "scalameter" % scalaMeterVersion

// Create subproject
lazy val sub = (project in file("Hello-Sub"))
  .settings(
    name := "Hello sub project"
  )

lazy val root = (project in file("."))
  .aggregate(sub)
  .dependsOn(sub)
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
 * Run command on root will run also on subs
 */

/**
 * Depend on : (.dependsOn(...))
 * To add a dependency on other subprojects
 */
