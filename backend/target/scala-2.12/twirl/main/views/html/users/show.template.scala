
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

object show extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.14*/("""

"""),format.raw/*3.1*/("""<html>
    <head>
        <title>"""),_display_(/*5.17*/user/*5.21*/.email),format.raw/*5.27*/("""</title>
    </head>
    <body>
        <h2>"""),_display_(/*8.14*/user/*8.18*/.email),format.raw/*8.24*/("""</h2>
        <p>"""),_display_(/*9.13*/user/*9.17*/.password),format.raw/*9.26*/("""</p>
    </body>
</html>"""))
      }
    }
  }

  def render(user:User): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sun Dec 31 01:51:51 GMT 2017
                  SOURCE: /home/cagdas/softytestFinal/backend/app/views/users/show.scala.html
                  HASH: 25b611ddea8f7c1a2f16c2730657359755072bb3
                  MATRIX: 951->1|1058->13|1086->15|1146->49|1158->53|1184->59|1255->104|1267->108|1293->114|1337->132|1349->136|1378->145
                  LINES: 28->1|33->1|35->3|37->5|37->5|37->5|40->8|40->8|40->8|41->9|41->9|41->9
                  -- GENERATED --
              */
          