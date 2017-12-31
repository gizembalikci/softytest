
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[User],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(users: List[User]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.21*/("""

"""),format.raw/*3.1*/("""<html>
    <head>
        <title>All Users</title>
    </head>
    <body>
        <h1>All Users</h1>

        """),_display_(/*10.10*/for(user <- users) yield /*10.28*/{_display_(Seq[Any](format.raw/*10.29*/("""
            """),format.raw/*11.13*/("""<a href=""""),_display_(/*11.23*/routes/*11.29*/.UserController.show(user.email)),format.raw/*11.61*/("""">"""),_display_(/*11.64*/user/*11.68*/.email),format.raw/*11.74*/("""</a>
            <p></p>
        """)))}),format.raw/*13.10*/("""
    """),format.raw/*14.5*/("""</body>
</html>"""))
      }
    }
  }

  def render(users:List[User]): play.twirl.api.HtmlFormat.Appendable = apply(users)

  def f:((List[User]) => play.twirl.api.HtmlFormat.Appendable) = (users) => apply(users)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sun Dec 31 01:07:33 GMT 2017
                  SOURCE: /home/cagdas/softytestFinal/backend/app/views/users/index.scala.html
                  HASH: 1ac9199b3b86ebd4d8f92991a948144fcb2c3d0d
                  MATRIX: 958->1|1072->20|1100->22|1238->133|1272->151|1311->152|1352->165|1389->175|1404->181|1457->213|1487->216|1500->220|1527->226|1592->260|1624->265
                  LINES: 28->1|33->1|35->3|42->10|42->10|42->10|43->11|43->11|43->11|43->11|43->11|43->11|43->11|45->13|46->14
                  -- GENERATED --
              */
          