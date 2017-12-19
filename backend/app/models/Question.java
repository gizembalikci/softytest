package models;

import java.util.*;
import javax.persistence.*;

import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@MappedSuperclass
public class Question extends BaseModel{

    @Constraints.Required
    public String questionContent;

    @Constraints.Required
    public int category;

    @Constraints.Required
    public int difficulty;

    @Constraints.Required
    public int timeToSolve;
}
