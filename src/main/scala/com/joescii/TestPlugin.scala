package com.joescii

import org.webjars.WebJarAssetLocator
import sbt.Plugin

object TestPlugin {
  val locator = new WebJarAssetLocator()
  lazy val jasmine = locator.getFullPath("jasmine.js")
}

class TestPlugin extends Plugin {
  import TestPlugin._

}