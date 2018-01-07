
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/gizem/Desktop/softytest/backend/conf/routes
// @DATE:Sat Jan 06 18:39:09 EET 2018


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
