ThisBuild / name := "Sbt-Scala-Spark"
ThisBuild / organization := "com.gitHub"
ThisBuild / version := "1.0"

ThisBuild / scalaVersion := "2.12.8"

// Properties build
lazy val hadoopVersion = "3.1.2"
lazy val sparkVersion = "2.4.5"
lazy val jacksonModuleScalaVersion = "2.13.1"
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

// Jackson
val jackson = "com.fasterxml.jackson.module" %% "jackson-module-scala" % jacksonModuleScalaVersion

// Opencsv
val opencsv = "com.opencsv" % "opencsv" % opencsvVersion

// Tests
val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion
val scalaCheck = "org.scalacheck" %% "scalacheck" % scalaCheckVersion
val sparkTestingBase = "com.holdenkarau" %% "spark-testing-base" % sparkTestingBaseVersion
val cucumber = "io.cucumber" %% "cucumber-scala" % cucumberVersion

// Benchmarks
val scalaMeter = "com.storm-enroute" %% "scalameter" % scalaMeterVersion

lazy val SparkSettings = Seq(
  libraryDependencies ++= Seq(
    sparkCore % Provided,
    sparkSQl % Provided,
    sparkStreaming % Provided,
    sparkHive % Provided),
  libraryDependencies += jackson,
  libraryDependencies += sparkTestingBase % Test,
  libraryDependencies += scalaTest % Test,
  libraryDependencies += scalaCheck % Test,
  libraryDependencies += cucumber % Test,
  libraryDependencies += opencsv,
  libraryDependencies += scalaMeter % Test)

lazy val HadoopSettings = libraryDependencies ++= Seq(hadoopCommon, hadoopHdfs, hadoopMiniCluster)

lazy val root = (project in file("."))
  .settings(name := "Root Project")

// Spark sub project
lazy val sparkProject = (project in file("Spark"))
  .settings(SparkSettings: _*)
  .dependsOn(hadoopMiniClusterProject)
  .enablePlugins(ScalastylePlugin)
  .settings(name := "Spark project")

// Hadoop sub project
lazy val hadoopMiniClusterProject = (project in file("Hadoop"))
  .settings(HadoopSettings)
  .settings(name := "Hadoop MiniCluster project")

// Hello sub project
lazy val helloWorldProject = (project in file("Hello-World"))
  .settings(name := "Hello World project")
