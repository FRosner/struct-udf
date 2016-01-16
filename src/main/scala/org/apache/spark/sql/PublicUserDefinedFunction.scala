package org.apache.spark.sql

import java.util.{List => JList, Map => JMap}

import org.apache.spark.sql.catalyst.expressions.{Expression, ScalaUDF}
import org.apache.spark.sql.types.DataType

case class PublicUserDefinedFunction(f: AnyRef,
                                     dataType: DataType,
                                     inputTypes: Option[Seq[DataType]]) {

  def apply(exprs: Column*): Column = {
    Column(ScalaUDF(f, dataType, exprs.map(_.expr), inputTypes.getOrElse(Nil)))
  }

}
