package com.gitHub.sbtScalaSpark

import com.gitHub.sbtScalaSpark.utils.DFSClient
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.{FileSystem, FileUtil}
import org.apache.hadoop.hdfs.MiniDFSCluster

import java.io.File
import java.net.URI

object DFSMiniCluster extends DFSClient{

  private val DFS_PORT = 8085
  private val DFS_BASEPATH = "target/hdfs"
  private val DFS_HOSTNAME = "localhost"
  private val DFS_WEBPORT = 50070

  def main(args: Array[String]) = {
    val conf = new Configuration()
    val baseDirFile = new File(DFS_BASEPATH).getAbsoluteFile
    FileUtil.fullyDelete(baseDirFile)

    conf.set(MiniDFSCluster.HDFS_MINIDFS_BASEDIR, baseDirFile.getAbsolutePath)
    conf.set("fs.defaultFS", DFS_HOSTNAME)
    conf.setBoolean("dfs.webhdfs.enabled", true)
    conf.set("dfs.permission", "false")
    conf.set("dfs.datanode.failed.volume.tolerated", "1")

    val dfsURI = s"hdfs://$DFS_HOSTNAME:$DFS_PORT"

    conf.set("fs.defaultFS", dfsURI)
    implicit val hdfs = FileSystem.get(new URI(dfsURI), conf)

    implicit val dfsCluster = new MiniDFSCluster
    .Builder(conf)
      .nameNodePort(DFS_PORT)
      .nameNodeHttpPort(DFS_WEBPORT)
      .build()

    dfsCluster.waitClusterUp()
  }
}
