package repository;

import io.ebean.*;
import models.User;
import play.db.ebean.EbeanConfig;

import javax.inject.Inject;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.concurrent.CompletionStage;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import java.security.MessageDigest;
import java.util.UUID;

public class UserRepository {
    private final EbeanServer ebeanServer;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public UserRepository(EbeanConfig ebeanConfig, DatabaseExecutionContext executionContext){
        this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
        this.executionContext = executionContext;
    }

    public static Finder<Long, User> find = new Finder<>(User.class);

    public void createUser(String email, String password){
        User user = new User();
        user.email = email;

        try {
            MessageDigest passwordHash = MessageDigest.getInstance("SHA-256");
            passwordHash.update(password.getBytes());
            user.passwordHash = new String(passwordHash.digest());
            String passwordSalt = UUID.randomUUID().toString().replace("-", "");
            user.passwordSalt = passwordSalt;
        }
        catch (NoSuchAlgorithmException e){
            System.out.println("No such algorithm");
        }

        ebeanServer.insert(user);
    }

    public String authenticate(Long id) {
        User user = find.byId(id);
        return user.passwordHash+user.passwordSalt;
    }

    public void updateName(Long id, String name) {
        User user = find.byId(id);
        user.name = name;
        ebeanServer.save(user);
    }

    //String testStatistics, String profilePic, String bio
    public void updateStatistics(Long id, String testStatistics){
        User user = find.byId(id);
        user.testStatistics = testStatistics;
        ebeanServer.save(user);
    }

    public void updatePP(Long id, String profilePic){
        User user = find.byId(id);
        user.profilePic = profilePic;
        ebeanServer.save(user);
    }

    public void updateBio(Long id, String bio){
        User user = find.byId(id);
        user.bio = bio;
        ebeanServer.save(user);
    }
}