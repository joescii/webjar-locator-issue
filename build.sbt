sbtPlugin := true

name := "webjar-locator-issue"

organization := "com.joescii"

homepage := Some(url("https://github.com/joescii/webjar-locator-issue"))

version := "0.1.0-SNAPSHOT"

val jasmineVersion = settingKey[String]("Version of jasmine")
jasmineVersion := "2.4.1"

val webjarLocatorVersion = settingKey[String]("Version of webjar locator")
webjarLocatorVersion := "0.31-SNAPSHOT"

libraryDependencies ++= Seq(
  "org.webjars"               %  "webjars-locator-core"  % webjarLocatorVersion.value,
  "org.webjars.bower"         %  "jasmine"               % jasmineVersion.value
)

resolvers += "Local Maven Repository" at Path.userHome.asFile.toURI.toURL + ".m2/repository"

// don't bother publishing javadoc
publishArtifact in (Compile, packageDoc) := false

sbtVersion in Global := {
  scalaBinaryVersion.value match {
    case "2.10" => "0.13.9"
//    case "2.9.2" => "0.12.4"
  }
}

scalaVersion in Global := "2.10.5"

crossScalaVersions := Seq("2.10.5")

scalacOptions ++= Seq("-unchecked", "-deprecation")

licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html"))
