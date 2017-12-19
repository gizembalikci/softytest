package models;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table
public class Coding extends Question{
    @Constraints.Required
    public String inputs;

    @Constraints.Required
    public String outputs;

    @Constraints.Required
    public String programmingLanguage;
}
