import play.Project._

name := """de.htwg.se.SetGame.wui"""

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "org.webjars" %% "webjars-play" % "2.2.2", 
  "org.webjars" % "bootstrap" % "2.3.1",
  "com.google.inject" % "guice" % "3.0",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.2.0",
  "org.ektorp" % "org.ektorp" % "1.3.0",
  "org.hibernate" % "hibernate-annotations" % "3.5.6-Final",
  "org.hibernate" % "ejb3-persistence" % "1.0.2.GA",
  "javassist" % "javassist" % "3.12.1.GA",
  "mysql" % "mysql-connector-java" % "5.1.35"
)

playJavaSettings
