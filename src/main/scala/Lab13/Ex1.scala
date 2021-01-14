package Lab13

import com.cra.figaro.language._
import com.cra.figaro.algorithm.sampling._
import com.cra.figaro.library.compound.If
import com.cra.figaro.algorithm.sampling.ProposalScheme
import com.cra.figaro.algorithm.sampling.MetropolisHastingsAnnealer
import com.cra.figaro.algorithm.sampling.Schedule

abstract class State {
	val confident: Element[Boolean]
	def possession: Element[Boolean] =
		If(confident, Flip(0.7), Flip(0.3))
}

class InitialState() extends State {
	val confident = Flip(0.4)
}

class NextState(current: State) extends State {
	val confident =
		If(current.confident, Flip(0.6), Flip(0.3))
}

// produce a state sequence in reverse order of the given length
def stateSequence(n: Int): List[State] = {
		if (n == 0) List(new InitialState())
		else {
			val last :: rest = stateSequence(n - 1)
			new NextState(last) :: last :: rest
		}
}
// unroll the hmm and measure the amount of time to infer the last hidden state
def timing(obsSeq: List[Boolean]): Double = {
	Universe.createNew() // ensures that each experiment is separate
	val stateSeq = stateSequence(obsSeq.length)
	for { i <- 0 until obsSeq.length } {
		stateSeq(i).possession.observe(obsSeq(obsSeq.length - 1 - i))
	}
	val alg1 = MPEVariableElimination()
	val alg2 = MPEBeliefElimination()
	val alg3 = MetropolisHastingsAnnealer(ProposalScheme.default.Schedule.default(5.0))
	val time0 = System.currentTimeMillis()
	alg1.start()
	alg2.start()
	for {i <- 0 until stateSeq.length}{
		print(alg2.mostLikelyValue(stateSeq(i).confident))
	}
	alg3.start()
	val time1 = System.currentTimeMillis()
	(time1 - time0) / 1000.0 // inference time in seconds
}

val steps = 1000
val obsSeq = List.fill(steps)(scala.util.Random.nextBoolean())
println(steps + ": " + timing(obsSeq))

