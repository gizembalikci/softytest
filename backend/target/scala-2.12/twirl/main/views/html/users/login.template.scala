
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

object login extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Form[User],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userForm: Form[User]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import b4.vertical.fieldConstructor


Seq[Any](format.raw/*1.24*/("""
"""),format.raw/*3.1*/("""<html>
    <head>
        <title>Login Users</title>
        <link rel="stylesheet" href=""""),_display_(/*6.39*/routes/*6.45*/.Assets.versioned("stylesheets/theme.css")),format.raw/*6.87*/("""">
        <link rel="stylesheet" href=""""),_display_(/*7.39*/routes/*7.45*/.Assets.versioned("stylesheets/font-awesome.min.css")),format.raw/*7.98*/("""" type="text/css">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*8.59*/routes/*8.65*/.Assets.versioned("images/favicon.png")),format.raw/*8.104*/("""">
    </head>
    <body>
        <h1>Login Users</h1>
        """),_display_(/*12.10*/b4/*12.12*/.form(helper.CSRF(routes.UserController.authenticate()))/*12.68*/ {_display_(Seq[Any](format.raw/*12.70*/("""
            """),_display_(/*13.14*/b4/*13.16*/.email( userForm("email"), '_label -> "Email", 'placeholder -> "example@mail.com" , 'class->"form-control")),format.raw/*13.123*/("""
            """),_display_(/*14.14*/b4/*14.16*/.password( userForm("password"), '_label -> "Password", 'placeholder -> "Password" , 'class->"form-control")),format.raw/*14.124*/("""
            """),_display_(/*15.14*/b4/*15.16*/.submit('class -> "btn btn-primary")/*15.52*/{_display_(Seq[Any](format.raw/*15.53*/(""" """),format.raw/*15.54*/("""Log in """)))}),format.raw/*15.62*/("""
        """)))}),format.raw/*16.10*/("""
        """),format.raw/*17.9*/("""<script src=""""),_display_(/*17.23*/routes/*17.29*/.Assets.versioned("javascripts/jquery-3.2.1.slim.min.js")),format.raw/*17.86*/("""" crossorigin="anonymous"></script>
        <script src=""""),_display_(/*18.23*/routes/*18.29*/.Assets.versioned("javascripts/popper.min.js")),format.raw/*18.75*/("""" crossorigin="anonymous"></script>
        <script src=""""),_display_(/*19.23*/routes/*19.29*/.Assets.versioned("javascripts/query-3.2.1.slim.min.js")),format.raw/*19.85*/("""" crossorigin="anonymous"></script>
    </body>
</html>

"""))
      }
    }
  }

  def render(userForm:Form[User]): play.twirl.api.HtmlFormat.Appendable = apply(userForm)

  def f:((Form[User]) => play.twirl.api.HtmlFormat.Appendable) = (userForm) => apply(userForm)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sun Dec 31 02:43:26 GMT 2017
                  SOURCE: /home/cagdas/softytestFinal/backend/app/views/users/login.scala.html
                  HASH: 482f57a43c0d628781a363574428dfa42706231b
                  MATRIX: 958->1|1053->25|1118->23|1145->61|1262->152|1276->158|1338->200|1405->241|1419->247|1492->300|1595->377|1609->383|1669->422|1760->486|1771->488|1836->544|1876->546|1917->560|1928->562|2057->669|2098->683|2109->685|2239->793|2280->807|2291->809|2336->845|2375->846|2404->847|2443->855|2484->865|2520->874|2561->888|2576->894|2654->951|2739->1009|2754->1015|2821->1061|2906->1119|2921->1125|2998->1181
                  LINES: 28->1|31->2|34->1|35->3|38->6|38->6|38->6|39->7|39->7|39->7|40->8|40->8|40->8|44->12|44->12|44->12|44->12|45->13|45->13|45->13|46->14|46->14|46->14|47->15|47->15|47->15|47->15|47->15|47->15|48->16|49->17|49->17|49->17|49->17|50->18|50->18|50->18|51->19|51->19|51->19
                  -- GENERATED --
              */
          