package controllers;

import akka.http.javadsl.model.HttpResponse;
import com.fasterxml.jackson.databind.JsonNode;
import io.ebean.Ebean;
import models.*;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.addCodingQuestion;
import views.html.codingQuestion;
import views.html.result;

import javax.inject.Inject;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestController extends Controller{

    @Inject
    FormFactory formFactory;

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

    public Result showResult(String category) {

        String numOfCorrect = session().get("correct");
        String numOfWrong = session().get("wrong");
        String successRate = calculateCurrentSuccessRate();
        String id = session().get("user");
        User user = User.find.byId(id);
        if(user!=null) {
            for(Statistics statistic: user.testStatistics){
                if(statistic.category == Integer.parseInt(category)){
                    int correct = statistic.getCorrect();
                    int wrong = statistic.getWrong();
                    correct += Integer.parseInt(numOfCorrect);
                    wrong += Integer.parseInt(numOfWrong);
                    statistic.setCorrect(correct);
                    statistic.setWrong(wrong);
                    statistic.update();
                    user.update();
                }
            }
            String totalSuccessRate = overallSuccessRate(user.testStatistics);
            return ok(result.render(numOfCorrect, numOfWrong, successRate, totalSuccessRate));
        }
        else{
            return badRequest();
        }

    }

    public String calculateCurrentSuccessRate(){

        String correctAnswersString = session().get("correct");
        String wrongAnswersString = session().get("wrong");

        int correctAnswer= Integer.parseInt(correctAnswersString);
        int wrongAnswer= Integer.parseInt(wrongAnswersString);

        double successRate = (correctAnswer + 0.001)/(correctAnswer + wrongAnswer + 0.001);

        NumberFormat formatter = new DecimalFormat("#0.00");
        return formatter.format(successRate);

        }


    public Result codingQuestionInsert(){
        CodingQuestion codingQuestion1 = new CodingQuestion();
        codingQuestion1.questionContent = "Read 3 numbers from stdin and print their sum to stdout.";
        codingQuestion1.category = 1;
        codingQuestion1.difficulty = 1;
        codingQuestion1.timeToSolve = 2;
        codingQuestion1.baseCode = "#include <cmath>\n" +
                "#include <cstdio>\n" +
                "#include <vector>\n" +
                "#include <iostream>\n" +
                "#include <algorithm>\n" +
                "using namespace std;\n" +
                "\n" +
                "int main() {\n" +
                "    /* Enter your code here. Read input from STDIN. Print output to STDOUT */\n" +
                "    return 0;\n}";
        codingQuestion1.programmingLanguage = "2";
        codingQuestion1.testcases = "[\"1 2 3\"]";
        codingQuestion1.outputs = "10";
        codingQuestion1.save();

        CodingQuestion codingQuestion2 = new CodingQuestion();
        codingQuestion2.questionContent = "Given a positive integer denoting , do the following:\n" +
                "If ,1 <= n <= 9 then print the lowercase English word corresponding to the number (e.g., one for , two for , etc.).\n" +
                "If ,9<n print Greater than 9.\n";
        codingQuestion2.category = 1;
        codingQuestion2.difficulty = 1;
        codingQuestion2.timeToSolve = 2;
        codingQuestion2.baseCode = "#include <map>\n" +
                "#include <set>\n" +
                "#include <list>\n" +
                "#include <cmath>\n" +
                "#include <ctime>\n" +
                "#include <deque>\n" +
                "#include <queue>\n" +
                "#include <stack>\n" +
                "#include <string>\n" +
                "#include <bitset>\n" +
                "#include <cstdio>\n" +
                "#include <limits>\n" +
                "#include <vector>\n" +
                "#include <climits>\n" +
                "#include <cstring>\n" +
                "#include <cstdlib>\n" +
                "#include <fstream>\n" +
                "#include <numeric>\n" +
                "#include <sstream>\n" +
                "#include <iostream>\n" +
                "#include <algorithm>\n" +
                "#include <unordered_map>\n" +
                "\n" +
                "using namespace std;\n" +
                "\n" +
                "int main(){\n" +
                "    int n;\n" +
                "    cin >> n;\n" +
                "    // your code goes here\n" +
                "    return 0;\n" +
                "}";
        codingQuestion2.programmingLanguage = "2";
        codingQuestion2.testcases = "[\"5\", \"8\", \"44\"]";
        codingQuestion2.outputs = "five, eight, Greater than 9";
        codingQuestion2.save();

        CodingQuestion codingQuestion3 = new CodingQuestion();
        codingQuestion3.questionContent = "Given an integer,N, print its first 10 multiples. Each multiple N x i (where 1 <= i <= 10) should be printed on a new line in the form: N x i = result.";
        codingQuestion3.category = 1;
        codingQuestion3.difficulty = 2; //SQL'de medium demişsin ama dif 1 yazılmış
        codingQuestion3.timeToSolve = 3;
        codingQuestion3.baseCode = "import java.io.*;\n" +
                "import java.util.*;\n" +
                "import java.text.*;\n" +
                "import java.math.*;\n" +
                "import java.util.regex.*;\n" +
                "\n" +
                "public class Solution {\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "        Scanner in = new Scanner(System.in);\n" +
                "        int N = in.nextInt();\n" +
                "    }\n" +
                "}\n";
        codingQuestion3.programmingLanguage = "3";
        codingQuestion3.testcases = "[\"5\"]";
        codingQuestion3.outputs = "2 x 1 = 2\n2 x 2 = 4\n2 x 3 = 6\n2 x 4 = 8\n2 x 5 = 10\n2 x 6 = 12\n2 x 7 = 14\n2 x 8 = 16\n2 x 9 = 18\n2 x 10 = 20\n";
        codingQuestion3.save();

        CodingQuestion codingQuestion4 = new CodingQuestion();
        codingQuestion4.questionContent = "Read two integers from STDIN and print three lines where:\n" +
                "1.The first line contains the sum of the two numbers.\n" +
                "2.The second line contains the difference of the two numbers (first - second).\n" +
                "3.The third line contains the product of the two numbers.";
        codingQuestion4.category = 1;
        codingQuestion4.difficulty = 2;
        codingQuestion4.timeToSolve = 3;
        codingQuestion4.baseCode = "if __name__ == '__main__':\n" +
                "\ta = int(raw_input())\n" +
                "\tb = int(raw_input())";
        codingQuestion4.programmingLanguage = "5";
        codingQuestion4.testcases = "[\"3 2\"]";
        codingQuestion4.outputs = "5\n1\n6\n";
        codingQuestion4.save();

        CodingQuestion codingQuestion5 = new CodingQuestion();
        codingQuestion5.questionContent = "Given an integer, n, perform the following conditional actions:\n" +
                "\tIf n is odd, print Weird\n" +
                "\tIf n is even and in the inclusive range of 2 to 5, print Not Weird\n" +
                "\tIf n is even and in the inclusive range of 6 to 20, print Weird\n" +
                "\tIf n is even and greater than 20, print Not Weird";
        codingQuestion5.category = 1;
        codingQuestion5.difficulty = 3;
        codingQuestion5.timeToSolve = 5;
        codingQuestion5.baseCode = "if __name__ == '__main__':\n" +
                "\tn = int(raw_input())\n";
        codingQuestion5.programmingLanguage = "5";
        codingQuestion5.testcases = "[\"3\", \"24\"]";
        codingQuestion5.outputs = "Weird, Not Weird";
        codingQuestion5.save();

        return ok();
    }



    //For multiple choice  question
    public void checkAnswer(){

        String correctAnswersString = session().get("correct");
        String wrongAnswersString = session().get("wrong");

        int correctAnswer= Integer.parseInt(correctAnswersString);
        int wrongAnswer= Integer.parseInt(wrongAnswersString);

         //TODO check konulacak doğru yanlış için if(doğruysa)
        correctAnswer+=1;
        //TODO else
        wrongAnswer+=1;

        correctAnswersString = Integer.toString(correctAnswer);
        wrongAnswersString = Integer.toString(wrongAnswer);

        session().put("correct",correctAnswersString);
        session().put("wrong",wrongAnswersString);

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

    public Result codingQuestion(Long questionID){
        CodingQuestion question = CodingQuestion.find.byId(questionID);
        return ok(views.html.codingQuestion.render(question));
    }



}
