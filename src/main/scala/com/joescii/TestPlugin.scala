package com.joescii

import java.io.{InputStreamReader, BufferedReader}

import org.webjars.WebJarAssetLocator
import sbt.Keys._
import sbt._

object TestPlugin extends Plugin {
  private [this] def read(classpath:String):String = {
    val url = this.getClass.getClassLoader.getResource(classpath)
    val r = new BufferedReader(new InputStreamReader(url.openStream()))
    Iterator.continually(r.readLine()).takeWhile(_ != null).mkString("\n")
  }

  val writeWebjars = TaskKey[Seq[File]]("writeWebjars", "Writes webjar JavaScript assets to target")
  val writeWebjarsTask = (streams, target in sbt.Compile).map { (s, target) =>
    s.log.info("Writing webjar assets...")
    IO.write(target / "jasmine.js", read(Jasmine.path))
    Seq(target / "jasmine.js")
  }
}