package Lab2

abstract class Persoana

class Student(var nume: String, var prenume: String, var an: Int, var materii: Array[(String,Int)]) extends Persoana{
    def setNota(materie: String, nota: Int){
        materii(materii.indexWhere(_._1 == materie)) = materii(materii.indexWhere(_._1 == materie)).copy(_2 = nota) 
    }
    
    def addMaterie(materie: String, nota: Int){
        materii :+= (materie,nota)
    }

    def getNota(materie: String){
        materii.foreach(x => if (x._1 == materie) println(x._2))
    }
}

class Profesor(var nume: String,var prenume: String, var materie: String) extends Persoana 

object Ex1{
    def whatIs(x: Persoana): Unit = {
        x.getClass.getSimpleName match{
            case "Student" => println("Este student.")
            case "Profesor" => println("Este profesor.")
            case _ => println("Necunoscut")
        }
    }

    def main(args: Array[String]){
        val list = Array("Logica", "Mate", "Sport")
        val a1 = new Student("Gigel","Popescu",1,list zip Array.fill(3){scala.util.Random.nextInt(11)})
        val a2 = new Student("Marinela","Alelia",1,list zip Array.fill(3){scala.util.Random.nextInt(11)})
        val a3 = new Student("Gica","Petrescu",1,list zip Array.fill(3){scala.util.Random.nextInt(11)})
        whatIs(a1)
        a2.materii.foreach(println)
        a2.addMaterie("Ag",3)
        a2.materii.foreach(println)
        a2.setNota("Ag",10)
        a2.getNota("Ag")
    }    
}