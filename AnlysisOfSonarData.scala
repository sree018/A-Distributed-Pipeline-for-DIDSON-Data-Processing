package com.DidSonData
import org.apache.spark.{ SparkConf, SparkContext }
import org.apache.hadoop.io._




object AnlysisOfSonarData extends App {
  val conf = new SparkConf().setAppName("analysis of sonar data").setMaster("local[*]")

  val sc = new SparkContext(conf)
  val rawData = sc.sequenceFile(
    "/home/srinu/datasets/SonarVideoData/DIDSON-MR-Pipeline",
    classOf[org.apache.hadoop.io.Text], classOf[org.apache.hadoop.io.BytesWritable])
 
  val data = rawData.map(x => x._2.getBytes.length).foreach(println)
  

}