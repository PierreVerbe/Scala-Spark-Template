package com.gitHub.sbtScalaSpark

import com.gitHub.sbtScalaSpark.sparkAPI.dataSet.PersonDS.Person
import com.gitHub.sbtScalaSpark.sparkInit.SparkSessionProvider

object Main {

  def main(args: Array[String]): Unit = {
    val sparkSessionProvider = new SparkSessionProvider()
    implicit val sparkSession = sparkSessionProvider()

    import sparkSession.implicits._

    val personSeq = Seq(Person("bob", 22), Person("John", 32), Person("Mary", 31), Person("Fred", 42), Person("Lea", 8), Person("Elsa", 40))
    val personRdd = sparkSession.sparkContext.parallelize(personSeq)
    val personDf = personRdd.toDF()
    val personDs = personDf.as[Person]

    personDs.printSchema()
    personDs.show()
  }

}
