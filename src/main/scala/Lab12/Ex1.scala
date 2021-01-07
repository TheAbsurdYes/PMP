package Lab12

import com.cra.figaro.algorithm.factored.VariableElimination
import com.cra.figaro.language._
import com.cra.figaro.algorithm.sampling._
import com.cra.figaro.library.atomic.continuous.Normal
import com.cra.figaro.library.compound.If

object Ex1 {
	def main(args: Array[String]): Unit = {
		// Ex1
//		val x0 = Apply(Normal(0.75, 0.3), (d: Double) => d.max(0).min(1))
//		val y0 = Apply(Normal(0.4, 0.2), (d: Double) => d.max(0).min(1))
//		val x = Flip(x0)
//		val y = Flip(y0)
//
//		val z = If(x === y, Flip(0.8), Flip(0.2))
//		z.observe(false)
//		val veAnswer = VariableElimination.probability(y, true)
//		for { i <- 1000 to 10000 by 1000 } {
//			var totalSquaredError = 0.0
//			for { j <- 1 to 100 } {
//				val imp = Importance(i, y)
//				imp.start()
//				val impAnswer = imp.probability(y, true)
//				val diff = veAnswer - impAnswer
//				totalSquaredError += diff * diff
//			}
//			val rmse = math.sqrt(totalSquaredError / 100)
//			println(i + " samples: RMSE = " + rmse)

    // Ex2
//			val x0 = Apply(Normal(0.75, 0.3), (d: Double) => d.max(0).min(1))
//			val y0 = Apply(Normal(0.4, 0.2), (d: Double) => d.max(0).min(1))
//			val x = Flip(x0)
//			val y = Flip(y0)
//
//			val z = If(x === y, Flip(0.8), Flip(0.2))
//			z.observe(false)
//			val veAnswer = VariableElimination.probability(y, true)
//			for { i <- 10000 to 100000 by 10000 } {
//				var totalSquaredError = 0.0
//				for { j <- 1 to 100 } {
//					Universe.createNew()
//					val x = Flip(0.8)
//					val y = Flip(0.6)
//					val z = If(x === y, Flip(0.9), Flip(0.1))
//					z.observe(false)
//					val mh = MetropolisHastings(i, ProposalScheme.default, y)
//					mh.start()
//					val mhAnswer = mh.probability(y, true)
//					val diff = veAnswer - mhAnswer
//					totalSquaredError += diff * diff
//				}
//				val rmse = math.sqrt(totalSquaredError / 100)
//				println(i + " samples: RMSE = " + rmse)
//			}

		// Ex3
//	val x0 = Apply(Normal(0.75, 0.3), (d: Double) => d.max(0).min(1))
//	val y0 = Apply(Normal(0.4, 0.2), (d: Double) => d.max(0).min(1))
//	val x = Flip(x0)
//	val y = Flip(y0)
//
//	val z = If(x === y, Flip(0.9999), Flip(0.0001))
//	z.observe(false)
//	val veAnswer = VariableElimination.probability(y, true)
//	for { i <- 1000 to 10000 by 1000 } {
//		var totalSquaredError = 0.0
//		for {j <- 1 to 100} {
//			val imp = Importance(i, y)
//			imp.start()
//			val impAnswer = imp.probability(y, true)
//			val diff = veAnswer - impAnswer
//			totalSquaredError += diff * diff
//		}
//		val rmse = math.sqrt(totalSquaredError / 100)
//		println(i + " samples: RMSE = " + rmse)
//	 }

		// Ex4
		//			val x0 = Apply(Normal(0.75, 0.3), (d: Double) => d.max(0).min(1))
		//			val y0 = Apply(Normal(0.4, 0.2), (d: Double) => d.max(0).min(1))
		//			val x = Flip(x0)
		//			val y = Flip(y0)
		//
		//			val z = If(x === y, Flip(0.8), Flip(0.2))
		//			z.observe(false)
		//			val veAnswer = VariableElimination.probability(y, true)
		//			for { i <- 10000 to 10000000 by 10000 } {
		//				var totalSquaredError = 0.0
		//				for { j <- 1 to 100 } {
		//					Universe.createNew()
		//					val x = Flip(0.8)
		//					val y = Flip(0.6)
		//					val z = If(x === y, Flip(0.9), Flip(0.1))
		//					z.observe(false)
		//					val mh = MetropolisHastings(i, ProposalScheme.default, y)
		//					mh.start()
		//					val mhAnswer = mh.probability(y, true)
		//					val diff = veAnswer - mhAnswer
		//					totalSquaredError += diff * diff
		//				}
		//				val rmse = math.sqrt(totalSquaredError / 100)
		//				println(i + " samples: RMSE = " + rmse)
		//			}

	}
}