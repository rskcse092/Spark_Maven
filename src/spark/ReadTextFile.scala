package spark

import org.apache.spark.sql.SparkSession
//import shapeless.syntax.std.tuple.productTupleOps
object ReadTextFile extends App {
  val spark = SparkSession.builder().master("local")
    .appName("read file app").getOrCreate()
  println("Info: creating rdd  to read single file")
  val fileRdd1 = spark.sparkContext.wholeTextFiles("C:\\Users\\CSC\\IdeaProjects\\Spark_Maven\\Input\\text01.txt")
  fileRdd1.foreach(println)
 // val fileRdd2 = spark.sparkContext.wholeTextFiles("C:\\Users\\CSC\\IdeaProjects\\Spark_Maven\\Input\\text02.txt")
//  val wcountRdd = fileRdd1.flatMap(x => x.split(",")).map(w => (w, 1)).reduceByKey(_ + _)
//  wcountRdd.foreach {
//    println
//  }
}
