package us.bleibinha.spray.json.macros

import scala.annotation.StaticAnnotation
import scala.language.experimental.macros
import scala.reflect.macros._

object CrossVersionDefs {

  // Scala 2.10 uses Context (doesn't know about blackbox and whitebox)
  type CrossVersionContext = Context

  // Scala 2.10 uses newTermName (can't handle TermName())
  def getTermNameFromString(string: String, context: CrossVersionContext) = {
    import context.universe._
    newTermName(string)
  }
}
