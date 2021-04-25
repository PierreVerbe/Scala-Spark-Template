package com.gitHub.sbtScalaSpark.integration.business

import java.io.File

object CucumberTool {

  def getListOfFiles(path: String): List[File] = {
    val file = new File(path)
    if (file.exists && file.isDirectory) {
      file.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }
  }

  def getListOfFilesAndDirectory(path: String): List[File] = {
    val file = new File(path)
    if (file.exists && file.isDirectory) {
      file.listFiles.toList
    } else {
      List[File]()
    }
  }

}
