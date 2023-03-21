package spark

import org.apache.spark.sql.SparkSession
//import org.apache.spark.sql.functions._

object PairFunction extends App{
  val spark = SparkSession.builder().master("local").appName("pair rdd").getOrCreate()
  val rdd = spark.sparkContext.parallelize(Seq("USA UK GERMANY", "USA AUSTRELIA UK", "JAPAN FRANCE DUBAI"))
  rdd.collect()
  println("counting words using groupByKey")
  println(rdd.flatMap(_.split(" ")).map(w=>(w,1)).groupByKey().map(x=>(x._1,x._2.sum)).collect())
  println("counting words using reduceByKey")
  println(rdd.flatMap(_.split(" ")).map(w=>(w,1)).reduceByKey(_+_).collect())
}
