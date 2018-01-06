
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Form[User],play.mvc.Http.Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userForm: Form[User], flash: play.mvc.Http.Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.52*/("""
"""),_display_(/*2.2*/layout("Softytest")/*2.21*/{_display_(Seq[Any](format.raw/*2.22*/("""
    """),format.raw/*3.5*/("""<div class="py-5 gradient-overlay">
        <div class="container py-5">
            <div class="row">
                <div class="col-md-3 text-white">
                    <img class="img-fluid d-block mx-auto mb-5" src="https://pingendo.github.io/templates/sections/assets/footer_logo2.png"> </div>
                <div class="col-md-9 text-white align-self-center">
                    <h1 class="display-3 mb-4">Softytest</h1>
                    <p class="lead mb-5">A place where you can find out your strong sides and bişey your weaknesses &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                        <br> </p>
                </div>
            </div>
            <div class="py-5">
                <div class="row">
                    <div class="col-md-4">
                        <ul class="nav nav-pills">
                            <li class="nav-item">
                                <a href="#login" class="active nav-link" data-toggle="tab">Log In</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#signup" data-toggle="tab">Sign Up</a>
                            </li>
                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane active" id="login">
                                <form name = "login" class="" method="post" action=""""),_display_(/*27.86*/routes/*27.92*/.UserController.authenticate()),format.raw/*27.122*/("""">
                                    <div class="form-group"> <label>Email address</label>
                                        <input type="email" name="email" class="form-control" placeholder="Enter email"> </div>
                                    <div class="form-group"> <label>Password</label>
                                        <input type="password" name="password" class="form-control" placeholder="Password"> </div>
                                    <button type="submit" class="btn btn-primary">Login</button>
                                </form>
                            </div>
                            <div class="tab-pane fade" id="signup">
                                <form name = "signup" class="" method="post" action=""""),_display_(/*36.87*/routes/*36.93*/.UserController.save()),format.raw/*36.115*/("""" onsubmit="return signUpFormValidation()">
                                    <div class="form-group"> <label>Email address</label>
                                        <input type="email" name="email" class="form-control" placeholder="Enter email"> </div>
                                    <div class="form-group"> <label>Password</label>
                                        <input type="password" name="password" class="form-control" placeholder="Password"> </div>
                                    <div class="form-group"> <label>Confirm Password</label>
                                        <input type="password" name="conpassword" class="form-control" placeholder="Confirm Password"> </div>
                                    <button type="submit" class="btn btn-primary">Sign Up</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
""")))}))
      }
    }
  }

  def render(userForm:Form[User],flash:play.mvc.Http.Flash): play.twirl.api.HtmlFormat.Appendable = apply(userForm,flash)

  def f:((Form[User],play.mvc.Http.Flash) => play.twirl.api.HtmlFormat.Appendable) = (userForm,flash) => apply(userForm,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sat Jan 06 16:11:12 EET 2018
                  SOURCE: /home/gizem/Desktop/softytest/backend/app/views/index.scala.html
                  HASH: 905b29662d3c8a7f48dd3c21dea3d0ad8e3181df
                  MATRIX: 972->1|1117->51|1144->53|1171->72|1209->73|1240->78|2710->1521|2725->1527|2777->1557|3567->2320|3582->2326|3626->2348
                  LINES: 28->1|33->1|34->2|34->2|34->2|35->3|59->27|59->27|59->27|68->36|68->36|68->36
                  -- GENERATED --
              */
          