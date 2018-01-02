package controllers;

import models.Statistics;
import models.User;
import play.mvc.Controller;

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

    public static int successRate(Statistics statistics){
        return (int)((statistics.correct+0.0001)/((double)statistics.correct+(double)statistics.wrong+0.0001))*100;
    }
}
