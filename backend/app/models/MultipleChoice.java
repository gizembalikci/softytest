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
    public String choices;

    public static Finder<Long, MultipleChoice> find = new Finder<>(MultipleChoice.class);
}
