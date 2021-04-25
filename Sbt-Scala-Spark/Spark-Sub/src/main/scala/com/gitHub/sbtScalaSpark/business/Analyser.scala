package com.gitHub.sbtScalaSpark.business

import org.apache.spark.sql.{DataFrame, SparkSession}

object Analyser {

  def removePeopleUnder18(dataset: DataFrame)(implicit sparkSession: SparkSession): DataFrame = {
    dataset.filter(dataset("Age") >= 18)
  }

}
