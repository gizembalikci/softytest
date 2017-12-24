
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

object createForm extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Form[Computer],Map[String, String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(computerForm: Form[Computer], companies: Map[String, String]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*3.2*/import helper._


Seq[Any](format.raw/*1.64*/("""

"""),format.raw/*4.1*/("""
"""),_display_(/*5.2*/main/*5.6*/ {_display_(Seq[Any](format.raw/*5.8*/("""
    
    """),format.raw/*7.5*/("""<h1>Add a computer</h1>
    
    """),_display_(/*9.6*/form(routes.HomeController.save())/*9.40*/ {_display_(Seq[Any](format.raw/*9.42*/("""
        
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
        """),format.raw/*23.9*/("""</fieldset>
        
        <div class="actions">
            <input type="submit" value="Create this computer" class="btn primary"> or 
            <a href=""""),_display_(/*27.23*/routes/*27.29*/.HomeController.list()),format.raw/*27.51*/("""" class="btn">Cancel</a>
        </div>
        
    """)))}),format.raw/*30.6*/("""
    
""")))}),format.raw/*32.2*/("""
"""))
      }
    }
  }

  def render(computerForm:Form[Computer],companies:Map[String, String]): play.twirl.api.HtmlFormat.Appendable = apply(computerForm,companies)

  def f:((Form[Computer],Map[String, String]) => play.twirl.api.HtmlFormat.Appendable) = (computerForm,companies) => apply(computerForm,companies)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Dec 20 14:38:11 EET 2017
                  SOURCE: /home/gizem/Desktop/softytest/backend/app/views/createForm.scala.html
                  HASH: d2775bd4fdb8e80e4d6fcbf3a0a3c338d1e16ace
                  MATRIX: 981->1|1116->66|1161->63|1189->82|1216->84|1227->88|1265->90|1301->100|1360->134|1402->168|1441->170|1486->188|1537->212|1550->216|1581->226|1622->240|1716->313|1757->327|1859->408|1900->422|2006->507|2048->522|2291->744|2327->753|2514->913|2529->919|2572->941|2656->995|2693->1002
                  LINES: 28->1|31->3|34->1|36->4|37->5|37->5|37->5|39->7|41->9|41->9|41->9|43->11|44->12|44->12|44->12|45->13|45->13|46->14|46->14|47->15|47->15|49->17|54->22|55->23|59->27|59->27|59->27|62->30|64->32
                  -- GENERATED --
              */
          