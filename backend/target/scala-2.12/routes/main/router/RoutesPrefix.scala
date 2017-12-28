
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/gizem/Desktop/softytest/backend/conf/routes
// @DATE:Wed Dec 20 14:38:09 EET 2017


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
