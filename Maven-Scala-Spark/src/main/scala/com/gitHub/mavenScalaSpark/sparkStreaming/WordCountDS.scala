package com.gitHub.mavenScalaSpark.sparkStreaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object WordCountDS {

  def main(args: Array[String]) = {

    // Create a local StreamingContext with two working thread and batch interval of 10 seconds.
    val streamingContext = new StreamingContext(new SparkConf().setMaster("local[*]").setAppName("Network Word Count"), Seconds(10))

    // Create a DStream that will connect to hostname:port, like localhost:9999
    val mystreamRDD = streamingContext.socketTextStream("localhost", 9999)

    // Split each line into words
    val words = mystreamRDD.flatMap(_.split(" "))

    // Count each word in each batch
    val pairs = words.map(word => (word, 1))
    val wordCounts = pairs.reduceByKey(_ + _)

    // Print the first ten elements of each RDD generated in this DStream to the console
    wordCounts.print()

    streamingContext.start() // Start the computation
    streamingContext.awaitTermination() // Wait for the computation to terminate

  }
}

