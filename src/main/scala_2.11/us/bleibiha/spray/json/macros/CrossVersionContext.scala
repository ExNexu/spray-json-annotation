package us.bleibinha.spray.json.macros

import scala.annotation.StaticAnnotation
import scala.language.experimental.macros
import scala.reflect.macros._

object CrossVersionDefs {

  // Context has been deprecated in Scala 2.11, blackbox.Context is used instead
  type CrossVersionContext = blackbox.Context

  // newTermName has been deprecated in Scala.11, TermName() is used isntead
  def getTermNameFromString(string: String, context: CrossVersionContext) = {
    import context.universe._
    TermName(string)
  }
}
