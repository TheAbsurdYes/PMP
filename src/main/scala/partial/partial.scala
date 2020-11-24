package partial

import com.cra.figaro.language._
import com.cra.figaro.algorithm.sampling._
import com.cra.figaro.library.compound.If

class partial {

  def main(args: Array[String]): Unit = {
    val fogotToAlaram = Flip(0.1)
    // probabilitatea cu care uita sa isi seteze alarama
    val nuTeTrezesti = Flip(0.1)
    // prob ca nu se trezeste
    val bus = Flip(0.2)
    // prob cu care intarzie autobuz-ul
    val rateOfLateness = If(forgotToAlarm, bus)
    // as fi foloseit un If cu select-uri pentru a determina toate cazurile
    val willBeLate = If()
  }
}
