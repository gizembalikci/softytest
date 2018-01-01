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

    @OneToMany(mappedBy = "user")
    public List<Statistics> testStatistics;

    public String profilePic;
    public String bio;

    public static Finder<String, User> find = new Finder<>(User.class);

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Statistics> getTestStatistics() {
        return testStatistics;
    }

    public void setTestStatistics(List<Statistics> testStatistics) {
        this.testStatistics = testStatistics;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
