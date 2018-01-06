
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

object result extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[String,String,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(numOfCorrect:String)(numOfWrong:String)(successRate:String)(overallSuccessRate:String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.89*/("""
"""),_display_(/*2.2*/layout("Test Results")/*2.24*/{_display_(Seq[Any](format.raw/*2.25*/("""
    """),format.raw/*3.5*/("""<div class="container">
        <div class="py-5">
            <div class="row">
                <div class="col-md-12">
                    <a href="profile.html">
                        <img src="./images/ppexample.jpg" width="200px" class="float-left rounded-circle m-0"> </a>
                </div>
                <div class="col-md-12">
                    <h1 class="display-3 text-center">Results of "Test Code"</h1>
                </div>
            </div>
            <div class="py-3">
                <div class="row">
                    <div class="col-md-12">
                        <h1 class="display-4 px-5 ml-auto">Number of correct answers:"""),_display_(/*17.87*/numOfCorrect),format.raw/*17.99*/("""</h1>
                        <h1 class="display-4 px-5 ml-auto">Number of incorrect answers:"""),_display_(/*18.89*/numOfWrong),format.raw/*18.99*/("""</h1>
                    </div>
                </div>
            </div>
            <div class="p-1">
                <div class="row">
                    <div class="col-md-12 text-center">
                        <p class="lead"> Success Rate </p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="progress">
                            <div class="progress-bar progress-bar-striped" role="progressbar" style="width: """),_display_(/*31.110*/successRate),format.raw/*31.121*/("""%" aria-valuemin="0" aria-valuemax="100" aria-valuenow=""""),_display_(/*31.178*/successRate),format.raw/*31.189*/(""""> """),_display_(/*31.193*/successRate),format.raw/*31.204*/("""</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 text-center">
                    <p class="lead"> Overall Success Rate </p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="progress">
                        <div class="progress-bar progress-bar-striped" role="progressbar" style="width: """),_display_(/*44.106*/overallSuccessRate),format.raw/*44.124*/("""%" aria-valuemin="0" aria-valuemax="100" aria-valuenow=""""),_display_(/*44.181*/overallSuccessRate),format.raw/*44.199*/(""""> """),_display_(/*44.203*/overallSuccessRate),format.raw/*44.221*/("""</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
""")))}))
      }
    }
  }

  def render(numOfCorrect:String,numOfWrong:String,successRate:String,overallSuccessRate:String): play.twirl.api.HtmlFormat.Appendable = apply(numOfCorrect)(numOfWrong)(successRate)(overallSuccessRate)

  def f:((String) => (String) => (String) => (String) => play.twirl.api.HtmlFormat.Appendable) = (numOfCorrect) => (numOfWrong) => (successRate) => (overallSuccessRate) => apply(numOfCorrect)(numOfWrong)(successRate)(overallSuccessRate)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Jan 06 17:42:36 EET 2018
                  SOURCE: /home/gizem/Desktop/softytest/backend/app/views/result.scala.html
                  HASH: 3a89ac44449064cb3d2b8120ca9d2dfc7b1b1cc0
                  MATRIX: 970->1|1152->88|1179->90|1209->112|1247->113|1278->118|1968->781|2001->793|2122->887|2153->897|2719->1435|2752->1446|2837->1503|2870->1514|2902->1518|2935->1529|3475->2041|3515->2059|3600->2116|3640->2134|3672->2138|3712->2156
                  LINES: 28->1|33->1|34->2|34->2|34->2|35->3|49->17|49->17|50->18|50->18|63->31|63->31|63->31|63->31|63->31|63->31|76->44|76->44|76->44|76->44|76->44|76->44
                  -- GENERATED --
              */
          