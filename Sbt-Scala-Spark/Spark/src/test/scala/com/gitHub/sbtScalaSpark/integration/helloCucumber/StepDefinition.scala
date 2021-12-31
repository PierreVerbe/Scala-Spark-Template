package com.gitHub.sbtScalaSpark.integration.helloCucumber

import io.cucumber.scala.{EN, ScalaDsl}
import org.scalatest.Matchers

object IsItFriday {
  def isItFriday(today: String): String = if ("Friday".equals(today)) "TGIF" else "Nope"
}

class StepDefinition extends ScalaDsl with EN with Matchers {
  private var today: String = _
  private var actualAnswer: String = _

  Given("today is {string}") { (todayInput: String) =>
    today = todayInput
  }

  Given("today is Sunday") { () =>
    today = "Sunday"
  }

  Given("today is Friday") { () =>
    today = "Friday"
  }

  When("I ask whether it's Friday yet") { () =>
    println(today)
    actualAnswer = IsItFriday.isItFriday(today)
  }

  Then("I should be told {string}") { (expectedAnswer: String) =>
    actualAnswer should equal(expectedAnswer)
  }

}
