package com.gitHub.sbtScalaSpark

import com.gitHub.sbtScalaSpark.business.Analyser
import com.gitHub.sbtScalaSpark.sparkInit.SparkSessionProvider
import org.apache.spark.sql.SaveMode

object Main {

  def main(args: Array[String]): Unit = {
    val pathInputDataset = args(0)
    val pathOutputDataset = args(1)

    val sparkSessionProvider = new SparkSessionProvider()
    implicit val sparkSession = sparkSessionProvider()

    val inputDf = sparkSession.read.option("header", "true").csv(pathInputDataset)
    inputDf.printSchema()
    inputDf.show()

    val df = Analyser.removePeopleUnder18(inputDf)
    df.printSchema()
    df.show()

    df.coalesce(1).write.format("csv").option("header", "true").mode(SaveMode.Overwrite).save(pathOutputDataset)
    sparkSession.close()
  }

}
