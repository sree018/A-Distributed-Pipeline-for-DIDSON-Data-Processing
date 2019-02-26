import twitter4j._
import twitter4j.conf.ConfigurationBuilder
import org.apache.spark.sql.SparkSession
import twitter4j.auth.OAuth2Authorization
import org.apache.spark.Streaming.StreamingContext

object dataReader{
  def main(args:Array[String]): Unit ={
   val spark = SparkSession.builder().appName("analysis of spark").master("local[*]").getOrCreate()
    val ssc = spark.readStream.


  }
  def Util():Some[OAuth2Authorization]= {
    val consumerKey = "53U1KNTEmnEO1YrfZvnL0vWVm"
    val consumerSecret = "mcp8UaKMlwQlqqV7rxB0E6nBh4v4JALfYfEzshIqQp5cXvDJsS"
    val accessToken = "811348375031476224-ftyGcZK1kpdesai2rTunKbLbADy1R0O"
    val accessTokenSecret = "y7VlzNapBOkIDnbME6orR3hlN4BRqh7FAfwIseS1U1DKE"
    val cb = new ConfigurationBuilder
    cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey)
      .setOAuthConsumerSecret(consumerSecret)
      .setOAuthAccessToken(accessToken)
      .setOAuthAccessTokenSecret(accessTokenSecret)
    val auth = new OAuthAuthorization(cb.build)
    return auth
  }
}