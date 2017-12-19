package models;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table
public class UserProfile extends BaseModel{
    @Constraints.Required
    public String nameSurname;

    @Constraints.Required
    public String testStatistics;

    @Constraints.Required
    public String profilePic;

    @Constraints.Required
    public String Bio;
}
