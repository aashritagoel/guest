organization in ThisBuild := "com.knoldus"
version in ThisBuild := "1.0-SNAPSHOT"

// the Scala version that will be used for cross-compiled libraries
scalaVersion in ThisBuild := "2.12.4"

val macwire = "com.softwaremill.macwire" %% "macros" % "2.3.0" % "provided"
val scalaTest = "org.scalatest" %% "scalatest" % "3.0.4" % Test
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.16"
libraryDependencies += "log4j" % "log4j" % "1.2.17"

lazy val `guest` = (project in file("."))
  .aggregate(`guest-api`, `guest-impl`)

lazy val `guest-api` = (project in file("guest-api"))
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslApi
    )
  )

lazy val `guest-impl` = (project in file("guest-impl"))
  .enablePlugins(LagomScala)
  // This avoids adding the Lagom logging module to the classpath
  .settings(
  libraryDependencies ++= Seq(
    lagomScaladslPersistenceCassandra,
    lagomScaladslKafkaBroker,
    lagomScaladslTestKit,
    macwire,
    scalaTest
  )
)
  .settings(lagomForkedTestSettings: _*)
  .dependsOn(`guest-api`)

lagomCassandraEnabled in ThisBuild := false
lagomUnmanagedServices in ThisBuild := Map("external-service" -> "https://gist.githubusercontent.com")
