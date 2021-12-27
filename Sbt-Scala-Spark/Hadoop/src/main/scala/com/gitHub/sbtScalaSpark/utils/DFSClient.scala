package com.gitHub.sbtScalaSpark.utils

import org.apache.hadoop.fs.{FileStatus, FileSystem, Path}

class DFSClient {

  def createFolder(dir: String)(implicit hdfs: FileSystem): Unit ={
    val path = new Path(dir)

    if (hdfs.exists(path)) {
      println(s"$dir already exists")
    }
    else {
      hdfs.mkdirs(path)
      println(s"$dir has been created")
    }
  }

  def writeFile(path: String, overwrite: Boolean)(implicit hdfs: FileSystem): Unit = {
    hdfs.create(new Path(path), overwrite)
    println(s"$path file has been written")
  }

  def listDirectories(dir: String)(implicit hdfs: FileSystem): Array[FileStatus] = {
    hdfs.listStatus(new Path(dir))
  }

  def removeFile(file: String, recursive: Boolean = true)(implicit hdfs: FileSystem): Unit = {
    val path = new Path(file)
    if (hdfs.exists(path)){
      hdfs.delete(path, recursive)
      println(s"$path file has been deleted")
    }
    else {
      println(s"$path do not exist")
    }
  }

  def move(src: String, dest: String)(implicit hdfs: FileSystem): Unit = {
    hdfs.rename(new Path(src), new Path(dest))
  }

}
