package com.gitHub.sbtScalaSpark.integration.business

import com.gitHub.sbtScalaSpark.integration.business.CucumberTool.getListOfFiles
import com.opencsv.CSVReader
import io.cucumber.datatable.DataTable
import io.cucumber.scala.{EN, ScalaDsl}
import org.scalatest.{BeforeAndAfterAll, Matchers, Suite}

import java.io.FileReader
import scala.jdk.CollectionConverters.{asScalaBufferConverter, asScalaIteratorConverter}

class OutputStep extends ScalaDsl with EN with Matchers with Suite with BeforeAndAfterAll {

  Then("Output dataset located {string} should contain:") { (path: String, table: DataTable) =>
    val cucumberTable = readCucumberTable(table)
    val outputTable = readOutputDatasetToCSV(path)

    cucumberTable should contain theSameElementsAs outputTable
  }

  private def readCucumberTable(table: DataTable): List[Array[String]] = {
    table.asLists().asScala.toList.map(x => x.toArray().map(y => y.toString))
  }

  private def readOutputDatasetToCSV(path: String): List[Array[String]] = {
    val file = getListOfFiles(path).filter(_.toString.endsWith(".csv")).head
    val reader = new CSVReader(new FileReader(file))
    val outputTable = reader.iterator().asScala.toList.map(_.toArray)

    outputTable
  }

}
