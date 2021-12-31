package com.gitHub.sbtScalaSpark.sparkInit

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

class SparkSessionProvider extends SparkConfigInit {

  def apply(conf: SparkConf = configuration): SparkSession = {
    SparkSession
      .builder()
      .config(conf)
      .getOrCreate()
  }

}
