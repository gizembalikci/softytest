
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
        <p>name: """),_display_(/*10.19*/user/*10.23*/.name),format.raw/*10.28*/("""</p>
        <p>testStatistics:</p>
        """),_display_(/*12.10*/for(statistic <- user.testStatistics) yield /*12.47*/{_display_(Seq[Any](format.raw/*12.48*/("""
            """),format.raw/*13.13*/("""<p>"""),_display_(/*13.17*/statistic/*13.26*/.user.email),format.raw/*13.37*/("""</p>
        """)))}),format.raw/*14.10*/("""
        """),format.raw/*15.9*/("""<p>bio: """),_display_(/*15.18*/user/*15.22*/.bio),format.raw/*15.26*/("""</p>
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
                  DATE: Fri Jan 05 10:34:59 GMT 2018
                  SOURCE: /home/cagdas/softytestFinal/backend/app/views/users/show.scala.html
                  HASH: 6f843a7f016f8b2e5c1fe1da9ff91878d87dc40d
                  MATRIX: 951->1|1058->13|1086->15|1146->49|1158->53|1184->59|1262->111|1274->115|1300->121|1358->153|1370->157|1399->166|1449->189|1462->193|1488->198|1560->243|1613->280|1652->281|1693->294|1724->298|1742->307|1774->318|1819->332|1855->341|1891->350|1904->354|1929->358
                  LINES: 28->1|33->1|35->3|37->5|37->5|37->5|40->8|40->8|40->8|41->9|41->9|41->9|42->10|42->10|42->10|44->12|44->12|44->12|45->13|45->13|45->13|45->13|46->14|47->15|47->15|47->15|47->15
                  -- GENERATED --
              */
          