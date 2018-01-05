
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

object categories extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.4*/("""

"""),_display_(/*3.2*/layout("Categories")/*3.22*/{_display_(Seq[Any](format.raw/*3.23*/("""
            """),format.raw/*4.13*/("""<div class="py-3">
                <div class="container">
                    <div class="row">
                        <h1 class="display-3">Choose a category and difficulty</h1>
                    </div>
                </div>
            </div>
            <div class="py-3">
                <div class="container">
                    <div class="row">
                        <a class="btn btn-primary w-25 text-info p-2 border border-info" href="" data-toggle="">Button </a>
                        <fieldset class="rating mx-auto py-2">
                            <input type="radio" id="star1.1" name="rating" value="1.1" class="mx-1"><label class="full" for="star1.1"></label>
                            <input type="radio" id="star1.2" name="rating" value="1.2" class="mx-1"><label class="full" for="star1.2"></label>
                            <input type="radio" id="star1.3" name="rating" value="1.3" class="mx-1"><label class="full" for="star1.3"></label> </fieldset>
                    </div>
                </div>
            </div>
            <div class="py-3">
                <div class="container">
                    <div class="row">
                        <a class="btn btn-primary w-25 text-info p-2 border border-info" href="" data-toggle="">Button </a>
                        <fieldset class="rating mx-auto py-2">
                            <input type="radio" id="star2.1" name="rating" value="2.1" class="mx-1"><label class="full" for="star2.1"></label>
                            <input type="radio" id="star2.2" name="rating" value="2.2" class="mx-1"><label class="full" for="star2.2"></label>
                            <input type="radio" id="star2.3" name="rating" value="2.3" class="mx-1"><label class="full" for="star2.3"></label> </fieldset>
                    </div>
                </div>
            </div>
            <div class="py-3">
                <div class="container">
                    <div class="row">
                        <a class="btn btn-primary w-25 text-info p-2 border border-info" href="" data-toggle="">Button </a>
                        <fieldset class="rating mx-auto py-2">
                            <input type="radio" id="star3.1" name="rating" value="3.1" class="mx-1"><label class="full" for="star3.1"></label>
                            <input type="radio" id="star3.2" name="rating" value="3.2" class="mx-1"><label class="full" for="star3.2"></label>
                            <input type="radio" id="star3.3" name="rating" value="3.3" class="mx-1"><label class="full" for="star3.3"></label> </fieldset>
                    </div>
                </div>
            </div>
            <div class="py-3">
                <div class="container">
                    <div class="row">
                        <a class="btn btn-primary w-25 text-info p-2 border border-info" href="" data-toggle="">Button </a>
                        <fieldset class="rating mx-auto py-2">
                            <input type="radio" id="star4.1" name="rating" value="4.1" class="mx-1"><label class="full" for="star4.1"></label>
                            <input type="radio" id="star4.2" name="rating" value="4.2" class="mx-1"><label class="full" for="star4.2"></label>
                            <input type="radio" id="star4.3" name="rating" value="4.3" class="mx-1"><label class="full" for="star4.3"></label> </fieldset>
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
                  DATE: Fri Jan 05 08:40:59 GMT 2018
                  SOURCE: /home/cagdas/softytestFinal/backend/app/views/categories.scala.html
                  HASH: 0a0a188a17ac9d55658b0ecd1f84b25b9c577589
                  MATRIX: 946->1|1042->3|1070->6|1098->26|1136->27|1176->40
                  LINES: 28->1|33->1|35->3|35->3|35->3|36->4
                  -- GENERATED --
              */
          