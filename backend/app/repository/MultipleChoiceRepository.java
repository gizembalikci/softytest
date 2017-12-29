package repository;

import io.ebean.Ebean;
import io.ebean.EbeanServer;
import io.ebean.Finder;
import models.MultipleChoice;
import play.db.ebean.EbeanConfig;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceRepository {

    private final EbeanServer ebeanServer;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public MultipleChoiceRepository(EbeanConfig ebeanConfig, DatabaseExecutionContext executionContext){
        this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
        this.executionContext = executionContext;
    }

    public static Finder<Long, MultipleChoice> find = new Finder<>(MultipleChoice.class);

    public void insertMultipleChoice(String questionContent, int category, int difficulty, int timeToSolve, String choices) {
        MultipleChoice multipleChoice = new MultipleChoice();
        multipleChoice.questionContent = questionContent;
        multipleChoice.category = category;
        multipleChoice.difficulty = difficulty;
        multipleChoice.timeToSolve = timeToSolve;
        multipleChoice.choices = choices;

        ebeanServer.insert(multipleChoice);
    }

    public String[] parseChoices(Long id){
        String choiceString = find.byId(id).choices;
        return choiceString.split(";");
    }
}
