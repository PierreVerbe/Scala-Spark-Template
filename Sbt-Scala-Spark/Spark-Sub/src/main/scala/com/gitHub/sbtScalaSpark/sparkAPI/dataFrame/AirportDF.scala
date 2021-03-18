package com.gitHub.sbtScalaSpark.sparkAPI.dataFrame

import org.apache.spark.sql.SparkSession

object AirportDF {
  def main(args: Array[String]) = {
    val sparkSession = SparkSession
      .builder()
      .appName("Airport Runways")
      .master("local[*]")
      .getOrCreate()

    import sparkSession.implicits._

    val df = sparkSession.read.option("header", "true").csv("Spark-Sub/src/main/resources/dataset/AirportRunways.csv")

    df.printSchema()
    df.show()

    df.filter(df("RWY_LEN") > 4000).show()
    df.filter($"RWY_LEN" > 4000).show()
  }
}
