package controllers;

import akka.http.javadsl.model.MediaType;
import akka.stream.Materializer;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import io.ebeaninternal.server.type.ScalarTypeJsonMap;
import models.CodingQuestion;
import play.libs.Json;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;
import play.libs.ws.ahc.AhcWSClient;

import models.ProfilePic;
import models.Statistics;
import models.User;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.db.ebean.Transactional;
import play.libs.ws.WSClient;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import java.io.File;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.persistence.Lob;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Blob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletionStage;

import play.mvc.Security;
import repository.UserRepository;
import services.StoreSecured;
import sun.rmi.runtime.Log;
import views.html.*;
import views.html.index;
import views.html.users.*;

public class UserController extends Controller{

    @Inject
    FormFactory formFactory;

    @Inject
    WSClient ws;

    @Inject
    Materializer materializer;

    public Result showAll(){
        List<User> users = User.find.all();
        return ok(views.html.users.index.render(users));
    }

    public Result index() {
        Form<User> userForm = formFactory.form(User.class);

            return ok(index.render(userForm, flash()));

    }

    @Transactional
    public Result save(){
        DynamicForm requestData = formFactory.form().bindFromRequest(); //Model olmadan formdan veri çekebiliyosun böyle
        String email = requestData.get("email");
        if(User.find.byId(email) != null)
            return notAcceptable("This email is already registered");
        User user = new User();
        String password = requestData.get("passwordSave");
        user.email = email;
        session().put("user", user.email);
        user.password = UserRepository.hashPassword(password);
        Logger.debug("Password hash: " + user.password);
        user.name = email.split("@")[0];
        Logger.debug(user.name);
        ProfilePic profilePic = new ProfilePic();
        try {
            profilePic.pic = extractBytes("public/images/ppexample.jpg");
            profilePic.save();
        }
        catch (IOException e){
            System.out.println("Something went wrong");
        }
        user.profilePic = profilePic;
        user.save();
        Logger.debug("After save: " + user.password);
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
        //TODO: email registered error js view yazılacak.
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
            return redirect(routes.UserController.profile());
        }
        else
            return badRequest();
    }

    @Security.Authenticated(StoreSecured.class)
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
//        byte[] pp = requestData.get("photo").getBytes();
//        if(pp.length > 1){
//            ProfilePic profilePic = new ProfilePic();
//            profilePic.pic = pp;
//            profilePic.save();
//            oldUser.setProfilePic(profilePic);
//        }
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

    public static void uploadPicture(ProfilePic profilePic){
        profilePic.save();
    }

    public Result getPP(){
        User user = User.find.byId(session().get("user"));
        ProfilePic profilePic = ProfilePic.find.byId(user.profilePic.id);
        return ok(profilePic.pic).as("image/jpeg");
    }



    public byte[] extractBytes (String ImageName) throws IOException {
        // open image
        File imgPath = new File(ImageName);
        BufferedImage bufferedImage = ImageIO.read(imgPath);

        // get DataBufferBytes from Raster
        WritableRaster raster = bufferedImage .getRaster();
        DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();

        return ( data.getData() );
    }


    public Result code(Long id){
        CodingQuestion codingQuestion = CodingQuestion.find.byId(id);
        String source = request().body().asText();
        Logger.debug(source);
        String body = "source=" + java.net.URLEncoder.encode(source) + "&lang=" + codingQuestion.programmingLanguage + "&testcases=" + java.net.URLEncoder.encode(codingQuestion.testcases) + "&api_key=hackerrank%7C2457518-2104%7C9d116831bff01e4b23474b30324b288025403da9";
        CompletionStage<WSResponse> response = ws.url("http://api.hackerrank.com/checker/submission.json").
                setHeader("Accept", "application/json").
                setHeader("Content-Type", "application/x-www-form-urlencoded").
                post(body);

        JsonNode json = response.toCompletableFuture().join().asJson();

        String pretty = Json.prettyPrint(json);
        String stringified = Json.stringify(json);
        Logger.debug(pretty);
        Logger.debug(stringified);
        Map<String, String> mapped = new HashMap<String, String>();

        return ok(json);
    }

}
