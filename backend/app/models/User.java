package models;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import io.ebean.annotation.DbArray;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table
public class User extends Model{
    private static final long serialVersionUID = 1L;
    @Constraints.Required
    @Constraints.Email
    @Id
    public String email;

    @Constraints.Required
    public String password;

    public String name;
    public String testStatistics;
    public String profilePic;
    public String bio;

    public static Finder<String, User> find = new Finder<>(User.class);
}
