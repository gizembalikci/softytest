
package views.html

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

object profilePage extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[models.User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: models.User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.21*/("""

"""),_display_(/*3.2*/layout(user.name)/*3.19*/{_display_(Seq[Any](format.raw/*3.20*/("""
        """),format.raw/*4.9*/("""<div class="container">
            <div class="py-5">
                <div class="row">
                    <div class="col-md-12 text-right">

                        <img src=""""),_display_(/*9.36*/routes/*9.42*/.Assets.at("ppexample.jpg")),format.raw/*9.69*/("""" width="200px" class="float-left rounded-circle m-0">
                        <p class="text-center px-4 my-5">"""),_display_(/*10.59*/user/*10.63*/.bio),format.raw/*10.67*/("""</p><a class="btn btn-primary text-info border border-info p-2 text-right"
                        href=""""),_display_(/*11.32*/routes/*11.38*/.UserController.update()),format.raw/*11.62*/("""" data-toggle="">Edit Profile </a>
                    </div>
                </div>
            </div>
            <div class="py-1">
                <div class="row">
                    <div class="col-md-12">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Category</th>
                                    <th>Total Answered</th>
                                    <th>Correct</th>
                                    <th>Incorrect</th>
                                    <th>Success Rate</th>
                                    <th>Rank</th>
                                </tr>
                            </thead>
                            <tbody>
                                    """),_display_(/*30.38*/for(statistics <- user.testStatistics) yield /*30.76*/{_display_(Seq[Any](format.raw/*30.77*/("""
                                        """),format.raw/*31.41*/("""<tr>
                                        <td>Category """),_display_(/*32.55*/statistics/*32.65*/.category),format.raw/*32.74*/("""</td>
                                        <td>"""),_display_(/*33.46*/TestController/*33.60*/.totalAnswered(statistics)),format.raw/*33.86*/("""</td>
                                        <td>"""),_display_(/*34.46*/TestController/*34.60*/.correct(statistics)),format.raw/*34.80*/("""</td>
                                        <td>"""),_display_(/*35.46*/TestController/*35.60*/.wrong(statistics)),format.raw/*35.78*/("""</td>
                                        <td>%"""),_display_(/*36.47*/TestController/*36.61*/.successRate(statistics)),format.raw/*36.85*/("""</td>
                                        <td>rank</td>
                                        </tr>
                                    """)))}),format.raw/*39.38*/("""
                                """),format.raw/*40.33*/("""<tr>
                                    <td>Overall</td>
                                    <td>"""),_display_(/*42.42*/TestController/*42.56*/.overallTotal(user.testStatistics)),format.raw/*42.90*/("""</td>
                                    <td>"""),_display_(/*43.42*/TestController/*43.56*/.overallCorrect(user.testStatistics)),format.raw/*43.92*/("""</td>
                                    <td>"""),_display_(/*44.42*/TestController/*44.56*/.overallWrong(user.testStatistics)),format.raw/*44.90*/("""</td>
                                    <td>%"""),_display_(/*45.43*/TestController/*45.57*/.overallSuccessRate(user.testStatistics)),format.raw/*45.97*/("""</td>
                                    <td>totalRank</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <a class="btn btn-primary text-info border border-info p-2 text-left" href=""""),_display_(/*52.94*/routes/*52.100*/.TestController.categories()),format.raw/*52.128*/("""" data-toggle="">Start New Test </a>
                <a type="submit" class="btn btn-primary text-info border border-info p-2 text-left" href=""""),_display_(/*53.108*/routes/*53.114*/.UserController.logout()),format.raw/*53.138*/("""" data-toggle="">Logout</a>
            </div>
        </div>
""")))}))
      }
    }
  }

  def render(user:models.User): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((models.User) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Jan 05 12:47:34 GMT 2018
                  SOURCE: /home/cagdas/softytestFinal/backend/app/views/profilePage.scala.html
                  HASH: 553e5b71d071088ab9991505614d03a24d9ef0bd
                  MATRIX: 959->1|1073->20|1101->23|1126->40|1164->41|1199->50|1405->230|1419->236|1466->263|1606->376|1619->380|1644->384|1777->490|1792->496|1837->520|2674->1330|2728->1368|2767->1369|2836->1410|2922->1469|2941->1479|2971->1488|3049->1539|3072->1553|3119->1579|3197->1630|3220->1644|3261->1664|3339->1715|3362->1729|3401->1747|3480->1799|3503->1813|3548->1837|3722->1980|3783->2013|3909->2112|3932->2126|3987->2160|4061->2207|4084->2221|4141->2257|4215->2304|4238->2318|4293->2352|4368->2400|4391->2414|4452->2454|4791->2766|4807->2772|4857->2800|5029->2944|5045->2950|5091->2974
                  LINES: 28->1|33->1|35->3|35->3|35->3|36->4|41->9|41->9|41->9|42->10|42->10|42->10|43->11|43->11|43->11|62->30|62->30|62->30|63->31|64->32|64->32|64->32|65->33|65->33|65->33|66->34|66->34|66->34|67->35|67->35|67->35|68->36|68->36|68->36|71->39|72->40|74->42|74->42|74->42|75->43|75->43|75->43|76->44|76->44|76->44|77->45|77->45|77->45|84->52|84->52|84->52|85->53|85->53|85->53
                  -- GENERATED --
              */
          