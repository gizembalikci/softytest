
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

object editForm extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Long,Form[Computer],Map[String, String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(id: Long, computerForm: Form[Computer], companies: Map[String, String]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import helper._


Seq[Any](format.raw/*1.74*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main/*5.6*/ {_display_(Seq[Any](format.raw/*5.8*/("""
    
    """),format.raw/*7.5*/("""<h1>Edit computer</h1>
    
    """),_display_(/*9.6*/form(routes.HomeController.update(id))/*9.44*/ {_display_(Seq[Any](format.raw/*9.46*/("""
        
        """),format.raw/*11.9*/("""<fieldset>
            """),_display_(/*12.14*/CSRF/*12.18*/.formField),format.raw/*12.28*/("""
            """),_display_(/*13.14*/inputText(computerForm("name"), '_label -> "Computer name", '_help -> "")),format.raw/*13.87*/("""
            """),_display_(/*14.14*/inputText(computerForm("introduced"), '_label -> "Introduced date", '_help -> "")),format.raw/*14.95*/("""
            """),_display_(/*15.14*/inputText(computerForm("discontinued"), '_label -> "Discontinued date", '_help -> "")),format.raw/*15.99*/("""
            
            """),_display_(/*17.14*/select(
                computerForm("company.id"), 
                options(companies),
                '_label -> "Company", '_default -> "-- Choose a company --",
                '_showConstraints -> false
            )),format.raw/*22.14*/("""
        
        """),format.raw/*24.9*/("""</fieldset>
        
        <div class="actions">
            <input type="submit" value="Save this computer" class="btn primary"> or 
            <a href=""""),_display_(/*28.23*/routes/*28.29*/.HomeController.list()),format.raw/*28.51*/("""" class="btn">Cancel</a>
        </div>
        
    """)))}),format.raw/*31.6*/("""
    
    """),_display_(/*33.6*/form(routes.HomeController.delete(id), 'class -> "topRight")/*33.66*/ {_display_(Seq[Any](format.raw/*33.68*/("""
        """),_display_(/*34.10*/CSRF/*34.14*/.formField),format.raw/*34.24*/("""
        """),format.raw/*35.9*/("""<input type="submit" value="Delete this computer" class="btn danger">
    """)))}),format.raw/*36.6*/("""
    
""")))}),format.raw/*38.2*/("""
"""))
      }
    }
  }

  def render(id:Long,computerForm:Form[Computer],companies:Map[String, String]): play.twirl.api.HtmlFormat.Appendable = apply(id,computerForm,companies)

  def f:((Long,Form[Computer],Map[String, String]) => play.twirl.api.HtmlFormat.Appendable) = (id,computerForm,companies) => apply(id,computerForm,companies)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Dec 20 14:38:11 EET 2017
                  SOURCE: /home/gizem/Desktop/softytest/backend/app/views/editForm.scala.html
                  HASH: 21d1c018b4aba937be17122435c6eaa7cb7d2f63
                  MATRIX: 984->1|1129->76|1174->73|1202->92|1229->94|1240->98|1278->100|1314->110|1372->143|1418->181|1457->183|1502->201|1553->225|1566->229|1597->239|1638->253|1732->326|1773->340|1875->421|1916->435|2022->520|2076->547|2319->769|2364->787|2549->945|2564->951|2607->973|2691->1027|2728->1038|2797->1098|2837->1100|2874->1110|2887->1114|2918->1124|2954->1133|3059->1208|3096->1215
                  LINES: 28->1|31->3|34->1|36->4|37->5|37->5|37->5|39->7|41->9|41->9|41->9|43->11|44->12|44->12|44->12|45->13|45->13|46->14|46->14|47->15|47->15|49->17|54->22|56->24|60->28|60->28|60->28|63->31|65->33|65->33|65->33|66->34|66->34|66->34|67->35|68->36|70->38
                  -- GENERATED --
              */
          