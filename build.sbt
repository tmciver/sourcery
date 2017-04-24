
lazy val root = (project in file("."))
  .settings(
    organization := "com.maxwellhealth",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "2.12.1",
    name := "sourcery"
//    libraryDependencies += derby
  )
