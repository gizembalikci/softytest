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
        codingQuestion3.difficulty = 1;
        codingQuestion3.timeToSolve = 2;
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
        codingQuestion5.difficulty = 2;
        codingQuestion5.timeToSolve = 3;
        codingQuestion5.baseCode = "if __name__ == '__main__':\n" +
                "\tn = int(raw_input())\n";
        codingQuestion5.programmingLanguage = "5";
        codingQuestion5.testcases = "[\"3\", \"24\"]";
        codingQuestion5.outputs = "Weird, Not Weird";
        codingQuestion5.save();

        CodingQuestion codingQuestion6 = new CodingQuestion();
        codingQuestion6.questionContent = "A postal code P must be a number in the range of (100 000 - 999 999).\n" +
                "A postal code P must not contain more than one alternating repetitive digit pair.\n" +
                "Alternating repetitive digits are digits which repeat immediately after the next digit.\n" +
                "In other words, an alternating repetitive digit pair is formed by two equal digits that have just a single digit between them.\n" +
                "\tFor example:\n" +
                "\t121426 # Here, 1 is an alternating repetitive digit.\n" +
                "\t523563 # Here, NO digit is an alternating repetitive digit.\n" +
                "\t552523 # Here, both 2 and 5 are alternating repetitive digits."+
                "\tYour task is to validate whether P is a valid postal code or not.";
        codingQuestion6.category = 1;
        codingQuestion6.difficulty = 2;
        codingQuestion6.timeToSolve = 3;
        codingQuestion6.baseCode = "# Enter your code here. Read input from STDIN. Print output to STDOUT\n" ;
        codingQuestion6.programmingLanguage = "5";
        codingQuestion6.testcases = "[\"110000\"]";
        codingQuestion6.outputs = "False";
        codingQuestion6.save();



        CodingQuestion codingQuestion7 = new CodingQuestion();
        codingQuestion7.questionContent = "The Java instanceof operator is used to test if the object or instance is an instanceof the specified type.\n" +
                "\tIn this problem we have given you three classes in the editor:\n" +
                "\tStudent class\n" +
                "\tRockstar class\n" +
                "\tHacker class\n" +
                "\tIn the main method, we populated an ArrayList with several instances of these classes. count method calculates how many instances of each type is present in the ArrayList. The code prints three integers, the number of instance of Student class, the number of instance of Rockstar class, the number of instance of Hacker class.\n"+
                "\tBut some lines of the code are missing, and you have to fix it by modifying only lines! Don't add, delete or modify any extra line.\n" +
                "\tTo restore the original code in the editor, click on the top left icon in the editor and create a new buffer.\n" ;
        codingQuestion7.category = 1;
        codingQuestion7.difficulty = 3;
        codingQuestion7.timeToSolve = 4;
        codingQuestion7.baseCode = "import java.util.*;\n" +
                "\n" +
                "\n" +
                "class Student{}\n" +
                "class Rockstar{   }\n" +
                "class Hacker{}\n" +
                "\n" +
                "\n" +
                "public class InstanceOFTutorial{\n" +
                "   \n" +
                "   static String count(ArrayList mylist){\n" +
                "      int a = 0,b = 0,c = 0;\n" +
                "      for(int i = 0; i < mylist.size(); i++){\n" +
                "         Object element=mylist.get(i);\n" +
                "         if(~~Complete this line~~)\n" +
                "            a++;\n" +
                "         if(~~Complete this line~~)\n" +
                "            b++;\n" +
                "         if(~~Complete this line~~)\n" +
                "            c++;\n" +
                "      }\n" +
                "      String ret = Integer.toString(a)+\" \"+ Integer.toString(b)+\" \"+ Integer.toString(c);\n" +
                "      return ret;\n" +
                "   }\n" +
                "\n" +
                "   public static void main(String []args){\n" +
                "      ArrayList mylist = new ArrayList();\n" +
                "      Scanner sc = new Scanner(System.in);\n" +
                "      int t = sc.nextInt();\n" +
                "      for(int i=0; i<t; i++){\n" +
                "         String s=sc.next();\n" +
                "         if(s.equals(\"Student\"))mylist.add(new Student());\n" +
                "         if(s.equals(\"Rockstar\"))mylist.add(new Rockstar());\n" +
                "         if(s.equals(\"Hacker\"))mylist.add(new Hacker());\n" +
                "      }\n" +
                "      System.out.println(count(mylist));\n" +
                "   }\n" +
                "}\n" ;

        codingQuestion7.programmingLanguage = "3";
        codingQuestion7.testcases = "[\"5\",\"Student\",\"Student\",\"Rockstar\",\"Student\",\"Hacker\"]";
        codingQuestion7.outputs = "3 1 1";
        codingQuestion7.save();





        CodingQuestion codingQuestion8 = new CodingQuestion();
        codingQuestion8.questionContent = "The code in your editor does the following:\n" +
                "\n" +
                "    1.Reads an integer from stdin and saves it to a variable, n , denoting some number of integers.\n" +
                "    2.Reads n integers corresponding to a0,a1,..,an-1 from stdin and saves each integer to a variable, .\n" +
                "    3.Attempts to print each element of an array of integers named .\n" +
                "\n" +
                "Write the following code in the unlocked portion of your editor:\n" +
                "\n" +
                "    1.Create an array,a, capable of holding n integers.\n" +
                "    2.Modify the code in the loop so that it saves each sequential value to its corresponding location in the array. For example, the first value must be stored in , the second value must be stored in , and so on.\n" +
                "\n" +
                "Good luck!\n" +
                "\n";
        codingQuestion8.category = 1;
        codingQuestion8.difficulty = 3;
        codingQuestion8.timeToSolve = 4;
        codingQuestion8.baseCode = "import java.util.*;\n" +
                "\n" +
                "public class Solution {\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "\t   \n" +
                "        Scanner scan = new Scanner(System.in);\n" +
                "        int n = scan.nextInt();\n" +
                "      "+
                "// Declare array a here\n" +
                "\n" +
                "        for(int i = 0 ; i < n; i++){\n" +
                "            int val = scan.nextInt();\n" +
                "            // Fill array a here\n" +
                "        }"+
                "scan.close();\n" +
                "\n" +
                "        // Prints each sequential element in array a\n" +
                "        for (int i = 0; i < a.length; i++) {\n" +
                "            System.out.println(a[i]);\n" +
                "        }\n" +
                "    }\n" +
                "}";
        codingQuestion8.programmingLanguage = "3";
        codingQuestion8.testcases = "[\"5\", \"10\",\"20\",\"30\",\"40\",\"50\"]";
        codingQuestion8.outputs = "10\n" +
                "20\n" +
                "30\n" +
                "40\n" +
                "50";
        codingQuestion8.save();

        CodingQuestion codingQuestion9 = new CodingQuestion();
        codingQuestion9.questionContent = "You have to write a function int max_of_four(int a, int b, int c, int d) which reads four arguments and returns the greatest of them.\n" +
                "\n" +
                "+= : Add and assignment operator. It adds the right operand to the left operand and assigns the result to the left operand.\n" +
                "a += b is equivalent to a = a + b;\n" +
                "\n" +
                "Input Format\n" +
                "\n" +
                "Input will contain four integers -a,b,c,d, one in each line.\n" +
                "\n" +
                "Output Format\n" +
                "\n" +
                "Print the greatest of the four integers.\n" +
                "PS: I/O will be automatically handled.";
        codingQuestion6.category = 1;
        codingQuestion6.difficulty = 2;
        codingQuestion6.timeToSolve = 3;
        codingQuestion6.baseCode = "#include <iostream>\n" +
                "#include <cstdio>\n" +
                "using namespace std;\n" +
                "\n" +
                "/*\n" +
                "Add `int max_of_four(int a, int b, int c, int d)` here.\n" +
                "*/\n" +
                "\n" +
                "int main() {\n" +
                "    int a, b, c, d;\n" +
                "    scanf(\"%d %d %d %d\", &a, &b, &c, &d);\n" +
                "    int ans = max_of_four(a, b, c, d);\n" +
                "    printf(\"%d\", ans);\n" +
                "    \n" +
                "    return 0;\n" +
                "}\n" +
                "\n" ;
        codingQuestion6.programmingLanguage = "5";
        codingQuestion6.testcases = "[\"3 4 6 5\"]";
        codingQuestion6.outputs = "6";
        codingQuestion6.save();







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
