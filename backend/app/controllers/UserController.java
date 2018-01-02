package controllers;

import models.Statistics;
import models.User;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.db.ebean.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;
import java.util.Random;

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
        if(session().get("user") == null)
            return ok(index.render(userForm, flash()));
        else
            return redirect(routes.UserController.profile());
    }

    @Transactional
    public Result save(){
        DynamicForm requestData = formFactory.form().bindFromRequest(); //Model olmadan formdan veri çekebiliyosun böyle
        String email = requestData.get("email");
        if(User.find.byId(email) != null)
            return notAcceptable("This email is already registered");
        User user = new User();
        String password = requestData.get("password");
        user.email = email;
        session().put("user", user.email);
        user.password = UserRepository.hashPassword(password);
        user.name = email.split("@")[0];
        Logger.debug(user.name);
        //Correct and incorrect asnwers each category seperated by semicolon;
        user.profilePic = "ppexample.jpg";
        user.save();
        for(int i = 0; i < 3; i++) {
            Statistics statistics = new Statistics();
            statistics.user = user;
            statistics.category = i+1;
            Random random = new Random();
            statistics.correct = random.nextInt(50);
            statistics.wrong = random.nextInt(50);
            statistics.save();
            List<Statistics> statisticsList = user.getTestStatistics();
            statisticsList.add(statistics);
            user.setTestStatistics(statisticsList);
            user.update();
        }
        return redirect(routes.UserController.edit());
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

    public Result edit(){
        User user = User.find.byId(session().get("user"));
        return ok(editProfile.render(user));
    }

    @Security.Authenticated(StoreSecured.class)
    public Result update(){
        DynamicForm requestData = formFactory.form().bindFromRequest();
        String email = session().get("user");
        User oldUser = User.find.byId(email);
        if(oldUser == null){
            return notFound("User not found");
        }
        email = requestData.get("email");
        if(email != "")
            oldUser.setEmail(email);
        String pw = requestData.get("password");
        if(pw != "")
            oldUser.setPassword(UserRepository.hashPassword(pw));
        else
            oldUser.setPassword(oldUser.password);
        String bio = requestData.get("bio");
        if(bio != "")
            oldUser.setBio(bio);
        String name = requestData.get("name");
        if(name != "")
            oldUser.setName(name);
        oldUser.update();
        return redirect(routes.UserController.profile());
    }
//
//    @Security.Authenticated
//    @public Result updateTest(Statistics statistics){
//        User user = User.find.byId(session())
//    }

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
