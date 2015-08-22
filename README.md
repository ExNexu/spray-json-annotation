spray-json-annotation
=====================

[![Build Status](https://travis-ci.org/ExNexu/spray-json-annotation.svg?branch=master)](https://travis-ci.org/ExNexu/spray-json-annotation) [![Coverage Status](https://coveralls.io/repos/ExNexu/spray-json-annotation/badge.svg?branch=master)](https://coveralls.io/r/ExNexu/spray-json-annotation?branch=master)

**Scala macro annotations generating spray-json JsonFormats for case classes.**

## Get started

Add this to your `build.sbt` (for Scala 2.10 & 2.11):

```scala
resolvers += "bleibinha.us/archiva releases" at "http://bleibinha.us/archiva/repository/releases"

libraryDependencies ++= Seq(
  "us.bleibinha" %% "spray-json-annotation" % "0.5"
)

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0-M5" cross CrossVersion.full)
```

Use it in code:

```scala
import spray.json._
import spray.json.DefaultJsonProtocol._
import us.bleibinha.spray.json.macros._

@jsonstrict
case class User(name: String, password: String)
```

This will be generated by the compiler:
```scala

@jsonstrict
case class User(name: String, password: String)

object User {
  implicit val jsonAnnotationFormat: RootJsonFormat[User] = jsonFormat2(User.apply)
}
```

`@json` can be used if the case class has only one field and you don't want to generate a full-blown json object. For more usage examples see the test implementation: [JsonFormatAnnotationTest.scala](https://github.com/ExNexu/spray-json-annotation/blob/master/src/test/scala/us/bleibinha/macros/JsonFormatAnnotationTest.scala)

## Version history

### 0.5
* Update dependency and plugin versions

### 0.4
* First stable release

## Background

Code base from [kifi/json-annotation](https://github.com/kifi/json-annotation) which provides json annotations for play-json. More information on their blog: http://eng.kifi.com/scala-macro-annotations-real-world-example/

This implements the same annotiations but with [spray/spray-json](https://github.com/spray/spray-json) as the underlying Scala json library.

## License

[MIT License](https://github.com/ExNexu/spray-json-annotation/blob/master/LICENSE)
