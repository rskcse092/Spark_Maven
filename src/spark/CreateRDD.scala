package spark

import org.apache.spark.sql.SparkSession

object CreateRDD extends App{
  val spark = SparkSession.builder().master("local").appName("create RDD").getOrCreate()

  //from parallelize
  val rdd1 = spark.sparkContext.parallelize(Seq(("Java", 20000),
    ("Python", 100000), ("Scala", 3000)))
  rdd1.foreach(println)

//from textFile
  val rdd2 = spark.sparkContext.textFile("Input/text01.csv")
  rdd2.foreach(println)

  val rdd3 = spark.sparkContext.wholeTextFiles("Input/demo.txt")
  rdd3.collect()
  rdd3.foreach(println)
  rdd3.foreach(record => println("FileName : " + record._1 + ", FileContents :" + record._2))
  rdd3.foreach(r => println( r._1 , r._2))
//from existing rdd
  val rdd4 = rdd3.map(row => {
    (row._1, row._2 + 100)
  })
  rdd4.foreach(println)

  // from existing df or data set
  val myRdd5 = spark.range(20).toDF().rdd
  myRdd5.foreach(println)

}
