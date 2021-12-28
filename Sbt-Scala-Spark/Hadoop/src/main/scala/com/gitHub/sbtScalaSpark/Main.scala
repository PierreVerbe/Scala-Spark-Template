package com.gitHub.sbtScalaSpark

import com.gitHub.sbtScalaSpark.hadoop.HDFSMiniCluster.createHDFSMiniCluster

object Main {

  def main(args: Array[String]): Unit = {
    val HDFSMiniCluster = createHDFSMiniCluster()
    HDFSMiniCluster.hdfsCluster.waitClusterUp()
  }

}
