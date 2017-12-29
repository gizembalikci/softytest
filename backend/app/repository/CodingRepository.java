package repository;

import io.ebean.Ebean;
import io.ebean.EbeanServer;
import io.ebean.Finder;
import models.CodingQuestion;
import play.db.ebean.EbeanConfig;

import javax.inject.Inject;

public class CodingRepository {
    private final EbeanServer ebeanServer;
    private final DatabaseExecutionContext executionContext;

    @Inject
    public CodingRepository(EbeanConfig ebeanConfig, DatabaseExecutionContext executionContext){
        this.ebeanServer = Ebean.getServer(ebeanConfig.defaultServer());
        this.executionContext = executionContext;
    }

    public static Finder<Long, CodingQuestion> find = new Finder<>(CodingQuestion.class);

    public void insertCodingQuestion(String questionContent, int category, int difficulty, int timeToSolve, String inputs, String outputs, String programmingLanguage){
        CodingQuestion coding = new CodingQuestion();
        coding.questionContent = questionContent;
        coding.category = category;
        coding.difficulty = difficulty;
        coding.timeToSolve = timeToSolve;
        coding.inputs = inputs;
        coding.outputs = outputs;
        coding.programmingLanguage = programmingLanguage;

        ebeanServer.insert(coding);
    }

}
