case class KeyValue(key: Long, value: String)
case class KeyValueRow(kv: KeyValue)
val df = Seq(
  KeyValueRow(KeyValue(1L, "a")),
  KeyValueRow(KeyValue(2L, "b")),
  KeyValueRow(KeyValue(3L, "c")),
  KeyValueRow(KeyValue(4L, "d"))
).toDF

import org.apache.spark.sql._
import org.apache.spark.sql.types._

val udf = PublicUserDefinedFunction(
  f = (in: Row) => if (in.isNullAt(1)) null else in.getString(1),
  inputTypes = Some(List(
    StructType(List(
      StructField("key", LongType, true),
      StructField("value", StringType, true)
    ))
  )),
  dataType = StringType
)

df.select(udf(df("kv"))).show
