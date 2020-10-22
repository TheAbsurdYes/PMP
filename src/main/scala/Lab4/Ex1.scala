package Lab4 

import com.cra.figaro.algorithm.factored.VariableElimination
import com.cra.figaro.language._
import com.cra.figaro.algorithm.sampling._
import com.cra.figaro.library.compound.If

object Ex1 {
	def main(args: Array[String]): Unit = {
		val bed = Flip(0.5)
		val greetingToday = If(bed,Constant("What a wondeful day!"),Constant("Oh no, not again!"))
		println(VariableElimination.probability(greetingToday,"Oh no, not again!"))
	}
}