
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SparkDemo {
    public static void main(String[] args) {
        SparkSession sparkSession = SparkSession.builder().master("local")
                .appName("Spark_Demo").getOrCreate();
        String filePath = SparkDemo.class.getResource("src/resources/sample.csv").getPath();
        Dataset<Row> dataset = sparkSession.sqlContext().read()
                .format("com.databricks.spark.csv").load(filePath);
        dataset.show();
    }
}
