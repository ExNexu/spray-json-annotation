spray-json-annotation
=====================

**Scala macros for creating spray-json JsonFormat's for case classes.**

Code base from [kifi/json-annotation](https://github.com/kifi/json-annotation) which provides json annotations for play-json. More information on their blog: http://eng.kifi.com/scala-macro-annotations-real-world-example/

This implements the same annotiations but with [spray/spray-json](https://github.com/spray/spray-json) as the underlying json-library. For usage examples see the test implementation: [JsonFormatAnnotationTest.scala](https://github.com/ExNexu/spray-json-annotation/blob/master/src/test/scala/us/bleibinha/macros/JsonFormatAnnotationTest.scala)

## Get started

Add this to your `build.sbt`:

```scala
resolvers += "bleibinha.us/archiva releases" at "http://bleibinha.us/archiva/repository/releases"

libraryDependencies ++= Seq(
  "us.bleibinha" %% "spray-json-annotation" % "0.2"
)

addCompilerPlugin("org.scalamacros" % "paradise" % "2.0.1" cross CrossVersion.full)
```
