package spark

import org.apache.spark.sql.SparkSession

object ReadCsv extends App{
  val spark = SparkSession.builder().master("local").appName("read file app").getOrCreate()
  println("Info: creating rdd  to read single csv file")
  val fileRdd1 = spark.sparkContext.textFile("C:\\Users\\CSC\\IdeaProjects\\Spark_Maven\\Input\\text01.csv")
  //val fileRdd2 = spark.sparkContext.textFile("C:\\Users\\CSC\\IdeaProjects\\Spark_Maven\\Input\\text02.csv",2)
  fileRdd1.foreach(f=>{
    println("Col1:"+f(0)+",Col2:"+f(1))
  })
  fileRdd1.foreach(println)
  //fileRdd2.foreach(f=>println(f))
  println("no of partition in first rdd", fileRdd1.getNumPartitions)
 // println("no of partition in second rdd", fileRdd2.getNumPartitions)
  val rdd2= fileRdd1.map(x=>x.split(","))
  rdd2.foreach(f=>println(f))
}
