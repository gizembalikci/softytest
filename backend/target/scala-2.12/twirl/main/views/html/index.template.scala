
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Form[User],String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(userForm: Form[User], user: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.38*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html>

    <head>
        <title>Softytest</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href=""""),_display_(/*10.39*/routes/*10.45*/.Assets.versioned("stylesheets/theme.css")),format.raw/*10.87*/("""">
        <link rel="stylesheet" href=""""),_display_(/*11.39*/routes/*11.45*/.Assets.versioned("stylesheets/font-awesome.min.css")),format.raw/*11.98*/("""" type="text/css">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*12.59*/routes/*12.65*/.Assets.versioned("images/favicon.png")),format.raw/*12.104*/("""">

<body>
    <div class="py-5 gradient-overlay">
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
                                <a class="nav-link" href="#signup" data-toggle="tab">Sıgn UP</a>
                            </li>
                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane active" id="login">
                                <form name = "login" class="" method="post" action=""""),_display_(/*39.86*/routes/*39.92*/.UserController.authenticate()),format.raw/*39.122*/("""">
                                    <div class="form-group"> <label>Email address</label>
                                        <input type="email" name="email" class="form-control" placeholder="Enter email"> </div>
                                    <div class="form-group"> <label>Password</label>
                                        <input type="password" name="password" class="form-control" placeholder="Password"> </div>
                                    <button type="submit" class="btn btn-primary">Login</button>
                                </form>
                            </div>
                            <div class="tab-pane fade" id="signup">
                                <form name = "signup" class="" method="post" action=""""),_display_(/*48.87*/routes/*48.93*/.UserController.save()),format.raw/*48.115*/("""" onsubmit="return signUpFormValidation()">
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
    <script src=""""),_display_(/*64.19*/routes/*64.25*/.Assets.versioned("javascripts/jquery-3.2.1.slim.min.js")),format.raw/*64.82*/("""" crossorigin="anonymous"></script>
    <script src=""""),_display_(/*65.19*/routes/*65.25*/.Assets.versioned("javascripts/popper.min.js")),format.raw/*65.71*/("""" crossorigin="anonymous"></script>
    <script src=""""),_display_(/*66.19*/routes/*66.25*/.Assets.versioned("javascripts/bootstrap.min.js")),format.raw/*66.74*/("""" crossorigin="anonymous"></script>
    <script src=""""),_display_(/*67.19*/routes/*67.25*/.Assets.versioned("javascripts/signupFormValidation.js")),format.raw/*67.81*/(""""></script>
    <pingendo onclick="window.open('https://pingendo.com/', '_blank')" style="cursor:pointer;position: fixed;bottom: 10px;right:10px;padding:2px;background-color: #00b0eb;border-radius: 8px; width:100px;display:flex;flex-direction:row;align-items:center;justify-content:center;font-size:12px;color:white">made with&nbsp;&nbsp;
        <img src="https://pingendo.com/site-assets/Pingendo_logo_big.png" class="d-block" alt="Pingendo logo" height="16">
    </pingendo>
</body>

</html>"""))
      }
    }
  }

  def render(userForm:Form[User],user:String): play.twirl.api.HtmlFormat.Appendable = apply(userForm,user)

  def f:((Form[User],String) => play.twirl.api.HtmlFormat.Appendable) = (userForm,user) => apply(userForm,user)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Sun Dec 31 15:37:16 GMT 2017
                  SOURCE: /home/cagdas/softytestFinal/backend/app/views/index.scala.html
                  HASH: 9a7e3ef59ab1efca2a0276902ee862dbcc92c32c
                  MATRIX: 959->1|1090->37|1118->39|1359->253|1374->259|1437->301|1505->342|1520->348|1594->401|1698->478|1713->484|1774->523|3259->1981|3274->1987|3326->2017|4116->2780|4131->2786|4175->2808|5233->3839|5248->3845|5326->3902|5407->3956|5422->3962|5489->4008|5570->4062|5585->4068|5655->4117|5736->4171|5751->4177|5828->4233
                  LINES: 28->1|33->1|35->3|42->10|42->10|42->10|43->11|43->11|43->11|44->12|44->12|44->12|71->39|71->39|71->39|80->48|80->48|80->48|96->64|96->64|96->64|97->65|97->65|97->65|98->66|98->66|98->66|99->67|99->67|99->67
                  -- GENERATED --
              */
          