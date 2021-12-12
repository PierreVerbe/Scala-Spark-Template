package com.gitHub.sbtScalaSpark.hadoop

import org.scalatest.{BeforeAndAfterAll, WordSpec}

class miniDFSClusterSpec extends WordSpec with HDFSCluster with BeforeAndAfterAll {
  override protected def beforeAll(): Unit = {
    startHDFS
  }
  override protected def afterAll(): Unit = {
    shutdownHDFS
  }

  "miniDFSClusterSpec" should {
    "write and read data from miniDFS cluster" in {
      val url = getNameNodeURI
      val dir = getNameNodeURI + "/user"
      val hdfsHelper = new HDFSHelper[Int](url)
      val data: Int = 10
      hdfsHelper.write(data, dir)
      val result = hdfsHelper.read(dir)
      assert(data == result)
    }
  }
}

// https://akashrehan.wordpress.com/2018/03/25/how-to-use-minidfs-cluster-in-hdfs-dependent-test-cases/


/* HADOOP_HOME
   PATH
https://github.com/sakserv/hadoop-mini-clusters
    */