package com.gitHub.sbtScalaSpark.sparkAPI.rdd

import org.apache.spark.{SparkConf, SparkContext}

object PiEstimation {
  def main(args: Array[String]) = {
    val conf = new SparkConf().setAppName("Pi estimation RDD").setMaster("local[*]")
    val sc = new SparkContext(conf)

    val NUM_SAMPLES = 100000

    val count = sc.parallelize(1 to NUM_SAMPLES).filter { _ =>
      val x = math.random
      val y = math.random
      x * x + y * y < 1
    }.count()

    println(s"Pi is roughly ${4.0 * count / NUM_SAMPLES}")
  }
}
