package models;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table
public class UserAccount extends BaseModel{
    private static final long serialVersionUID = 1L;
    @Constraints.Required
    @Constraints.Email
    public String email;

    @Constraints.Required
    public String passwordHash;

    @Constraints.Required
    public String passwordSalt;

    @OneToOne
    public UserProfile userProfile;
}
