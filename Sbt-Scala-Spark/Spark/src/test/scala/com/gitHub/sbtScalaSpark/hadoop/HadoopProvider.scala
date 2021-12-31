package com.gitHub.sbtScalaSpark.hadoop

import com.gitHub.sbtScalaSpark.hadoop.HDFSMiniCluster.createHDFSMiniCluster

trait HadoopProvider {
  val hdfsMiniCluster = createHDFSMiniCluster()
}
