package com.gitHub.sbtScalaSpark.hadoop

import org.scalatest.Matchers.convertToAnyShouldWrapper
import org.scalatest.{BeforeAndAfterAll, FlatSpec, GivenWhenThen}

class HDFSTest extends FlatSpec with GivenWhenThen with BeforeAndAfterAll with HadoopProvider {

  override def beforeAll(): Unit = {
    super.beforeAll()
    hdfsMiniCluster.hdfsCluster.waitClusterUp()
  }

  "Hadoop MiniCluster" should "be up and running" in {
    Given("a given step")

    When("a when")

    Then("a then")
    hdfsMiniCluster.hdfsCluster.isClusterUp shouldBe true
  }

  override def afterAll(): Unit = {
    super.afterAll()
    hdfsMiniCluster.hdfsCluster.shutdown()
  }
}
