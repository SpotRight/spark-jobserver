import sbt._
import Keys._
import sbtassembly.AssemblyPlugin.autoImport._

object Assembly {
  lazy val settings = Seq(
    assemblyJarName in assembly := "spark-job-server.jar",
    // uncomment below to exclude tests
    // test in assembly := {},
    assemblyExcludedJars in assembly <<= (fullClasspath in assembly) map { _ filter { cp =>
      List("servlet-api", "guice-all", "junit", "uuid",
        "jetty", "jsp-api-2.0", "antlr", "avro", "slf4j-log4j", "log4j-1.2",
        "scala-actors", "spark", "commons-cli", "stax-api", "mockito").exists(cp.data.getName.startsWith(_))
    } },
    // We don't need the Scala library, Spark already includes it
    assembleArtifact in assemblyPackageScala := false,
    assemblyMergeStrategy in assembly := {
      case m if m.toLowerCase.endsWith("manifest.mf") => MergeStrategy.discard
      case m if m.toLowerCase.matches("meta-inf.*\\.sf$") => MergeStrategy.discard
      case "reference.conf" => MergeStrategy.concat
      case _ => MergeStrategy.first
    }//,
    // NOTE(velvia): Some users have reported NoClassDefFound errors due to this shading.
    // java.lang.NoClassDefFoundError: sjs/shapeless/Poly2$Case2Builder$$anon$3
    // This is disabled for now, if you really need it, re-enable it and good luck!
    // assemblyShadeRules in assembly := Seq(
    //   ShadeRule.rename("shapeless.**" -> "sjs.shapeless.@1").inAll
    // )

    /**
      * Needed for jar built and included on spark classpath, but won't work for starting jobserver on js01
      */
    , assemblyShadeRules in assembly := {
      val shadePackage = "shade.spark.jobserver"
      Seq(
        ShadeRule.rename("com.google.common.**" -> s"$shadePackage.google.common.@1").inAll,
        ShadeRule.rename(
          "com.google.thirdparty.publicsuffix.**" -> s"$shadePackage.google.thirdparty.publicsuffix.@1"
        ).inAll
      )
    }
  )
}
