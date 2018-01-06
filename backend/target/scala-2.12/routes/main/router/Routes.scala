
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/gizem/Desktop/softytest/backend/conf/routes
// @DATE:Sat Jan 06 18:39:09 EET 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  UserController_2: controllers.UserController,
  // @LINE:14
  TestController_3: controllers.TestController,
  // @LINE:17
  CountController_0: controllers.CountController,
  // @LINE:19
  AsyncController_1: controllers.AsyncController,
  // @LINE:27
  Assets_4: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    UserController_2: controllers.UserController,
    // @LINE:14
    TestController_3: controllers.TestController,
    // @LINE:17
    CountController_0: controllers.CountController,
    // @LINE:19
    AsyncController_1: controllers.AsyncController,
    // @LINE:27
    Assets_4: controllers.Assets
  ) = this(errorHandler, UserController_2, TestController_3, CountController_0, AsyncController_1, Assets_4, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, UserController_2, TestController_3, CountController_0, AsyncController_1, Assets_4, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.UserController.index()"""),
    ("""POST""", this.prefix, """controllers.UserController.save()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/login/""", """controllers.UserController.authenticate()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """profile""", """controllers.UserController.profile()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """profile/edit""", """controllers.UserController.edit()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """profile/edit""", """controllers.UserController.update()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """controllers.UserController.logout()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """categories""", """controllers.TestController.categories()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """coding""", """controllers.TestController.codingQuestion()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """result/""" + "$" + """category<[^/]+>""", """controllers.TestController.showResult(category:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UserController.showAll()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/""" + "$" + """id<[^/]+>""", """controllers.UserController.show(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users/delete/""" + "$" + """id<[^/]+>""", """controllers.UserController.destroy(id:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/images/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public/images", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_UserController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_UserController_index0_invoker = createInvoker(
    UserController_2.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_UserController_save1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_UserController_save1_invoker = createInvoker(
    UserController_2.save(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "save",
      Nil,
      "POST",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_UserController_authenticate2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/login/")))
  )
  private[this] lazy val controllers_UserController_authenticate2_invoker = createInvoker(
    UserController_2.authenticate(),
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

  // @LINE:9
  private[this] lazy val controllers_UserController_profile3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("profile")))
  )
  private[this] lazy val controllers_UserController_profile3_invoker = createInvoker(
    UserController_2.profile(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "profile",
      Nil,
      "GET",
      this.prefix + """profile""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_UserController_edit4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("profile/edit")))
  )
  private[this] lazy val controllers_UserController_edit4_invoker = createInvoker(
    UserController_2.edit(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "edit",
      Nil,
      "GET",
      this.prefix + """profile/edit""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_UserController_update5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("profile/edit")))
  )
  private[this] lazy val controllers_UserController_update5_invoker = createInvoker(
    UserController_2.update(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "update",
      Nil,
      "POST",
      this.prefix + """profile/edit""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_UserController_logout6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val controllers_UserController_logout6_invoker = createInvoker(
    UserController_2.logout(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "logout",
      Nil,
      "GET",
      this.prefix + """logout""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_TestController_categories7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("categories")))
  )
  private[this] lazy val controllers_TestController_categories7_invoker = createInvoker(
    TestController_3.categories(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TestController",
      "categories",
      Nil,
      "GET",
      this.prefix + """categories""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_TestController_codingQuestion8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("coding")))
  )
  private[this] lazy val controllers_TestController_codingQuestion8_invoker = createInvoker(
    TestController_3.codingQuestion(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TestController",
      "codingQuestion",
      Nil,
      "GET",
      this.prefix + """coding""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_CountController_count9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private[this] lazy val controllers_CountController_count9_invoker = createInvoker(
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

  // @LINE:19
  private[this] lazy val controllers_AsyncController_message10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private[this] lazy val controllers_AsyncController_message10_invoker = createInvoker(
    AsyncController_1.message,
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

  // @LINE:20
  private[this] lazy val controllers_TestController_showResult11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("result/"), DynamicPart("category", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TestController_showResult11_invoker = createInvoker(
    TestController_3.showResult(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TestController",
      "showResult",
      Seq(classOf[String]),
      "GET",
      this.prefix + """result/""" + "$" + """category<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_UserController_showAll12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_UserController_showAll12_invoker = createInvoker(
    UserController_2.showAll(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "showAll",
      Nil,
      "GET",
      this.prefix + """users""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_UserController_show13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_show13_invoker = createInvoker(
    UserController_2.show(fakeValue[String]),
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

  // @LINE:25
  private[this] lazy val controllers_UserController_destroy14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users/delete/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserController_destroy14_invoker = createInvoker(
    UserController_2.destroy(fakeValue[String]),
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

  // @LINE:27
  private[this] lazy val controllers_Assets_versioned15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned15_invoker = createInvoker(
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

  // @LINE:28
  private[this] lazy val controllers_Assets_at16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/images/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at16_invoker = createInvoker(
    Assets_4.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """assets/images/""" + "$" + """file<.+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_UserController_index0_route(params@_) =>
      call { 
        controllers_UserController_index0_invoker.call(UserController_2.index())
      }
  
    // @LINE:7
    case controllers_UserController_save1_route(params@_) =>
      call { 
        controllers_UserController_save1_invoker.call(UserController_2.save())
      }
  
    // @LINE:8
    case controllers_UserController_authenticate2_route(params@_) =>
      call { 
        controllers_UserController_authenticate2_invoker.call(UserController_2.authenticate())
      }
  
    // @LINE:9
    case controllers_UserController_profile3_route(params@_) =>
      call { 
        controllers_UserController_profile3_invoker.call(UserController_2.profile())
      }
  
    // @LINE:10
    case controllers_UserController_edit4_route(params@_) =>
      call { 
        controllers_UserController_edit4_invoker.call(UserController_2.edit())
      }
  
    // @LINE:11
    case controllers_UserController_update5_route(params@_) =>
      call { 
        controllers_UserController_update5_invoker.call(UserController_2.update())
      }
  
    // @LINE:12
    case controllers_UserController_logout6_route(params@_) =>
      call { 
        controllers_UserController_logout6_invoker.call(UserController_2.logout())
      }
  
    // @LINE:14
    case controllers_TestController_categories7_route(params@_) =>
      call { 
        controllers_TestController_categories7_invoker.call(TestController_3.categories())
      }
  
    // @LINE:15
    case controllers_TestController_codingQuestion8_route(params@_) =>
      call { 
        controllers_TestController_codingQuestion8_invoker.call(TestController_3.codingQuestion())
      }
  
    // @LINE:17
    case controllers_CountController_count9_route(params@_) =>
      call { 
        controllers_CountController_count9_invoker.call(CountController_0.count)
      }
  
    // @LINE:19
    case controllers_AsyncController_message10_route(params@_) =>
      call { 
        controllers_AsyncController_message10_invoker.call(AsyncController_1.message)
      }
  
    // @LINE:20
    case controllers_TestController_showResult11_route(params@_) =>
      call(params.fromPath[String]("category", None)) { (category) =>
        controllers_TestController_showResult11_invoker.call(TestController_3.showResult(category))
      }
  
    // @LINE:22
    case controllers_UserController_showAll12_route(params@_) =>
      call { 
        controllers_UserController_showAll12_invoker.call(UserController_2.showAll())
      }
  
    // @LINE:23
    case controllers_UserController_show13_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_UserController_show13_invoker.call(UserController_2.show(id))
      }
  
    // @LINE:25
    case controllers_UserController_destroy14_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_UserController_destroy14_invoker.call(UserController_2.destroy(id))
      }
  
    // @LINE:27
    case controllers_Assets_versioned15_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_versioned15_invoker.call(Assets_4.versioned(path, file))
      }
  
    // @LINE:28
    case controllers_Assets_at16_route(params@_) =>
      call(Param[String]("path", Right("/public/images")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at16_invoker.call(Assets_4.at(path, file))
      }
  }
}
