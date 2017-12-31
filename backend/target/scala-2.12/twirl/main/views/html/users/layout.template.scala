
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

object layout extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(body: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.29*/("""

"""),format.raw/*3.1*/("""<html>
    <head>
        <title>"""),_display_(/*5.17*/title),format.raw/*5.22*/("""</title>
    </head>
    <body>
        """),_display_(/*8.10*/body),format.raw/*8.14*/("""
    """),format.raw/*9.5*/("""</body>
</html>"""))
      }
    }
  }

  def render(title:String,body:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(body)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (body) => apply(title)(body)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Dec 29 21:22:59 GMT 2017
                  SOURCE: /home/cagdas/softytestFinal/backend/app/views/users/layout.scala.html
                  HASH: c290ef4cce5be0b0f41b83a4da2981348566c613
                  MATRIX: 960->1|1082->28|1110->30|1170->64|1195->69|1262->110|1286->114|1317->119
                  LINES: 28->1|33->1|35->3|37->5|37->5|40->8|40->8|41->9
                  -- GENERATED --
              */
          