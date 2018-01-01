package controllers;

import forms.LoginForm;
import models.Statistics;
import models.User;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

import play.mvc.Security;
import repository.UserRepository;
import services.StoreSecured;
import views.html.*;
import views.html.index;
import views.html.users.*;

public class UserController extends Controller{

    @Inject
    FormFactory formFactory;

    public Result showAll(){
        List<User> users = User.find.all();
        return ok(views.html.users.index.render(users));
    }

    public Result index() {
        Form<User> userForm = formFactory.form(User.class);
        return ok(index.render(userForm, flash()));
    }

    public Result save(){
        DynamicForm requestData = formFactory.form().bindFromRequest(); //Model olmadan formdan veri çekebiliyosun böyle
        String email = requestData.get("email");
        if(User.find.byId(email) != null)
            return notAcceptable("This email is already registered"); //TODO: bunun yerine js ile bi çözüm bulunması lazım :(
        User user = new User();
        String password = requestData.get("password");
        user.email = email;
        user.password = UserRepository.hashPassword(password);
        user.name = email.split("@")[0];
        Logger.debug(user.name);
        //Correct and incorrect asnwers each category seperated by semicolon;
        user.profilePic = "ppexample.jpg";
        user.save();
        Statistics statistics = new Statistics();
        statistics.user = user;
        statistics.save();
        List<Statistics> statisticsList = user.getTestStatistics();
        statisticsList.add(statistics);
        user.setTestStatistics(statisticsList);
        user.update();

        return redirect(routes.UserController.index());
    }

    public Result authenticate(){
        Form<User> userForm = formFactory.form(User.class).bindFromRequest("email", "password");
        User user = userForm.bindFromRequest().get();
        User dbUser = User.find.byId(user.email);
        if(dbUser == null){
            return notFound("User not found or wrong password");
        }
        else if(dbUser.password.equals(UserRepository.hashPassword(user.password))){
            session().put("user", dbUser.email);
            flash().put("loggedin", "1");
            return redirect(routes.UserController.profile());
        }
        else
            return badRequest();
    }

    public Result edit(String id){
        User user = User.find.byId(id);
        if(user == null){
            return notFound("User not found");
        }
        Form<User> userForm = formFactory.form(User.class).fill(user);
        return ok(edit.render(userForm));
    }

    public Result update(){
        DynamicForm requestData = formFactory.form().bindFromRequest();
        String email = requestData.get("email");
        User oldUser = User.find.byId(email);
        if(oldUser == null){
            return notFound("User not found");
        }
        oldUser.setEmail(email);
        oldUser.setPassword(requestData.get("password"));
        oldUser.setBio(requestData.get("bio"));
        oldUser.setProfilePic(requestData.get("profilePic"));
        oldUser.setName(requestData.get("name"));
        oldUser.update();
        return redirect(routes.UserController.index());
    }

    @Security.Authenticated(StoreSecured.class)
    public Result show(String id){
        User user = User.find.byId(id);
        if(user == null || !id.equals(session().get("user"))){
            return unauthorized("You're not authorized to see this page");
        }
        return ok(show.render(user));
    }

    @Security.Authenticated(StoreSecured.class)
    public Result profile(){
        String email = session().get("user");
        User user = User.find.byId(email);
        if(user != null)
            return ok(profilePage.render(user));
        return badRequest();
    }

    @Security.Authenticated(StoreSecured.class)
    public Result logout(){
        session().remove("user");
        return redirect(routes.UserController.index());
    }

    public Result destroy(String id){
        User user = User.find.byId(id);
        if(user == null){
            return notFound("User not found");
        }
        user.delete();
        return redirect(routes.UserController.index());
    }
}
