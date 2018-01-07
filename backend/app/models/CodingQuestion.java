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


    //base code,language,test case
    //source,lang,testcases
    //testcases =["1","2","3"]
    @DbJson
    Map<String,String> codingQuestionContent;


//    @Constraints.Required
//    public String inputs;
//
//    @Constraints.Required
//    public String outputs;
//
//    @Constraints.Required
//    public String programmingLanguage;
//
//    @Constraints.Required
//    public String baseCode;

    public static Finder<Long, CodingQuestion> find = new Finder<>(CodingQuestion.class);
}
