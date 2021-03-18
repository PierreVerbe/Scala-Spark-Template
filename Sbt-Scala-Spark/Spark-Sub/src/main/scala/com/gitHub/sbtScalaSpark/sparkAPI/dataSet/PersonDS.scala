package com.gitHub.sbtScalaSpark.sparkAPI.dataSet

import org.apache.spark.sql.SparkSession

object PersonDS {
  case class Person(name: String, age: Int)

  def main(args: Array[String]) = {
    val sparkSession = SparkSession
      .builder()
      .appName("Persons")
      .master("local[*]")
      .getOrCreate()

    import sparkSession.implicits._

    val personSeq = Seq(Person("bob", 22), Person("John", 32), Person("Mary", 31), Person("Fred", 42), Person("Lea", 8), Person("Elsa", 40))
    val personRdd = sparkSession.sparkContext.parallelize(personSeq)
    val personDf = personRdd.toDF()
    val personDs = personDf.as[Person]

    personDs.printSchema()
    personDs.show()

    personDs.filter($"age" < 30).show()
  }
}
