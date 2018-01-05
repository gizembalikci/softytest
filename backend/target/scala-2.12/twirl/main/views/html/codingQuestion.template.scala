
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

object codingQuestion extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.4*/("""

"""),_display_(/*3.2*/layout("Coding Question")/*3.27*/{_display_(Seq[Any](format.raw/*3.28*/("""
    """),format.raw/*4.5*/("""div class="py-5">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <p class="lead"> Remaining Time </p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 offset-md-8">
                <div class="progress">
                    <div class="progress-bar progress-bar-striped" role="progressbar" style="width: 60%" aria-valuemin="0" aria-valuemax="100" aria-valuenow="50">60s</div>
                </div>
            </div>
        </div>
    </div>
    </div>
    <div class="py-2 my-3">
        <div class="container my-3">
            <div class="row">
                <div class="col-md-12">
                    <p class="">Question body for multiple choice question.Question body for multiple choice question.Question body for multiple choice question.Question body for multiple choice question.Question body for multiple choice question.Question body for multiple
                        choice question.Question body for multiple choice question.Question body for multiple choice question.Question body for multiple choice question.Question body for multiple choice question.Question body for multiple choice question.Question
                        body for multiple choice question.</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form action="" method="get">
                            <!-----for the real project inputs can be created in for loop or the number of choices must be same for the each question ----->
                            <!----- sadece bir seçeneğin seçilmesi js de yapılcak galibe -->
                        <textarea type="text" class="form-control" name="sourceCode">Source Code</textarea>
                    </form>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 text-right px-1">
                    <a class="btn-primary text-right btn btn-sm py-2 my-2" href="">Submit</a>
                    <a class="btn-primary text-right btn btn-sm py-2 my-2" href="">Run</a>
                </div>
                <div class="col-md-12">
                    <form action="" method="get">
                            <!-----for the real project inputs can be created in for loop or the number of choices must be same for the each question ----->
                            <!----- sadece bir seçeneğin seçilmesi js de yapılcak galibe -->
                        <textarea type="text" class="form-control" name="output">Output</textarea>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center">
                <p class="lead"> Answred/Total Question </p>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="progress">
                    <div class="progress-bar progress-bar-striped" role="progressbar" style="width: 60%" aria-valuemin="0" aria-valuemax="100" aria-valuenow="50">60s</div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 text-right py-2">
                <a class="btn-primary text-right btn px-4" href="">Finish Test </a>
            </div>
        </div>
    </div>
""")))}))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Jan 05 13:18:18 GMT 2018
                  SOURCE: /home/cagdas/softytestFinal/backend/app/views/codingQuestion.scala.html
                  HASH: 6421f565d179037d1b864208e479463de518d7ae
                  MATRIX: 950->1|1046->3|1074->6|1107->31|1145->32|1176->37
                  LINES: 28->1|33->1|35->3|35->3|35->3|36->4
                  -- GENERATED --
              */
          