ThisBuild / name := "Sbt-Scala-Spark"
ThisBuild / organization := "com.gitHub"
ThisBuild / version := "1.0"

ThisBuild / scalaVersion := "2.11.8"

// Properties build
lazy val hadoopVersion = "2.8.1"
lazy val sparkVersion = "2.2.0"
lazy val scalaTestVersion = "3.0.8"
lazy val scalaCheckVersion = "1.14.3"
lazy val scalaMeterVersion = "0.19"
lazy val sparkTestingBaseVersion = sparkVersion + "_0.14.0"
lazy val cucumberVersion = "6.10.1"
lazy val opencsvVersion = "5.4"

// Apache Hadoop
val hadoopCommon = "org.apache.hadoop" % "hadoop-common" % hadoopVersion
val hadoopHdfs = "org.apache.hadoop" % "hadoop-hdfs" % hadoopVersion
val hadoopMiniCluster = "org.apache.hadoop" % "hadoop-minicluster" % hadoopVersion

// Apache Spark
val sparkCore = "org.apache.spark" %% "spark-core" % sparkVersion
val sparkSQl = "org.apache.spark" %% "spark-sql" % sparkVersion
val sparkStreaming = "org.apache.spark" %% "spark-streaming" % sparkVersion
val sparkHive = "org.apache.spark" %% "spark-hive" % sparkVersion

// Opencsv
val opencsv = "com.opencsv" % "opencsv" % opencsvVersion

// Tests
val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion
val scalaCheck = "org.scalacheck" %% "scalacheck" % scalaCheckVersion
val sparkTestingBase = "com.holdenkarau" %% "spark-testing-base" % sparkTestingBaseVersion // Wiki : https://github.com/holdenk/spark-testing-base/wiki , Spark Testing Base -> 3.0.0 does not exist
val cucumber = "io.cucumber" %% "cucumber-scala" % cucumberVersion

// Benchmarks
val scalaMeter = "com.storm-enroute" %% "scalameter" % scalaMeterVersion

lazy val commonSettings = Seq(
  libraryDependencies ++= Seq(hadoopCommon,
    hadoopHdfs,
    hadoopMiniCluster),

  libraryDependencies ++= Seq(sparkCore % Provided,
    sparkSQl % Provided,
    sparkStreaming % Provided,
    sparkHive% Provided),
  libraryDependencies += sparkTestingBase % Test,

  libraryDependencies += scalaTest % Test,
  libraryDependencies += scalaCheck % Test,
  libraryDependencies += cucumber % Test,

  libraryDependencies += opencsv,

  libraryDependencies += scalaMeter % Test
)

lazy val root = (project in file("."))
  .settings(
    name := "Root Project"
  )

// Spark sub project
lazy val sparkProject = (project in file("Spark-Sub"))
  .settings(commonSettings : _*)
  .settings(
    name := "Spark sub project"
  )

// Hello sub project
lazy val sub = (project in file("Hello-Sub"))
  .settings(
    name := "Hello sub project"
  )
