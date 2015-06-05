name := "Euler"

version := "0.1"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "3.6.1" % "test",
  "org.specs2" %% "specs2-scalacheck" % "3.6.1" % "test",
  "org.scalaz" %% "scalaz-core" % "7.0.6")

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

scalacOptions in Test ++= Seq("-Yrangepos")