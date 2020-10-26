package com.gitHub.mavenScalaSpark.sparkTestingBase.xebia

import org.apache.spark.sql.{DataFrame, Row}
import org.scalatest.{FlatSpec, Matchers}

class SimpleSpec extends FlatSpec with Matchers with SparkSessionProvider {
  import sparkSession.implicits._

  def onlyPositiveBalance(inputDataFrame: DataFrame): DataFrame = {
    def positiveBalance(input: Row): Boolean = {
      input.getInt(input.fieldIndex("income")) - input.getInt(input.fieldIndex("outcome")) > 0
    }
    inputDataFrame.filter(positiveBalance(_))
  }

  "Simple test" should "do something" in {
    // Given
    val inputDF = List(
      Balance(id = 1, income = 3, outcome = 2),
      Balance(id = 2, income = 3, outcome = 4)
    ).toDF()

    // When
    val result = onlyPositiveBalance(inputDF)

    // Then
    result.schema.map(_.name) should contain allOf ("income", "outcome")
    result.count() shouldBe 1
    result.map(row => row.getInt(row.fieldIndex("id"))).head shouldBe 1
  }

}
