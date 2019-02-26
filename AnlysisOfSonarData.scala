package com.DidSonData
import org.apache.spark.{ SparkConf, SparkContext }
import org.apache.hadoop.io._
import org.apache.spark.sql._
import java.util.Arrays;
import java.nio.{ ByteBuffer, ByteOrder }

object AnlysisOfSonarData extends App {
  val conf = new SparkConf().setAppName("analysis of sonar data").setMaster("local[*]")
  val sc = new SparkContext(conf)
  val rawData = sc.sequenceFile("/home/datasets/SonarVideoData/DIDSON-MR-Pipeline", classOf[org.apache.hadoop.io.Text], classOf[org.apache.hadoop.io.BytesWritable])
  val lengthOfData = rawData.mapValues(x => x.getLength)
  val CopyToBytesData = rawData.map(t => t._2.copyBytes()).collect().flatten
  val widthHeightBytes = Arrays.copyOfRange(CopyToBytesData, 0, 4)
  val widthOfFrame = bytebuffer(widthHeightBytes, 0, 1)
  val heightOfFrame = bytebuffer(widthHeightBytes, 2, 3)
println(widthOfFrame,heightOfFrame)
  def bytebuffer(elem: Array[Byte], x: Int, y: Int): Int = {
    val bb = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN).put(elem(x)).put(elem(y))
    val value = bb.getShort(0) 
    return value
  }

}
