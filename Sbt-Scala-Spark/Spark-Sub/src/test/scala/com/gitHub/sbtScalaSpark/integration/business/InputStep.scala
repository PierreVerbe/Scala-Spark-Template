package com.gitHub.sbtScalaSpark.integration.business

import au.com.bytecode.opencsv.CSVWriter
import com.gitHub.sbtScalaSpark.Main
import io.cucumber.datatable.DataTable
import io.cucumber.scala.{EN, ScalaDsl}
import org.scalatest.{BeforeAndAfterAll, Matchers, Suite}

import java.io.{BufferedWriter, FileWriter}
import scala.collection.JavaConverters._
import scala.jdk.CollectionConverters.asScalaBufferConverter

class InputStep extends ScalaDsl with EN with Matchers with Suite with BeforeAndAfterAll{
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
    val rows = listTable.tail.map(_.toArray().map(_.toString))

    println(currentDirectory)
    println(listTable)
    println(schema)
    println(rows)

    val out = new BufferedWriter(new FileWriter(currentDirectory + "/" + path))
    val writer = new CSVWriter(out)
    val listOfRecord = rows.foldLeft(List(schema))((list, x) => list :+ x)

    val t = collection.mutable.ArrayBuffer(listOfRecord: _*).asJava

    writer.writeAll(t)
    out.close()
  }

}
