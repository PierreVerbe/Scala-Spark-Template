package com.gitHub.sbtScalaSpark.sparkInit

import org.apache.spark.SparkConf

trait SparkConfigInit {
  val configuration = new SparkConf()
    .setAppName("Main project")
    .setMaster("local[*]")
}
