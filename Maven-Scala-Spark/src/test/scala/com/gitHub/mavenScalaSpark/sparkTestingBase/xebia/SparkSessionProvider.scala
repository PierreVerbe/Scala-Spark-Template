package com.gitHub.mavenScalaSpark.sparkTestingBase.xebia

import org.apache.spark.sql.SparkSession

trait SparkSessionProvider {
  val sparkSession : SparkSession = SparkSession
    .builder()
    .appName("SparkSession for unit tests")
    .master("local[*]")
    .getOrCreate()
}
