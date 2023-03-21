package scala

object Function111 {
  def main(args: Array[String]): Unit = {
    println("hello scala")
    //function
    add()
    val sum = add1(3, 4)
    println(s"addition of two no is :$sum")
    val sum1 = add2(12, 12)
    println(s"addition is : $sum1")

    val sum2 = add2(12)
    println(s"addition is : $sum2")
    //higher order
    functionExample(25, multiplyBy2)
    //composite
    val result = add_by2(multiply_by2(30))
    println(s"result of add and mul by 2 is : $result")

    val iresult = (a: Int, b: Int) => a + b
    val iresult1 = (_: Int) + (_: Int)
    println(iresult(10, 30))
    println(iresult(25, 25))
    println(iresult1(30, 30))
    //currying
    val summation = addi(50)(50)
    println(summation)
  }

  def add() = {
    println("addition is done here")
  }

  def add1(a: Int, b: Int) = {
    a + b
  }

  def add2(i: Int = 0, i1: Int = 0) = {
    i + i1
  }

  def multiplyBy2(a: Int): Int = {
    a * 2
  }

  def functionExample(a: Int, f: Int => AnyVal): Unit = {
    println(f(a))
  } // Calling that function

  def add_by2(t: Int) = {
    t + 2
  }

  def multiply_by2(u: Int) = {
    u * 2
  }


  //varargs
  def add10(args: Int*) = {
    var sum = 0;
    for (a <- args) sum += a
    sum
  }

  var sum = add10(1, 2, 3, 4, 5, 6, 7, 8, 9);
  println("sum of multiple no is:")
  println(sum);

  //currying
  def addi(a: Int)(b: Int) = {
    a + b
  }
}
