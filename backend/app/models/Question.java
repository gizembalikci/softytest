package models;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.Size;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@MappedSuperclass
public class Question extends BaseModel{

    @Column(columnDefinition = "TEXT")
    @Constraints.Required
    public String questionContent;

    @Constraints.Required
    public int category;

    @Constraints.Required
    public int difficulty;

    @Constraints.Required
    public int timeToSolve;

    public static Finder<Long, Question> find = new Finder<>(Question.class);

}
