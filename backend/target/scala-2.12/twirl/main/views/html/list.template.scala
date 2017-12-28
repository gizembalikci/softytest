
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

object list extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[io.ebean.PagedList[Computer],String,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(currentPage: io.ebean.PagedList[Computer], currentSortBy: String, currentOrder: String, currentFilter: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*32.2*/header/*32.8*/(key:String, title:String):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*32.38*/("""
    """),format.raw/*33.5*/("""<th class=""""),_display_(/*33.17*/key/*33.20*/.replace(".","_")),format.raw/*33.37*/(""" """),format.raw/*33.38*/("""header """),_display_(/*33.46*/if(currentSortBy == key)/*33.70*/ {_display_(Seq[Any](format.raw/*33.72*/(""" """),_display_(/*33.74*/{if(currentOrder == "asc") "headerSortDown" else "headerSortUp" }),format.raw/*33.139*/(""" """)))}),format.raw/*33.141*/("""">
        <a href=""""),_display_(/*34.19*/link(0, key)),format.raw/*34.31*/("""">"""),_display_(/*34.34*/title),format.raw/*34.39*/("""</a>
    </th>
""")))};def /*6.2*/link/*6.6*/(newPage:Int, newSortBy:String) = {{

    var sortBy = currentSortBy
    var order = currentOrder

    if(newSortBy != null) {
        sortBy = newSortBy
        if(currentSortBy == newSortBy) {
            if(currentOrder == "asc") {
                order = "desc"
            } else {
                order = "asc"
            }
        } else {
            order = "asc"
        }
    }

    // Generate the link
    routes.HomeController.list(newPage, sortBy, order, currentFilter)

}};
Seq[Any](format.raw/*1.113*/("""

"""),format.raw/*5.42*/("""
"""),format.raw/*27.2*/("""

"""),format.raw/*31.37*/("""
"""),format.raw/*36.2*/("""

"""),_display_(/*38.2*/main/*38.6*/ {_display_(Seq[Any](format.raw/*38.8*/("""

    """),format.raw/*40.5*/("""<h1 id="homeTitle">"""),_display_(/*40.25*/Messages("computers.list.title", currentPage.getTotalCount)),format.raw/*40.84*/("""</h1>

    """),_display_(/*42.6*/if(flash.containsKey("success"))/*42.38*/ {_display_(Seq[Any](format.raw/*42.40*/("""
        """),format.raw/*43.9*/("""<div class="alert-message warning">
            <strong>Done!</strong> """),_display_(/*44.37*/flash/*44.42*/.get("success")),format.raw/*44.57*/("""
        """),format.raw/*45.9*/("""</div>
    """)))}),format.raw/*46.6*/("""

    """),format.raw/*48.5*/("""<div id="actions">

        <form action=""""),_display_(/*50.24*/link(0, "name")),format.raw/*50.39*/("""" method="GET">
            <input type="search" id="searchbox" name="f" value=""""),_display_(/*51.66*/currentFilter),format.raw/*51.79*/("""" placeholder="Filter by computer name...">
            <input type="submit" id="searchsubmit" value="Filter by name" class="btn primary">
        </form>

        <a class="btn success" id="add" href=""""),_display_(/*55.48*/routes/*55.54*/.HomeController.create()),format.raw/*55.78*/("""">Add a new computer</a>

    </div>

    """),_display_(/*59.6*/if(currentPage.getTotalCount == 0)/*59.40*/ {_display_(Seq[Any](format.raw/*59.42*/("""

        """),format.raw/*61.9*/("""<div class="well">
            <em>Nothing to display</em>
        </div>

    """)))}/*65.7*/else/*65.12*/{_display_(Seq[Any](format.raw/*65.13*/("""

        """),format.raw/*67.9*/("""<table class="computers zebra-striped">
            <thead>
                <tr>
                    """),_display_(/*70.22*/header("name", "Computer name")),format.raw/*70.53*/("""
                    """),_display_(/*71.22*/header("introduced", "Introduced")),format.raw/*71.56*/("""
                    """),_display_(/*72.22*/header("discontinued", "Discontinued")),format.raw/*72.60*/("""
                    """),_display_(/*73.22*/header("company.name", "Company")),format.raw/*73.55*/("""
                """),format.raw/*74.17*/("""</tr>
            </thead>
            <tbody>

                """),_display_(/*78.18*/for(computer <- currentPage.getList.asScala) yield /*78.62*/ {_display_(Seq[Any](format.raw/*78.64*/("""
                    """),format.raw/*79.21*/("""<tr>
                        <td><a href=""""),_display_(/*80.39*/routes/*80.45*/.HomeController.edit(computer.id)),format.raw/*80.78*/("""">"""),_display_(/*80.81*/computer/*80.89*/.name),format.raw/*80.94*/("""</a></td>
                        <td>
                            """),_display_(/*82.30*/if(computer.introduced == null)/*82.61*/ {_display_(Seq[Any](format.raw/*82.63*/("""
                                """),format.raw/*83.33*/("""<em>-</em>
                            """)))}/*84.31*/else/*84.36*/{_display_(Seq[Any](format.raw/*84.37*/("""
                                """),_display_(/*85.34*/computer/*85.42*/.introduced.format("dd MMM yyyy")),format.raw/*85.75*/("""
                            """)))}),format.raw/*86.30*/("""
                        """),format.raw/*87.25*/("""</td>
                        <td>
                            """),_display_(/*89.30*/if(computer.discontinued == null)/*89.63*/ {_display_(Seq[Any](format.raw/*89.65*/("""
                                """),format.raw/*90.33*/("""<em>-</em>
                            """)))}/*91.31*/else/*91.36*/{_display_(Seq[Any](format.raw/*91.37*/("""
                                """),_display_(/*92.34*/computer/*92.42*/.discontinued.format("dd MMM yyyy")),format.raw/*92.77*/("""
                            """)))}),format.raw/*93.30*/("""
                        """),format.raw/*94.25*/("""</td>
                        <td>
                            """),_display_(/*96.30*/if(computer.company == null)/*96.58*/ {_display_(Seq[Any](format.raw/*96.60*/("""
                                """),format.raw/*97.33*/("""<em>-</em>
                            """)))}/*98.31*/else/*98.36*/{_display_(Seq[Any](format.raw/*98.37*/("""
                                """),_display_(/*99.34*/computer/*99.42*/.company.name),format.raw/*99.55*/("""
                            """)))}),format.raw/*100.30*/("""
                        """),format.raw/*101.25*/("""</td>
                    </tr>
                """)))}),format.raw/*103.18*/("""

            """),format.raw/*105.13*/("""</tbody>
        </table>

        <div id="pagination" class="pagination">
            <ul>
                """),_display_(/*110.18*/if(currentPage.hasPrev)/*110.41*/ {_display_(Seq[Any](format.raw/*110.43*/("""
                    """),format.raw/*111.21*/("""<li class="prev">
                        <a href=""""),_display_(/*112.35*/link(currentPage.getPageIndex - 1, null)),format.raw/*112.75*/("""">&larr; Previous</a>
                    </li>
                """)))}/*114.19*/else/*114.24*/{_display_(Seq[Any](format.raw/*114.25*/("""
                    """),format.raw/*115.21*/("""<li class="prev disabled">
                        <a>&larr; Previous</a>
                    </li>
                """)))}),format.raw/*118.18*/("""
                """),format.raw/*119.17*/("""<li class="current">
                    <a>Displaying """),_display_(/*120.36*/currentPage/*120.47*/.getDisplayXtoYofZ(" to "," of ")),format.raw/*120.80*/("""</a>
                </li>
                """),_display_(/*122.18*/if(currentPage.hasNext)/*122.41*/ {_display_(Seq[Any](format.raw/*122.43*/("""
                    """),format.raw/*123.21*/("""<li class="next">
                        <a href=""""),_display_(/*124.35*/link(currentPage.getPageIndex + 1, null)),format.raw/*124.75*/("""">Next &rarr;</a>
                    </li>
                """)))}/*126.19*/else/*126.24*/{_display_(Seq[Any](format.raw/*126.25*/("""
                    """),format.raw/*127.21*/("""<li class="next disabled">
                        <a>Next &rarr;</a>
                    </li>
                """)))}),format.raw/*130.18*/("""
            """),format.raw/*131.13*/("""</ul>
        </div>

    """)))}),format.raw/*134.6*/("""

""")))}),format.raw/*136.2*/("""

"""))
      }
    }
  }

  def render(currentPage:io.ebean.PagedList[Computer],currentSortBy:String,currentOrder:String,currentFilter:String): play.twirl.api.HtmlFormat.Appendable = apply(currentPage,currentSortBy,currentOrder,currentFilter)

  def f:((io.ebean.PagedList[Computer],String,String,String) => play.twirl.api.HtmlFormat.Appendable) = (currentPage,currentSortBy,currentOrder,currentFilter) => apply(currentPage,currentSortBy,currentOrder,currentFilter)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Dec 20 14:38:11 EET 2017
                  SOURCE: /home/gizem/Desktop/softytest/backend/app/views/list.scala.html
                  HASH: c5c33af55de9aa414857b25c68ab4e0240041969
                  MATRIX: 990->1|1180->845|1194->851|1301->881|1333->886|1372->898|1384->901|1422->918|1451->919|1486->927|1519->951|1559->953|1588->955|1675->1020|1709->1022|1757->1043|1790->1055|1820->1058|1846->1063|1884->241|1895->245|2414->112|2443->239|2471->733|2501->843|2529->1079|2558->1082|2570->1086|2609->1088|2642->1094|2689->1114|2769->1173|2807->1185|2848->1217|2888->1219|2924->1228|3023->1300|3037->1305|3073->1320|3109->1329|3151->1341|3184->1347|3254->1390|3290->1405|3398->1486|3432->1499|3662->1702|3677->1708|3722->1732|3791->1775|3834->1809|3874->1811|3911->1821|4009->1902|4022->1907|4061->1908|4098->1918|4227->2020|4279->2051|4328->2073|4383->2107|4432->2129|4491->2167|4540->2189|4594->2222|4639->2239|4731->2304|4791->2348|4831->2350|4880->2371|4950->2414|4965->2420|5019->2453|5049->2456|5066->2464|5092->2469|5187->2537|5227->2568|5267->2570|5328->2603|5387->2644|5400->2649|5439->2650|5500->2684|5517->2692|5571->2725|5632->2755|5685->2780|5776->2844|5818->2877|5858->2879|5919->2912|5978->2953|5991->2958|6030->2959|6091->2993|6108->3001|6164->3036|6225->3066|6278->3091|6369->3155|6406->3183|6446->3185|6507->3218|6566->3259|6579->3264|6618->3265|6679->3299|6696->3307|6730->3320|6792->3350|6846->3375|6927->3424|6970->3438|7108->3548|7141->3571|7182->3573|7232->3594|7312->3646|7374->3686|7459->3752|7473->3757|7513->3758|7563->3779|7712->3896|7758->3913|7842->3969|7863->3980|7918->4013|7990->4057|8023->4080|8064->4082|8114->4103|8194->4155|8256->4195|8337->4257|8351->4262|8391->4263|8441->4284|8586->4397|8628->4410|8686->4437|8720->4440
                  LINES: 28->1|32->32|32->32|34->32|35->33|35->33|35->33|35->33|35->33|35->33|35->33|35->33|35->33|35->33|35->33|36->34|36->34|36->34|36->34|38->6|38->6|60->1|62->5|63->27|65->31|66->36|68->38|68->38|68->38|70->40|70->40|70->40|72->42|72->42|72->42|73->43|74->44|74->44|74->44|75->45|76->46|78->48|80->50|80->50|81->51|81->51|85->55|85->55|85->55|89->59|89->59|89->59|91->61|95->65|95->65|95->65|97->67|100->70|100->70|101->71|101->71|102->72|102->72|103->73|103->73|104->74|108->78|108->78|108->78|109->79|110->80|110->80|110->80|110->80|110->80|110->80|112->82|112->82|112->82|113->83|114->84|114->84|114->84|115->85|115->85|115->85|116->86|117->87|119->89|119->89|119->89|120->90|121->91|121->91|121->91|122->92|122->92|122->92|123->93|124->94|126->96|126->96|126->96|127->97|128->98|128->98|128->98|129->99|129->99|129->99|130->100|131->101|133->103|135->105|140->110|140->110|140->110|141->111|142->112|142->112|144->114|144->114|144->114|145->115|148->118|149->119|150->120|150->120|150->120|152->122|152->122|152->122|153->123|154->124|154->124|156->126|156->126|156->126|157->127|160->130|161->131|164->134|166->136
                  -- GENERATED --
              */
          