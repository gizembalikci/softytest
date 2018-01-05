
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/cagdas/softytestFinal/backend/conf/routes
// @DATE:Fri Jan 05 13:11:20 GMT 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:26
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:27
    def at(file:String): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public/images"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/images/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
    // @LINE:26
    def versioned(file:String): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:14
  class ReverseTestController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def codingQuestion(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "coding")
    }
  
    // @LINE:14
    def categories(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "categories")
    }
  
  }

  // @LINE:17
  class ReverseCountController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def count(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "count")
    }
  
  }

  // @LINE:6
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:24
    def destroy(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users/delete/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:22
    def show(id:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("id", id)))
    }
  
    // @LINE:21
    def showAll(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users")
    }
  
    // @LINE:10
    def edit(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "profile/edit")
    }
  
    // @LINE:9
    def profile(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "profile")
    }
  
    // @LINE:12
    def logout(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logout")
    }
  
    // @LINE:7
    def save(): Call = {
      
      Call("POST", _prefix)
    }
  
    // @LINE:11
    def update(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "profile/edit")
    }
  
    // @LINE:8
    def authenticate(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "users/login/")
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:19
  class ReverseAsyncController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def message(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "message")
    }
  
  }


}
