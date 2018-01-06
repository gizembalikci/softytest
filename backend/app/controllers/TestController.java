package controllers;

import akka.http.javadsl.model.HttpResponse;
import com.fasterxml.jackson.databind.JsonNode;
import io.ebean.Ebean;
import models.*;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.codingQuestion;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestController extends Controller{


    public static int totalAnswered(Statistics statistics){
        return statistics.correct+statistics.wrong;
    }

    public static int wrong(Statistics statistics){
        return statistics.wrong;
    }

    public static int correct(Statistics statistics){
        return statistics.correct;
    }

    public static String successRate(Statistics statistics){
        double result = ((statistics.correct+0.0001)/((double)statistics.correct+(double)statistics.wrong+0.0001))*100;
        NumberFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(result);
    }

    public static int overallTotal(List<Statistics> statistics){
        int sum = 0;
        for(Statistics statistic: statistics){
            sum += totalAnswered(statistic);
        }

        return sum;
    }

    public static int overallWrong(List<Statistics> statistics){
        int sum = 0;
        for(Statistics statistic: statistics){
            sum += wrong(statistic);
        }

        return sum;
    }

    public static int overallCorrect(List<Statistics> statistics){
        int sum = 0;
        for(Statistics statistic: statistics){
            sum += correct(statistic);
        }

        return sum;
    }

    public static String overallSuccessRate(List<Statistics> statistics){
        double result = ((overallCorrect(statistics)+0.0001)/((double)overallCorrect(statistics)+(double)overallWrong(statistics)+0.0001))*100;
        NumberFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(result);

    }

//    public static List<Question> generateMixedTest(int difficulty){
//        int n = difficulty * 15;
//        List<Question> questions = Question.find.all();
//        List<Question> testQuestions = new ArrayList<>();
//
//        for(int i = 0; i < n; i++){
//            Question question = questions.get(new Random().nextInt(questions.size()));
//            testQuestions.add(question);
//        }
//
//        return testQuestions;
//    }
//
//    public static List<CodingQuestion> generateCodingTest(int difficulty){
//        int n = difficulty * 5;
//        List<CodingQuestion> questions = CodingQuestion.find.all();
//        List<CodingQuestion> testQuestions = new ArrayList<>();
//
//        for(int i = 0; i < n; i++){
//            CodingQuestion question = questions.get(new Random().nextInt(questions.size()));
//            testQuestions.add(question);
//        }
//
//        return testQuestions;
//    }
//
//    public static List<MultipleChoice> generateMultipleChoiceTest(int difficulty){
//        int n = difficulty * 5;
//        List<MultipleChoice> questions = MultipleChoice.find.all();
//        List<MultipleChoice> testQuestions = new ArrayList<>();
//
//        for(int i = 0; i < n; i++){
//            MultipleChoice question = questions.get(new Random().nextInt(questions.size()));
//            testQuestions.add(question);
//        }
//
//        return testQuestions;
//    }

    public Result categories(){
        return ok(views.html.categories.render());
    }

    public Result codingQuestion(){
        return ok(codingQuestion.render());
    }

}
