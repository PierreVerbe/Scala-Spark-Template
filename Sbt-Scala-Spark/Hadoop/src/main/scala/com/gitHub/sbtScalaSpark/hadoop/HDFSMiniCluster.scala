package com.gitHub.sbtScalaSpark.hadoop

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileStatus, FileSystem, FileUtil, Path}
import org.apache.hadoop.hdfs.MiniDFSCluster

import java.io.File
import java.net.URI

class HDFSMiniCluster(baseDir: String, dfsPort: Int, dfsWebPort: Int, dfsURI: String) {
  val conf = new Configuration()
  val baseDirFile = new File(baseDir).getAbsoluteFile
  FileUtil.fullyDelete(baseDirFile)

  conf.set(MiniDFSCluster.HDFS_MINIDFS_BASEDIR, baseDirFile.getAbsolutePath)
  conf.set("dfs.webhdfs.enabled", "true")
  conf.set("dfs.permission", "false")
  conf.set("dfs.datanode.failed.volume.tolerated", "1")
  conf.set("fs.defaultFS", dfsURI)

  implicit val hdfs = FileSystem.get(new URI(dfsURI), conf)

  val hdfsCluster = new MiniDFSCluster
  .Builder(conf)
    .nameNodePort(dfsPort)
    .nameNodeHttpPort(dfsWebPort)
    .build()

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

object HDFSMiniCluster {
  private val DFS_PORT = 8085
  private val DFS_BASEPATH = "target/hdfs"
  private val DFS_HOSTNAME = "localhost"
  private val DFS_WEBPORT = 50070
  val DFS_URI = s"hdfs://$DFS_HOSTNAME:$DFS_PORT"

  def createHDFSMiniCluster() : HDFSMiniCluster = {
    new HDFSMiniCluster(DFS_BASEPATH, DFS_PORT, DFS_WEBPORT, DFS_URI)
  }

}
