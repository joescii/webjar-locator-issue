resolvers += "Local Maven Repository" at Path.userHome.asFile.toURI.toURL + ".m2/repository"

addSbtPlugin("com.joescii" % "webjar-locator-issue" % "0.1.0-SNAPSHOT")