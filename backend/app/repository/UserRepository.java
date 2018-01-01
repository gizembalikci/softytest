package repository;

import io.ebean.*;
import models.User;
import play.db.ebean.EbeanConfig;

import javax.inject.Inject;
import java.security.NoSuchAlgorithmException;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import java.security.MessageDigest;

public class UserRepository {
    private final EbeanServer ebeanServer;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public UserRepository(EbeanConfig ebeanConfig, DatabaseExecutionContext executionContext){
        this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
        this.executionContext = executionContext;
    }

    public static Finder<String, User> find = new Finder<>(User.class);

    public static String hashPassword(String password){
        String hashedPassword = "";
        try {
            MessageDigest passwordHash = MessageDigest.getInstance("SHA-256");
            passwordHash.update(password.getBytes());
            hashedPassword = new String(passwordHash.digest());
        }
        catch (NoSuchAlgorithmException e){
            System.out.println("No such algorithm");
        }

        return hashedPassword;
    }
    public void createUser(String email, String password){
        User user = new User();
        user.email = email;



        ebeanServer.insert(user);
    }

    public String authenticate(String id) {
        User user = find.byId(id);
        return user.password;
    }

    public void updateName(String id, String name) {
        User user = find.byId(id);
        user.name = name;
        ebeanServer.save(user);
    }

//    //String testStatistics, String profilePic, String bio
//    public void updateStatistics(String id, String testStatistics){
//        User user = find.byId(id);
//        user.testStatistics = testStatistics;
//        ebeanServer.save(user);
//    }

    public void updatePP(String id, String profilePic){
        User user = find.byId(id);
        user.profilePic = profilePic;
        ebeanServer.save(user);
    }

    public void updateBio(String id, String bio){
        User user = find.byId(id);
        user.bio = bio;
        ebeanServer.save(user);
    }
}