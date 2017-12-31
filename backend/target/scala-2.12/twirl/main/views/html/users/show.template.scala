
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
        <h2>Email: """),_display_(/*8.21*/user/*8.25*/.email),format.raw/*8.31*/("""</h2>
        <p>PasswordHash: """),_display_(/*9.27*/user/*9.31*/.password),format.raw/*9.40*/("""</p>
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
                  DATE: Sun Dec 31 04:01:41 GMT 2017
                  SOURCE: /home/cagdas/softytestFinal/backend/app/views/users/show.scala.html
                  HASH: 18c1146401dad3017b9a0c8a75dfaf40645353c1
                  MATRIX: 951->1|1058->13|1086->15|1146->49|1158->53|1184->59|1262->111|1274->115|1300->121|1358->153|1370->157|1399->166
                  LINES: 28->1|33->1|35->3|37->5|37->5|37->5|40->8|40->8|40->8|41->9|41->9|41->9
                  -- GENERATED --
              */
          