
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

object layout extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.32*/("""
"""),format.raw/*2.1*/("""<html>

    <head>
        <title>"""),_display_(/*5.17*/title),format.raw/*5.22*/("""</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href=""""),_display_(/*8.39*/routes/*8.45*/.Assets.versioned("stylesheets/theme.css")),format.raw/*8.87*/("""">
        <link rel="stylesheet" href=""""),_display_(/*9.39*/routes/*9.45*/.Assets.versioned("stylesheets/font-awesome.min.css")),format.raw/*9.98*/("""" type="text/css">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*10.59*/routes/*10.65*/.Assets.versioned("images/favicon.png")),format.raw/*10.104*/("""">
    </head>
    <body>
    """),_display_(/*13.6*/content),format.raw/*13.13*/("""
        """),format.raw/*14.9*/("""<script src=""""),_display_(/*14.23*/routes/*14.29*/.Assets.versioned("javascripts/jquery-3.2.1.slim.min.js")),format.raw/*14.86*/("""" crossorigin="anonymous"></script>
        <script src=""""),_display_(/*15.23*/routes/*15.29*/.Assets.versioned("javascripts/popper.min.js")),format.raw/*15.75*/("""" crossorigin="anonymous"></script>
        <script src=""""),_display_(/*16.23*/routes/*16.29*/.Assets.versioned("javascripts/bootstrap.min.js")),format.raw/*16.78*/("""" crossorigin="anonymous"></script>
        <script src=""""),_display_(/*17.23*/routes/*17.29*/.Assets.versioned("javascripts/signupFormValidation.js")),format.raw/*17.85*/(""""></script>
        <pingendo onclick="window.open('https://pingendo.com/', '_blank')" style="cursor:pointer;position: fixed;bottom: 10px;right:10px;padding:2px;background-color: #00b0eb;border-radius: 8px; width:100px;display:flex;flex-direction:row;align-items:center;justify-content:center;font-size:12px;color:white">made with&nbsp;&nbsp;
            <img src="https://pingendo.com/site-assets/Pingendo_logo_big.png" class="d-block" alt="Pingendo logo" height="16">
        </pingendo>
    </body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Mon Jan 01 15:05:59 GMT 2018
                  SOURCE: /home/cagdas/softytestFinal/backend/app/views/layout.scala.html
                  HASH: fd30facdb5a3ed05926224db6b3b6bb023c5739a
                  MATRIX: 954->1|1079->31|1106->32|1167->67|1192->72|1373->227|1387->233|1449->275|1516->316|1530->322|1603->375|1707->452|1722->458|1783->497|1840->528|1868->535|1904->544|1945->558|1960->564|2038->621|2123->679|2138->685|2205->731|2290->789|2305->795|2375->844|2460->902|2475->908|2552->964
                  LINES: 28->1|33->1|34->2|37->5|37->5|40->8|40->8|40->8|41->9|41->9|41->9|42->10|42->10|42->10|45->13|45->13|46->14|46->14|46->14|46->14|47->15|47->15|47->15|48->16|48->16|48->16|49->17|49->17|49->17
                  -- GENERATED --
              */
          