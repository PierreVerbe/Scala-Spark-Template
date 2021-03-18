package com.gitHub.sbtScalaSpark.rdd

import org.apache.spark.{SparkConf, SparkContext}

object WordCountRDD {
  def main(args: Array[String]) = {
    val conf = new SparkConf().setAppName("Word Count RDD").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val textFile = sc.textFile("src/main/resources/LoremIpsum.txt")

    val counts = textFile.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)
      .count()

    println(counts)
  }
}
