//package Lab8
//
//import breeze.linalg.InjectNumericOps
//import com.cra.figaro.language._
//import com.cra.figaro.algorithm.sampling._
//import com.cra.figaro.library.atomic.continuous.{Normal, Uniform}
//import com.cra.figaro.library.collection.Container
//
////Your firm has five departments: Research and Development, Production, Sales,
////Human Resources, and Finance. Build an object-oriented probabilistic model
////that captures the influences between these departments. Use the model to answer
////queries about the health of the firm based on the state of the departments.
//
//class HumanReasources {
//	val productivityLevel = Uniform(0,1)
//}
//
//class ReaserchAndDevelopment(people: List[HumanReasources]) {
//	private val productivityContainer = Container(people.map(_.productivityLevel):_x)
//	private val productivityMean = productivityContainer.foldLeft(0.0)(_ max _)
//}
//
//class Production extends ReaserchAndDevelopment(people: List[HumanReasources]){
//	val productivity = Normal(productivityMean,0.01)
//}
//
//class Sales (){
//	val numberOfCustomers = scala.util.Random.nextInt(1000)
//}
//
//class Finance extends Sales with Production{
//	def isHealthy: Boolean ={
//			if (numberOfCustomers*productivity > 100)
//					return true
//			else false
//	}
//}
//
//object Ex1 {
//	def main(args: Array[String]) {
//		val humans = List.fill(10){new HumanReasources}
//		val team = new ReaserchAndDevelopment(humans)
//		val finance = new Finance(humans)
//		println("Is this company healthy: " + finance.isHealthy.toString)
//	}
//}