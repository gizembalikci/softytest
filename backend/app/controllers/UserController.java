package controllers;

import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

import repository.UserRepository;
import views.html.users.*;

public class UserController extends Controller{

    @Inject
    FormFactory formFactory;

    public Result index(){
        List<User> users = User.find.all();
        return ok(views.html.users.index.render(users));
    }

    public Result create() {
        Form<User> userForm = formFactory.form(User.class);
        return ok(create.render(userForm));
    }

    public Result save(){
        Form<User> userForm = formFactory.form(User.class);
        User user = userForm.bindFromRequest().get();
        user.password = UserRepository.hashPassword(user.password);
        user.save();
        return redirect(routes.UserController.index());
    }

    public Result login() {
        Form<User> userForm = formFactory.form(User.class);
        return ok(login.render(userForm));
    }

    public Result authenticate(){
        Form<User> userForm = formFactory.form(User.class);
        User user = userForm.bindFromRequest().get();
        User dbUser = User.find.byId(user.email);
        if(dbUser == null){
            return notFound("User not found");
        }
        else if(dbUser.password.equals(UserRepository.hashPassword(user.password))){
            return redirect(routes.UserController.show(user.email));
        }
        else {
            return notFound("Wrong password");
        }
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
        User user = formFactory.form(User.class).bindFromRequest().get();
        User oldUser = User.find.byId(user.email);
        if(oldUser == null){
            return notFound("User not found");
        }
        oldUser.email = user.email;
        oldUser.password = user.password;
        oldUser.bio = user.bio;
        oldUser.profilePic = user.profilePic;
        oldUser.name = user.name;
        oldUser.update();
        return redirect(routes.UserController.index());
    }

    public Result show(String id){
        User user = User.find.byId(id);
        if(user == null){
            return notFound("User not found");
        }
        return ok(show.render(user));
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
