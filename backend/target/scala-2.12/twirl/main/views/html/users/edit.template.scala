
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

object edit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Form[User],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userForm: Form[User]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import views.html.helper.CSRF


Seq[Any](format.raw/*1.24*/("""
"""),format.raw/*3.1*/("""<html>
    <head>
        <title>Edit User</title>
    </head>
    <body>
        <h1>Edit User</h1>
        """),_display_(/*9.10*/helper/*9.16*/.form(action = CSRF(routes.UserController.update()))/*9.68*/{_display_(Seq[Any](format.raw/*9.69*/("""
            """),_display_(/*10.14*/helper/*10.20*/.inputText(userForm("id"))),format.raw/*10.46*/("""
            """),_display_(/*11.14*/helper/*11.20*/.inputText(userForm("email"))),format.raw/*11.49*/("""
            """),_display_(/*12.14*/helper/*12.20*/.inputText(userForm("password"))),format.raw/*12.52*/("""
            """),_display_(/*13.14*/helper/*13.20*/.inputText(userForm("passwordSalt"))),format.raw/*13.56*/("""
            """),format.raw/*14.13*/("""<input type="submit" value="Edit User">
            """)))}),format.raw/*15.14*/("""
    """),format.raw/*16.5*/("""</body>
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
                  SOURCE: /home/cagdas/softytestFinal/backend/app/views/users/edit.scala.html
                  HASH: 5712eeccc9a9efdaf1cde34e1f0b07404bc3ad44
                  MATRIX: 957->1|1052->25|1111->23|1138->55|1274->165|1288->171|1348->223|1386->224|1427->238|1442->244|1489->270|1530->284|1545->290|1595->319|1636->333|1651->339|1704->371|1745->385|1760->391|1817->427|1858->440|1942->493|1974->498
                  LINES: 28->1|31->2|34->1|35->3|41->9|41->9|41->9|41->9|42->10|42->10|42->10|43->11|43->11|43->11|44->12|44->12|44->12|45->13|45->13|45->13|46->14|47->15|48->16
                  -- GENERATED --
              */
          