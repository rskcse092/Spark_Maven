package scala

class ComapnaionClass{

    def disp()={println("comp class  method is called from companion object")}
}

object Companion1{
def main(args: Array[String]): Unit = {
  new ComapnaionClass().disp()
}
}

