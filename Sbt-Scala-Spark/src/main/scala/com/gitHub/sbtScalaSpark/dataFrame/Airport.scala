package com.gitHub.sbtScalaSpark.dataFrame

import org.apache.spark.sql.SparkSession

object Airport {
  def main(args: Array[String]) = {
    val sparkSession = SparkSession
      .builder()
      .appName("Airport Runways")
      .master("local[*]")
      .getOrCreate()

    val df = sparkSession.read.option("header", "true").csv("src/main/resources/AirportRunways.csv")

    df.printSchema()
    df.show()

    df.filter(df("RWY_LEN") > 4000).show()
  }
}
