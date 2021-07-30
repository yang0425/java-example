package yang.example

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder

import scala.concurrent.duration._
import scala.language.postfixOps

class HelloWorldSimulation extends Simulation {

  val helloWorld: ScenarioBuilder = scenario("helloWorld").exec(karateFeature("classpath:feature/helloWorld.feature"))

  setUp(
    helloWorld.inject(rampUsers(10) during (5 seconds))
  )

}