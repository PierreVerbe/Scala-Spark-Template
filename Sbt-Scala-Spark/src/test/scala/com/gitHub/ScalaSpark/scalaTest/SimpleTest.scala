package com.gitHub.ScalaSpark.scalaTest

import org.scalatest.{BeforeAndAfter, BeforeAndAfterAll}
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class SimpleTest extends AnyFunSuite with Matchers with BeforeAndAfterAll with BeforeAndAfter{

  override def beforeAll(): Unit = {
    println("Start of the test : Simple test")
  }

  test("First Test"){
    val expectedResult = 2
    val result = 1 + 1

    assert(result === expectedResult)
  }

  test("Second Test"){
    val expectedResult = 2
    val result = 1 + 1

    result should equal(expectedResult)
  }

  override def afterAll(): Unit = {
    println("End of the test : Simple test")
  }

}
