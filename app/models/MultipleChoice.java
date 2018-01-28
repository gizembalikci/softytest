package models;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table
public class MultipleChoice extends Question{

    @Constraints.Required
    public String choice1;
    @Constraints.Required
    public String choice2;
    @Constraints.Required
    public String choice3;
    @Constraints.Required
    public String choice4;
    @Constraints.Required
    public String correctAnswer;

    public static Finder<Long, MultipleChoice> find = new Finder<>(MultipleChoice.class);
}
