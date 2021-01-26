package partial2

import com.cra.figaro.language._
import com.cra.figaro.library.compound.{If, CPD, RichCPD, OneOf}
import com.cra.figaro.algorithm.factored.VariableElimination

object partial2
{
  def main(args: Array[String])
  {
    val chapters = 24
    val learn: Array[Element[Symbol]] = Array.fill(chapters)(Constant('putin))
    val score: Array[Element[Int]] = Array.fill(chapters)(Constant('nu_iau_umbrela))
    val passes: Array[Element[Symbol]] = Array.fill(chapters)(Constant('picat))

    learn(0) = Select(0.2 -> 'putin, 0.5 -> 'mediu, 0.3 -> 'tot)
    for { chapter <- 1 until chapters }
    {
      learn(chapter) = CPD(learn(chapter - 1),
        'insorit -> Select(0.1 -> 'ploios, 0.3 -> 'innorat, 0.6 -> 'insorit),
        'ploios -> Select(0.15 -> 'insorit, 0.45 -> 'ploios, 0.4 -> 'innorat),
        'innorat -> Select(0.3 -> 'insorit, 0.35 -> 'ploios , 0.5 -> 'innorat))
    }

    for { chapter <- 0 until chapters }
    {
      score(chapter) = CPD(learn(chapter),
        'tot -> Select(0.1 -> 1, 0.1 -> 2, 0.3 -> 3, 0.7 -> 4, 0.5 -> 5),
        'mediu -> Select(0.1 -> 1, 0.4 -> 2, 0.8 -> 3, 0.5 -> 4, 0.1 -> 5),
        'putin -> Select(0.4 -> 1, 0.6 -> 2, 0.2 -> 3, 0.1 -> 4, 0.1 -> 5))
    }

    for { chapter <- 0 until chapters }
    {
      passes(chapter) = RichCPD(score(chapter),
        OneOf(1, 2) -> Constant('picat),
        OneOf(3, 4) -> Constant('trecut),
        OneOf(5) -> Constant('success))
    }

    println(VariableElimination.probability(passes(9), 'success))

    passes(0).observe('trecut)
    println(VariableElimination.probability(passes(9), 'success))

    passes(1).observe('trecut)
    println(VariableElimination.probability(passes(9), 'success))

    passes(2).observe('trecut)
    println(VariableElimination.probability(passes(9), 'success))

  }
}