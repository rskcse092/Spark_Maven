package spark

import org.apache.spark.sql.SparkSession


object Dataf extends App {
  val spark = SparkSession.builder().master("local").appName("sparkdf").getOrCreate()
  spark.sparkContext.setLogLevel("ERROR")
  val df = spark.read.format("csv").option("header", true).option("InferSchema",true).load("Input/Electric_Vehicle_Population_Data.csv")
  df.show(20)
  print(df.count())
  println("using createOrReplacetempView temp view")
  println(df.createOrReplaceTempView("ElectricVcl"))
  spark.sql("select * from ElectricVcl").show
  //counting the no of car sold for a particular model yearwise
  spark.sql("select `Model Year`,Make ,Model, count(Model) from ElectricVcl group by 1,2,3 order by `Model Year`,Make asc;").show(10000)
  val df1 = df.groupBy("Model Year","Make","Model")
  df1.count().show()
//  df.write.parquet("C:\\Users\\CSC\\IdeaProjects\\Spark_Maven\\output\\electric_vechile_pop")
}
