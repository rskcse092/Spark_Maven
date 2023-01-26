package scala
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
object SparkRdd extends App {

  val spark = SparkSession.builder()
    .master("local[1]")
    .appName("SparkByExample")
    .getOrCreate();

  println("First SparkContext:")
  println("APP Name :" + spark.sparkContext.appName);
  println("Deploy Mode :" + spark.sparkContext.deployMode);
  println("Master :" + spark.sparkContext.master);

  val sparkSession2 = SparkSession.builder()
    .master("local[1]")
    .appName("SparkByExample-test")
    .getOrCreate();

  println("Second Spark Session:")
  println("APP Name :" + sparkSession2.sparkContext.appName);
  println("Deploy Mode :" + sparkSession2.sparkContext.deployMode);
  println("Master :" + sparkSession2.sparkContext.master);

  val rdd: RDD[Int] = spark.sparkContext.parallelize(List(1, 2, 3, 4, 5))
  val rddCollect: Array[Int] = rdd.collect()
  println("Number of Partitions: " + rdd.getNumPartitions)
  println("Action: First element: " + rdd.first())
  println("Action: RDD converted to Array[Int] : ")
  rddCollect.foreach(println)
  println("end of the program")

}
