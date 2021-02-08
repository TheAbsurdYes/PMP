package RestMariri

import com.cra.figaro.language.{Constant, Element, Flip, Select}
import com.cra.figaro.library.compound.CPD

object Ex3 {

  abstract class State(chapters: Int) {
    val systemState: Array[Element[Boolean]] = Array.fill(chapters)(Constant(false))
    val value: Array[Element[String]] = Array.fill(chapters)(Constant('buna))
  }

  class initialState() extends State {
    // setting initial probabilities for each state:
    state(0) = Select(0.721 -> 'buna, 0.202 -> 'nu_prea_buna, 0.067 -> 'bolnav, 0.1 -> 'decedat)
    value(0) = CPD(state(0),
      'buna -> Flip(0.25),
      'nu_prea_buna -> Flip(0.25),
      'bolnav -> Flip(0.25),
      'decedat -> Flip(0.25))
  }

  class NextState(current: State, iteration: Int) extends State {

    state(iteration) = CPD(state(chapters - 1),
      'buna -> Select(0.721 -> 'buna, 0.202 -> 'nu_prea_buna, 0.067 -> 'bolnav, 0.1 -> 'decedat),
      'nu_prea_buna -> Select(0 -> 'buna, 0.581 -> 'nu_prea_buna, 0.407 -> 'bolnav, 0.012 -> 'decedat),
      'bolnav -> Select(0 -> 'buna, 0 -> 'nu_prea_buna, 0.75 -> 'bolnav, 0.25 -> 'decedat),
      'decedat -> Select(0 -> 'buna, 0 -> 'nu_prea_buna, 0-> 'bolnav, 1.0 -> 'decedat),
    )

    value(iteration) = CPD(state(iteration),
      'buna -> Flip(0.25),
      'nu_prea_buna -> Flip(0.25),
      'bolnav -> Flip(0.25),
      'decedat -> Flip(0.25))
  }

  def main(args: Array[String])
  {
  }
}

