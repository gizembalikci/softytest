
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
  def apply/*2.2*/(users: List[User]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.21*/("""

"""),format.raw/*4.1*/("""<html>
    <head>
        <title>All Users</title>
    </head>
    <body>
        <h1>All Users</h1>

        """),_display_(/*11.10*/for(user <- users) yield /*11.28*/{_display_(Seq[Any](format.raw/*11.29*/("""
            """),format.raw/*12.13*/("""<a href=""""),_display_(/*12.23*/routes/*12.29*/.UserController.show(user.email)),format.raw/*12.61*/("""">"""),_display_(/*12.64*/user/*12.68*/.email),format.raw/*12.74*/("""</a>
            <p></p>
        """)))}),format.raw/*14.10*/("""
    """),format.raw/*15.5*/("""</body>
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
                  DATE: Mon Jan 01 15:06:00 GMT 2018
                  SOURCE: /home/cagdas/softytestFinal/backend/app/views/users/index.scala.html
                  HASH: c5129bd693482984bf45e6237921e8514dc804ef
                  MATRIX: 958->2|1072->21|1100->23|1238->134|1272->152|1311->153|1352->166|1389->176|1404->182|1457->214|1487->217|1500->221|1527->227|1592->261|1624->266
                  LINES: 28->2|33->2|35->4|42->11|42->11|42->11|43->12|43->12|43->12|43->12|43->12|43->12|43->12|45->14|46->15
                  -- GENERATED --
              */
          