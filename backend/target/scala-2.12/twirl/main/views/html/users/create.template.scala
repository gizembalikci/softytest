
package views.html.users

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object create extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Form[User],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userForm: Form[User]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import views.html.helper.form
/*3.2*/import views.html.helper.inputText
/*4.2*/import views.html.helper.CSRF


Seq[Any](format.raw/*1.24*/("""
"""),format.raw/*5.1*/("""
"""),format.raw/*6.1*/("""<html>
    <head>
        <title>Create Users</title>
    </head>
    <body>
        <h1>Create Users</h1>
        """),_display_(/*12.10*/helper/*12.16*/.form(action = helper.CSRF(routes.UserController.save()))/*12.73*/{_display_(Seq[Any](format.raw/*12.74*/("""
            """),_display_(/*13.14*/helper/*13.20*/.inputText(userForm("email"))),format.raw/*13.49*/("""
            """),_display_(/*14.14*/helper/*14.20*/.inputText(userForm("password"))),format.raw/*14.52*/("""
            """),format.raw/*15.13*/("""<input type="submit" value="Create User">
            """)))}),format.raw/*16.14*/("""
    """),format.raw/*17.5*/("""</body>
</html>"""))
      }
    }
  }

  def render(userForm:Form[User]): play.twirl.api.HtmlFormat.Appendable = apply(userForm)

  def f:((Form[User]) => play.twirl.api.HtmlFormat.Appendable) = (userForm) => apply(userForm)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sun Dec 31 01:51:50 GMT 2017
                  SOURCE: /home/cagdas/softytestFinal/backend/app/views/users/create.scala.html
                  HASH: 14a4638df29503ac63304994ff05b6929413c320
                  MATRIX: 959->1|1054->25|1091->56|1133->92|1192->23|1219->122|1246->123|1389->239|1404->245|1470->302|1509->303|1550->317|1565->323|1615->352|1656->366|1671->372|1724->404|1765->417|1851->472|1883->477
                  LINES: 28->1|31->2|32->3|33->4|36->1|37->5|38->6|44->12|44->12|44->12|44->12|45->13|45->13|45->13|46->14|46->14|46->14|47->15|48->16|49->17
                  -- GENERATED --
              */
          