package com.gitHub.mavenScalaSpark.structuredStreaming

import org.apache.spark.sql.SparkSession

object WordCount {
  def main(args: Array[String]) = {

    val sparkSession = SparkSession
      .builder()
      .appName("Word Count Spark Structured Streaming")
      .master("local[*]")
      .getOrCreate()

    // Create DataFrame representing the stream of input lines from connection to localhost:9999
    val lines = sparkSession.readStream
      .format("socket")
      .option("host", "localhost")
      .option("port", 9999)
      .load()

    import sparkSession.implicits._

    // Split the lines into words
    val words = lines.as[String].flatMap(_.split(" "))

    // Generate running word count
    val wordCounts = words.groupBy("value").count()

    // Start running the query that prints the running counts to the console
    val query = wordCounts.writeStream
      .outputMode("complete")
      .format("console")
      .start()

    query.awaitTermination()
  }
}
