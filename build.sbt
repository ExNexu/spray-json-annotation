name := "spray-json-annotation"

organization := "us.bleibinha"

version := "0.6"

scalaVersion := "2.11.7"

crossScalaVersions := Seq("2.10.5", "2.11.7")

resolvers ++= Seq(Resolver.sonatypeRepo("releases"), "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/")

libraryDependencies <+= (scalaVersion)("org.scala-lang" % "scala-reflect" % _)

libraryDependencies ++= (
  if (scalaVersion.value.startsWith("2.10")) List("org.scalamacros" %% "quasiquotes" % "2.1.0-M5")
  else Nil
)

libraryDependencies ++= Seq(
  "io.spray" %% "spray-json" % "1.3.2" % Test,
  "org.specs2" %% "specs2-core" % "3.6.5" % Test
)

unmanagedSourceDirectories in Compile <+= (sourceDirectory in Compile, scalaBinaryVersion){
  (sourceDir, version) => sourceDir / (if (version.startsWith("2.10")) "scala_2.10" else "scala_2.11")
}

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0-M5" cross CrossVersion.full)

scalacOptions := Seq(
  "-encoding", "utf8",
  "-feature",
  "-unchecked",
  "-deprecation",
  "-target:jvm-1.6",
  "-language:_",
  "-Ywarn-dead-code",
  "-Xlog-reflective-calls"
)

// publishing:

aetherPublishSettings

credentials += Credentials(Path.userHome / ".ivy2" / ".us-bleibinha-snapshots-credentials")

credentials += Credentials(Path.userHome / ".ivy2" / ".us-bleibinha-releases-credentials")

publishMavenStyle := true

publishArtifact in Test := false

publishTo := {
  val archiva = "http://bleibinha.us/archiva/repository/"
  if (version.value.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at archiva + "snapshots")
  else
    Some("releases"  at archiva + "releases")
}

pomExtra :=
  <scm>
    <url>https://github.com/ExNexu/spray-json-annotation</url>
    <connection>scm:git@github.com:ExNexu/spray-json-annotation.git</connection>
  </scm>
  <developers>
    <developer>
      <id>exnexu</id>
      <name>Stefan Bleibinhaus</name>
      <url>http://bleibinha.us</url>
    </developer>
  </developers>
