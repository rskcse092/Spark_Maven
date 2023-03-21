package scala

class Student{
  var id:Int = 0
  var name:String = "ram"
}

class Student1(id:Int,name:String){
  def show(): Unit = {
    println("student1 id and name is :")
    println(id +" "+ name)
  }
}
class Airth1{
  def add100(a:Int,b:Int)={a+b}
}
object Opps {
  def main(args: Array[String]): Unit = {
    val st = new Student()
    println("id of student is :" + st.id)
    println("name of student is :" + st.name)

    val st1 = new Student1(100, "ram")
    st1.show()

    println("sum is :" + new Airth1().add100(10, 10))

  }
}


