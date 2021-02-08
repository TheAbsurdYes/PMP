package RestMariri

import com.cra.figaro.algorithm.factored.VariableElimination
import com.cra.figaro.language.Apply
import com.cra.figaro.library.atomic.discrete.Binomial
import com.cra.figaro.library.compound._

object Ex1 {
  def main(args: Array[String]) {
    val zileCuNinsoare = Binomial(7, 0.6)
    def getQuality(i: Int): String =
      if (i > 5) "prea multa ninsoare";
      else if (i <= 2) "prea putina ninsoare";
      else "normala"
    val prognozaSaptamanii = Apply(zileCuNinsoare, getQuality)
    // primul pas
    println(VariableElimination.probability(prognozaSaptamanii, "normala"))
    // al doilea pas
    prognozaSaptamanii.generate()
    println("Valoarea generata este " + prognozaSaptamanii.value)
    // de rulat de mai multe ori
  }
}