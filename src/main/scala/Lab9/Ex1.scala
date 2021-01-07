//package Lab9
//
//import com.cra.figaro.algorithm.filtering.ParticleFilter
//import com.cra.figaro.language._
//
//object Ex1 {
//	val chapters = 10
//	val initial: Universe = Universe.createNew()
//
//	Constant("score",initial)
//	Constant("learned",initial)
//	Constant("difficulty",initial)
//
//	def transition(learned: Int , difficulty: Int): (Element[(Int,Int,Int)]) = {
//		val score: Int = (learned / chapters) / difficulty
//	}
//
//	def nextUniverse(previous: Universe): Universe = {
//		val next  = Universe.createNew()
//		val previousLearned = previous.get[Int]("learned")
//		val previousDifficulty = previous.get[Int]("difficulty")
//		val newState = Chain(previousLearned,previousDifficulty, transition)
//		Apply(newState, (s: (Int,Int,Int)) => s._1)("learned",next)
//		Apply(newState, (s: (Int,Int,Int)) => s._2)("score",next)
//		Apply(newState, (s: (Int,Int,Int)) => s._3)("difficulty",next)
//		next
//	}
//
//	def main(args: Array[String]) {
//		val arrivingObservation = List(Some(1), Some(1), Some(1), None, None, None, None, None, None, None, None, None)
//		val alg = ParticleFilter(initial,nextUniverse,100)
//		alg.start()
//		for {time <- 1 to 10}{
//				val evidence = {
//					arrivingObservation(time) match {
//						case None => List()
//						case Some(n) => List(NamedEvidence("score",Observation(n)))
//					}
//				}
//				alg.advanceTime(evidence)
//				print("Chapter" + time + ":")
//				print("expected learning = " + alg.currentExpectation("score",(i:Int) => i))
//		}
//    alg.stop()
//	}
//}