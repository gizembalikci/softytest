package controllers;

import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

import views.html.index;
import views.html.users.*;

public class UserController extends Controller{

    @Inject
    FormFactory formFactory;

    public Result index(){
        List<User> users = User.find.all();
        return ok(views.html.users.index.render(users));
    }

    public Result create() {
        //TODO: buraya hashing falan eklenecek yazmıştım aslında ama başka yerde
        Form<User> userForm = formFactory.form(User.class);
        return ok(create.render(userForm));
    }

    public Result save(){
        Form<User> userForm = formFactory.form(User.class);
        User user = userForm.bindFromRequest().get();
        user.save();
        return redirect(routes.UserController.index());
    }

    public Result edit(Long id){
        User user = User.find.byId(id);
        if(user == null){
            return notFound("User not found");
        }
        Form<User> userForm = formFactory.form(User.class).fill(user);
        return ok(edit.render(userForm));
    }

    public Result update(){
        User user = formFactory.form(User.class).bindFromRequest().get();
        User oldUser = User.find.byId(user.id);
        if(oldUser == null){
            return notFound("User not found");
        }
        oldUser.id = user.id;
        oldUser.email = user.email;
        oldUser.passwordSalt = user.passwordSalt;
        oldUser.passwordHash = user.passwordHash;
        oldUser.bio = user.bio;
        oldUser.profilePic = user.profilePic;
        oldUser.name = user.name;
        oldUser.update();
        return redirect(routes.UserController.index());
    }

    public Result show(Long id){
        User user = User.find.byId(id);
        if(user == null){
            return notFound("User not found");
        }
        return ok(show.render(user));
    }

    public Result destroy(Long id){
        User user = User.find.byId(id);
        if(user == null){
            return notFound("User not found");
        }
        user.delete();
        return redirect(routes.UserController.index());
    }
}
