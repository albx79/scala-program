ThisBuild / name := "ScalaProject"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.2.1"
ThisBuild / mainClass := Some("it.albx79.main")

lazy val root = (project in file("."))
  .settings(
    name := "a-scala-project",
    idePackagePrefix := Some("it.albx79")
  )

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.15" % Test
)

assembly / assemblyJarName := "exercise.jar"
