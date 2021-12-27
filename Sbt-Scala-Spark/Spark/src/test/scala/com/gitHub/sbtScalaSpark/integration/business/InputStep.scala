package com.gitHub.sbtScalaSpark.integration.business

import com.gitHub.sbtScalaSpark.Main
import com.gitHub.sbtScalaSpark.integration.business.CucumberTool.getListOfFilesAndDirectory
import com.opencsv.CSVWriter
import io.cucumber.datatable.DataTable
import io.cucumber.scala.{EN, ScalaDsl, Scenario}
import org.scalatest.{Matchers, Suite}

import java.io.{BufferedWriter, FileWriter}
import scala.collection.JavaConverters._
import scala.jdk.CollectionConverters.asScalaBufferConverter
import scala.reflect.io.Path.jfile2path

class InputStep extends ScalaDsl with EN with Matchers with Suite {
  private var pathInputDataset: String = _
  private var pathOutputDataset: String = _

  Given("Input CSV file located {string} is:") { (path: String, table: DataTable) =>
    pathInputDataset = path
    writeInputDatasetToCSV(path, table)
  }

  Given("Output CSV file located {string} is") { (path: String) =>
    pathOutputDataset = path
  }

  When("I run spark job") { () =>
    Main.main(Array(pathInputDataset, pathOutputDataset))
  }

  private def writeInputDatasetToCSV(path: String, table: DataTable): Unit = {
    val currentDirectory = new java.io.File(".").getCanonicalPath

    val listTable = table.asLists().asScala
    val schema = listTable.head.toArray.map(_.toString)
    val lines = listTable.tail.map(_.toArray().map(_.toString))

    val out = new BufferedWriter(new FileWriter(currentDirectory + "/" + path))
    val writer = new CSVWriter(out)
    val listOfRecord = lines.foldLeft(List(schema))((list, x) => list :+ x)

    val result = collection.mutable.ArrayBuffer(listOfRecord: _*).asJava

    writer.writeAll(result)
    out.close()
  }

  private def deleteIntegrationDataset(folder: String): Unit = {
    val listFile = getListOfFilesAndDirectory(s"src/test/resources/integration/dataset/${folder}")
    listFile.map(file => {
      if (file.isDirectory) file.deleteRecursively()
      else file.delete()
    })
  }

  Before { scenario: Scenario =>
    println(s"Starting Scenario with id : ${scenario.getId}")
  }

  After { scenario: Scenario =>
    deleteIntegrationDataset("input")
    deleteIntegrationDataset("output")
    println(s"Ending Scenario with status : ${scenario.getStatus}")
    println("Ending Scenario")
  }

}
