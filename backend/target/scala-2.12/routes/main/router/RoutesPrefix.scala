
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/cagdas/softytestFinal/backend/conf/routes
// @DATE:Sun Dec 31 01:27:11 GMT 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
