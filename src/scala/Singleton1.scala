package scala

object Singleton1 {
  def main(args: Array[String]): Unit = {
    println("this is singleton  method call")
    SingletonObject.show1()
  }

}

object SingletonObject {
  def show1() = {
    println("singleton object is called")
  }
}
