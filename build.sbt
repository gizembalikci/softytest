name := "backend"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.12.2"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)
  
libraryDependencies += guice
libraryDependencies += jdbc
libraryDependencies += ws
libraryDependencies += "com.h2database" % "h2" % "1.4.194"

libraryDependencies += "org.awaitility" % "awaitility" % "2.0.0" % Test
libraryDependencies += "org.assertj" % "assertj-core" % "3.6.2" % Test
libraryDependencies += "org.mockito" % "mockito-core" % "2.1.0" % Test
testOptions in Test += Tests.Argument(TestFrameworks.JUnit, "-a", "-v")

resolvers += Resolver.sbtPluginRepo("releases")

// Resolver is needed only for SNAPSHOT versions
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

libraryDependencies ++= Seq(
  "com.adrianhurt" %% "play-bootstrap" % "1.2-P26-B4"
)

libraryDependencies += "org.webjars.bower" % "bootstrap-sass" % "3.3.6"

libraryDependencies += filters
libraryDependencies += "org.mindrot" % "jbcrypt" % "0.3m"
