package models;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import io.ebean.annotation.DbJson;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table
public class CodingQuestion extends Question{

    @Column(columnDefinition = "TEXT")
    @Constraints.Required
    public String testcases;

    @Column(columnDefinition = "TEXT")
    @Constraints.Required
    public String outputs;

    @Constraints.Required
    public String programmingLanguage;

    @Column(columnDefinition = "TEXT")
    @Constraints.Required
    public String baseCode;

    public static Finder<Long, CodingQuestion> find = new Finder<>(CodingQuestion.class);
}
