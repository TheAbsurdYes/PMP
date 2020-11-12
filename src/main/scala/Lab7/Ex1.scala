package Lab7

import com.cra.figaro.algorithm.sampling._
import com.cra.figaro.experimental.normalproposals.Beta
import com.cra.figaro.library.atomic.continuous.Uniform

object Ex1 {
	def greaterThan4(d: Double): Boolean = d > 3.9

	def main(args: Array[String]) : Unit = {
		val par = Beta(3,5)
		println(s"par = ${par}")
		println("Bias")
		// Nu stiu mi se pare prea stupid, nu inteleg nici beta ce inseamna, nici uniform, nici binomial , si nici contextul problemei nu am reusit sa il inteleg.
		// Nu am probleme cu scala dar stilul asta de programare ma depaseste.
	}
}