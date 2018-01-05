
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

object editProfile extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[User,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(user: User):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.14*/("""

"""),format.raw/*3.1*/("""<html>

    <head>
        <title>Softytest</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href=""""),_display_(/*9.39*/routes/*9.45*/.Assets.versioned("stylesheets/theme.css")),format.raw/*9.87*/("""">
        <link rel="stylesheet" href=""""),_display_(/*10.39*/routes/*10.45*/.Assets.versioned("stylesheets/font-awesome.min.css")),format.raw/*10.98*/("""" type="text/css">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*11.59*/routes/*11.65*/.Assets.versioned("images/favicon.png")),format.raw/*11.104*/("""">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src=""""),_display_(/*13.23*/routes/*13.29*/.Assets.versioned("javascripts/profilePic.js")),format.raw/*13.75*/(""""></script>
    </head>
    <body>
        <div class="py-5" >
            <div class="row" >
                <div class="col-md-4">
                    <form name = "edit" class="" method="post" action=""""),_display_(/*19.73*/routes/*19.79*/.UserController.update()),format.raw/*19.103*/("""" enctype="multipart/form-data">
                        <div class="form-group"> <label>Name</label>
                            <input type="name" name="name" class="form-control" value="""),_display_(/*21.88*/user/*21.92*/.name),format.raw/*21.97*/(""" """),format.raw/*21.98*/("""> </div>
                        <div class="form-group"> <label>Bio</label>
                            <textarea type="bio" name="bio" class="form-control">"""),_display_(/*23.83*/user/*23.87*/.bio),format.raw/*23.91*/("""</textarea></div>
                        <div class="form-group"> <label>Email</label>
                            <input type="email" name="email" class="form-control" value="""),_display_(/*25.90*/user/*25.94*/.email),format.raw/*25.100*/("""></div>
                        <div class="form-group"> <label>Password</label>
                            <input type="password" name="password" class="form-control" placeholder="Password"></div>
                        <button type="submit" class="btn btn-primary">Save</button>
                    </form>
                </div>
            </div>
        </div>
        <script src=""""),_display_(/*33.23*/routes/*33.29*/.Assets.versioned("javascripts/popper.min.js")),format.raw/*33.75*/("""" crossorigin="anonymous"></script>
        <script src=""""),_display_(/*34.23*/routes/*34.29*/.Assets.versioned("javascripts/bootstrap.min.js")),format.raw/*34.78*/("""" crossorigin="anonymous"></script>
        <script src=""""),_display_(/*35.23*/routes/*35.29*/.Assets.versioned("javascripts/signupFormValidation.js")),format.raw/*35.85*/(""""></script>
        <pingendo onclick="window.open('https://pingendo.com/', '_blank')" style="cursor:pointer;position: fixed;bottom: 10px;right:10px;padding:2px;background-color: #00b0eb;border-radius: 8px; width:100px;display:flex;flex-direction:row;align-items:center;justify-content:center;font-size:12px;color:white">made with&nbsp;&nbsp;
            <img src="https://pingendo.com/site-assets/Pingendo_logo_big.png" class="d-block" alt="Pingendo logo" height="16">
        </pingendo>
    </body>
</html>"""))
      }
    }
  }

  def render(user:User): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((User) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Jan 05 12:04:18 GMT 2018
                  SOURCE: /home/cagdas/softytestFinal/backend/app/views/editProfile.scala.html
                  HASH: af3e521f5f291ce6d600aa57754e807ef6daeb4d
                  MATRIX: 952->1|1059->13|1087->15|1311->213|1325->219|1387->261|1455->302|1470->308|1544->361|1648->438|1663->444|1724->483|1873->605|1888->611|1955->657|2187->862|2202->868|2248->892|2464->1081|2477->1085|2503->1090|2532->1091|2718->1250|2731->1254|2756->1258|2960->1435|2973->1439|3001->1445|3418->1835|3433->1841|3500->1887|3585->1945|3600->1951|3670->2000|3755->2058|3770->2064|3847->2120
                  LINES: 28->1|33->1|35->3|41->9|41->9|41->9|42->10|42->10|42->10|43->11|43->11|43->11|45->13|45->13|45->13|51->19|51->19|51->19|53->21|53->21|53->21|53->21|55->23|55->23|55->23|57->25|57->25|57->25|65->33|65->33|65->33|66->34|66->34|66->34|67->35|67->35|67->35
                  -- GENERATED --
              */
          