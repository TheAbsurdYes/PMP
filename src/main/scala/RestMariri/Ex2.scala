package RestMariri

import com.cra.figaro.algorithm.sampling.Importance
import com.cra.figaro.language.Select
import com.cra.figaro.library.atomic.continuous.Normal

object Ex2 {
  def main(args: Array[String]) {
    val variatie = Select(0.5 -> 20.0, 0.5 -> 30.0)
    val temperatura = Normal(7,variatie)
    temperatura.observe(9)
    //cand adaugam aceasta linie prob va fi mereu 0.0
    println("Probabilitatea : " + Importance.probability(temperatura, (d: Double) => d >= 20 && d <= 50))
    //Probabilitatea va fi 0.006000000000000064
  }
}