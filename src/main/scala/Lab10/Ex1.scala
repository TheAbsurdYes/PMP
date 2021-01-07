//package Lab10
//
//import com.cra.figaro.language._
//import com.cra.figaro.algorithm.sampling._
//
//object Ex1 {
//	def main(args: Array[String]) {
//		val nrUniverses = 10
//		val initial = Universe.createNew()
//
//		Constant("capital",initial)
//		Constant("investment",initial)
//		Constant("profit",initial)
//
//		def transition(capital: Int, investment: Int, profit: Int): Element[(Int,Int,Int)] = {
//			val capital: Int = capital + investment + profit
//      val investment: Int = if (capital >  1000) investment*0.5.toInt else investment
//			val profit: Int = investment + investment/2
//		}
//
//		def nextUniverse(previous: Universe): Universe = {
//			val next  = Universe.createNew()
//			val previousCapital = previous.get[Int]("capital")
//			val previousInvestment = previous.get[Int]("investment")
//			val newState = Chain(previousCapital,previousInvestment, transition)
//			Apply(newState, (s: (Int,Int,Int)) => s._1)("capital",next)
//			Apply(newState, (s: (Int,Int,Int)) => s._2)("investment",next)
//			Apply(newState, (s: (Int,Int,Int)) => s._3)("profit",next)
//			next
//    }
//	}
//}