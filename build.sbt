organization  := "de.frosner"

version       := "0.1.0-SNAPSHOT"

name          := "struct-udf"

scalaVersion  := "2.10.5"

val sparkVersion = "1.5.2"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion % "provided"

libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion % "provided"

fork := true

javaOptions += "-Xmx2G"

javaOptions += "-XX:MaxPermSize=128m"
