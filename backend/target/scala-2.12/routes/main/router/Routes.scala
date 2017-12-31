
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/cagdas/softytestFinal/backend/conf/routes
// @DATE:Sun Dec 31 01:27:11 GMT 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_1: controllers.HomeController,
  // @LINE:8
  CountController_0: controllers.CountController,
  // @LINE:10
  AsyncController_2: controllers.AsyncController,
  // @LINE:12
  UserController_3: controllers.UserController,
  // @LINE:22
  Assets_4: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_1: controllers.HomeController,
    // @LINE:8
    CountController_0: controllers.CountController,
    // @LINE:10
    AsyncController_2: controllers.AsyncController,
    // @LINE:12
    UserController_3: controllers.UserController,
    // @LINE:22
    Assets_4: controllers.Assets
  ) = this(errorHandler, HomeController_1, CountController_0, AsyncController_2, UserController_3, Assets_4, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, CountController_0, AsyncController_2, UserController_3, Assets_4, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UserController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/create""", """controllers.UserController.create()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/""" + "$" + """id<[^/]+>""", """controllers.UserController.show(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/edit/""" + "$" + """id<[^/]+>""", """controllers.UserController.edit(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/edit""", """controllers.UserController.update()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/create""", """controllers.UserController.save()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/delete/""" + "$" + """id<[^/]+>""", """controllers.UserController.destroy(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/login/""", """controllers.UserController.login()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/login/""", """controllers.UserController.authenticate()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_1.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_CountController_count1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private[this] lazy val controllers_CountController_count1_invoker = createInvoker(
    CountController_0.count,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountController",
      "count",
      Nil,
      "GET",
      this.prefix + """count""",
      """ An example controller showing how to use dependency injection""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_AsyncController_message2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private[this] lazy val controllers_AsyncController_message2_invoker = createInvoker(
    AsyncController_2.message,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AsyncController",
      "message",
      Nil,
      "GET",
      this.prefix + """message""",
      """ An example controller showing how to write asynchronous code""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_UserController_index3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_UserController_index3_invoker = createInvoker(
    UserController_3.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "index",
      Nil,
      "GET",
      this.prefix + """users""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_UserController_create4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/create")))
  )
  private[this] lazy val controllers_UserController_create4_invoker = createInvoker(
    UserController_3.create(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "create",
      Nil,
      "GET",
      this.prefix + """users/create""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_UserController_show5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_show5_invoker = createInvoker(
    UserController_3.show(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "show",
      Seq(classOf[String]),
      "GET",
      this.prefix + """users/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_UserController_edit6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/edit/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_edit6_invoker = createInvoker(
    UserController_3.edit(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "edit",
      Seq(classOf[String]),
      "GET",
      this.prefix + """users/edit/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_UserController_update7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/edit")))
  )
  private[this] lazy val controllers_UserController_update7_invoker = createInvoker(
    UserController_3.update(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "update",
      Nil,
      "POST",
      this.prefix + """users/edit""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_UserController_save8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/create")))
  )
  private[this] lazy val controllers_UserController_save8_invoker = createInvoker(
    UserController_3.save(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "save",
      Nil,
      "POST",
      this.prefix + """users/create""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_UserController_destroy9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/delete/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_destroy9_invoker = createInvoker(
    UserController_3.destroy(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "destroy",
      Seq(classOf[String]),
      "GET",
      this.prefix + """users/delete/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_UserController_login10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/login/")))
  )
  private[this] lazy val controllers_UserController_login10_invoker = createInvoker(
    UserController_3.login(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "login",
      Nil,
      "GET",
      this.prefix + """users/login/""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_UserController_authenticate11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/login/")))
  )
  private[this] lazy val controllers_UserController_authenticate11_invoker = createInvoker(
    UserController_3.authenticate(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "authenticate",
      Nil,
      "POST",
      this.prefix + """users/login/""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_Assets_versioned12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned12_invoker = createInvoker(
    Assets_4.versioned(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_1.index)
      }
  
    // @LINE:8
    case controllers_CountController_count1_route(params@_) =>
      call { 
        controllers_CountController_count1_invoker.call(CountController_0.count)
      }
  
    // @LINE:10
    case controllers_AsyncController_message2_route(params@_) =>
      call { 
        controllers_AsyncController_message2_invoker.call(AsyncController_2.message)
      }
  
    // @LINE:12
    case controllers_UserController_index3_route(params@_) =>
      call { 
        controllers_UserController_index3_invoker.call(UserController_3.index())
      }
  
    // @LINE:13
    case controllers_UserController_create4_route(params@_) =>
      call { 
        controllers_UserController_create4_invoker.call(UserController_3.create())
      }
  
    // @LINE:14
    case controllers_UserController_show5_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_UserController_show5_invoker.call(UserController_3.show(id))
      }
  
    // @LINE:15
    case controllers_UserController_edit6_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_UserController_edit6_invoker.call(UserController_3.edit(id))
      }
  
    // @LINE:16
    case controllers_UserController_update7_route(params@_) =>
      call { 
        controllers_UserController_update7_invoker.call(UserController_3.update())
      }
  
    // @LINE:17
    case controllers_UserController_save8_route(params@_) =>
      call { 
        controllers_UserController_save8_invoker.call(UserController_3.save())
      }
  
    // @LINE:18
    case controllers_UserController_destroy9_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_UserController_destroy9_invoker.call(UserController_3.destroy(id))
      }
  
    // @LINE:19
    case controllers_UserController_login10_route(params@_) =>
      call { 
        controllers_UserController_login10_invoker.call(UserController_3.login())
      }
  
    // @LINE:20
    case controllers_UserController_authenticate11_route(params@_) =>
      call { 
        controllers_UserController_authenticate11_invoker.call(UserController_3.authenticate())
      }
  
    // @LINE:22
    case controllers_Assets_versioned12_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_versioned12_invoker.call(Assets_4.versioned(path, file))
      }
  }
}
