package com.gitHub.sbtScalaSpark.integration.business

import io.cucumber.datatable.DataTable
import io.cucumber.scala.{EN, ScalaDsl}
import org.scalatest.{BeforeAndAfterAll, Matchers, Suite}

import scala.io.Source

class OutputStep extends ScalaDsl with EN with Matchers with Suite with BeforeAndAfterAll{

  private var pathOutputDataset: String = _

  override def beforeAll(): Unit = {
    println("Starting Integration test")
  }



  Then("Output dataset located {string} should contain:") { (path: String, table: DataTable) =>
    pathOutputDataset = path

    val listTable = table.asLists()

    val bufferedSource = Source.fromFile(pathOutputDataset)
    println(listTable)

    //listTable should equal(expectedAnswer)
  }

  override def afterAll(): Unit = {
    println("Finishing Integration test")
  }

}

//Given
//dataframe input


