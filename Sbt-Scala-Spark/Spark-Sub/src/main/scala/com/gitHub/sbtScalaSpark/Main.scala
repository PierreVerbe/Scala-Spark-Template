package com.gitHub.sbtScalaSpark

import com.gitHub.sbtScalaSpark.sparkAPI.dataSet.PersonDS.Person
import com.gitHub.sbtScalaSpark.sparkInit.SparkSessionProvider
import org.apache.spark.sql.SaveMode

object Main {

  def main(args: Array[String]): Unit = {
    val pathInputDataset = args(0)
    val pathOutputDataset = args(1)

    val sparkSessionProvider = new SparkSessionProvider()
    implicit val sparkSession = sparkSessionProvider()
    import sparkSession.implicits._

    println(pathInputDataset)
    println(pathOutputDataset)

    val df = sparkSession.read.option("header", "true").csv(pathInputDataset)
    df.show

    val personSeq = Seq(Person("bobe", 22), Person("John", 32), Person("Mary", 31), Person("Fred", 42), Person("Lea", 8), Person("Elsa", 40))
    val personRdd = sparkSession.sparkContext.parallelize(personSeq)
    val personDf = personRdd.toDF()
    val personDs = personDf.as[Person]

    personDs.printSchema()
    personDs.show()

    df.coalesce(1).write.format("csv").option("header", "true").mode(SaveMode.Overwrite).save(pathOutputDataset)
  }

}
