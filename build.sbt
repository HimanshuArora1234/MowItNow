name := "MowItNow"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
	"org.scalafx" %% "scalafx" % "8.0.92-R10",
	"junit" % "junit" % "4.8.1" % "test"
)

unmanagedJars in Compile += {
	val ps = new sys.SystemProperties
	val jh = ps("java.home")
	Attributed.blank(file(jh) / "lib/ext/jfxrt.jar")
}