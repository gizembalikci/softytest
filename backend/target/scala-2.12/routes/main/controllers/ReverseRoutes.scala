
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/cagdas/softytestFinal/backend/conf/routes
// @DATE:Sun Dec 31 01:27:11 GMT 2017

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:22
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def versioned(file:String): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:8
  class ReverseCountController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def count(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "count")
    }
  
  }

  // @LINE:12
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def destroy(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users/delete/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:14
    def show(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:15
    def edit(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users/edit/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:13
    def create(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users/create")
    }
  
    // @LINE:17
    def save(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "users/create")
    }
  
    // @LINE:16
    def update(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "users/edit")
    }
  
    // @LINE:20
    def authenticate(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "users/login/")
    }
  
    // @LINE:12
    def index(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users")
    }
  
    // @LINE:19
    def login(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users/login/")
    }
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:10
  class ReverseAsyncController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def message(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "message")
    }
  
  }


}