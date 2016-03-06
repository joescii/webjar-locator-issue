package com.joescii

import org.webjars.WebJarAssetLocator

object Jasmine {
  val locator = new WebJarAssetLocator()
  lazy val path = locator.getFullPath("jasmine.js")
}
