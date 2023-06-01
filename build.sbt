ThisBuild / scalaVersion := "3.2.2"
ThisBuild / compileOrder := CompileOrder.JavaThenScala

val DataStructureAlgorithm = (project in file("."))
  .settings {
    name := "DataStructureAlgorithm"
    scalaVersion := "3.2.2"
    javacOptions ++= Seq("-source", "17")
    libraryDependencies ++= Seq(
      "junit" % "junit" % "4.11",
      "org.apache.logging.log4j" % "log4j-api" % "2.17.2",
      "org.apache.logging.log4j" % "log4j-core" % "2.17.2",
      "org.eclipse.collections" % "eclipse-collections-api" % "11.0.0",
      "org.eclipse.collections" % "eclipse-collections" % "11.0.0",
      )
  }