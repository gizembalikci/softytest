package controllers;

import akka.http.javadsl.model.HttpResponse;
import com.fasterxml.jackson.databind.JsonNode;
import io.ebean.Ebean;
import models.*;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import javax.inject.Inject;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

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

    public static Double overallSuccessRateD(List<Statistics> statistics){
        double result = ((overallCorrect(statistics)+0.0001)/((double)overallCorrect(statistics)+(double)overallWrong(statistics)+0.0001))*100;
        return result;

    }

    public Result showResult() {
        Integer correct = 0;
        Integer wrong = 0;
        for(String key: session().keySet()){
            if(!key.contains("user") && !key.contains("category")){
                if(session().get(key).equals("correct"))
                    correct++;
                else
                    wrong++;
            }
        }

        double successRate = ((correct+0.0001)/((double)correct+(double)wrong+0.0001))*100;

        User user = User.find.byId(session().get("user"));
        for(Statistics statistics: user.testStatistics){
            if(statistics.category == Integer.parseInt(session().get("category"))){
                int c = correct + statistics.correct;
                int w = wrong + statistics.wrong;
                statistics.setCorrect(c);
                statistics.setWrong(w);
                statistics.update();
                user.update();
                break;
            }
        }
        Double overallSuccess = overallSuccessRateD(user.testStatistics);
        NumberFormat formatter = new DecimalFormat("#0.00");
        String category = session().get("category");
        if(category.equals("1"))
            category = "Backend Development Test";
        else if(category.equals("2"))
            category = "Frontend Development Test";
        else
            category = "Mixed Test";
        session().clear();
        session().put("user", user.email);
        return ok(result.render(correct, wrong, successRate, overallSuccess, formatter.format(successRate), overallSuccessRate(user.testStatistics), category));
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
        codingQuestion1.outputs = "6";
        codingQuestion1.save();

        CodingQuestion codingQuestion2 = new CodingQuestion();
        codingQuestion2.questionContent = "Given a positive integer denoting , do the following:\n" +
                "If ,1 <= n <= 9 then print the lowercase English word corresponding to the number (e.g., one for 1).\n" +
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
        codingQuestion3.questionContent = "Given an integer,N, print its first 10 multiples.\n" +
                "Each multiple N x i (where 1 <= i <= 10) should be printed on a new line in the form:\n " +
                "N x i = result.";
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
        codingQuestion4.questionContent = "Read two integers from STDIN and print three lines where:\n " +
                "1.The first line contains the sum of the two numbers.\n " +
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
        codingQuestion5.outputs = "Weird\nNot Weird";
        codingQuestion5.save();

        CodingQuestion codingQuestion6 = new CodingQuestion();
        codingQuestion6.questionContent = "A postal code P must be a number in the range of (100 000 - 999 999).\n " +
                "A postal code P must not contain more than one alternating repetitive digit pair.\n " +
                "Alternating repetitive digits are digits which repeat immediately after the next digit.\n " +
                "In other words, an alternating repetitive digit pair is formed by two equal digits that have just a single digit between them.\n" +
                "&nbsp For example:\n " +
                "&nbsp 121426 # Here, 1 is an alternating repetitive digit.\n " +
                "&nbsp 523563 # Here, NO digit is an alternating repetitive digit.\n " +
                "&nbsp 552523 # Here, both 2 and 5 are alternating repetitive digits.\n "+
                "&nbsp Your task is to validate whether P is a valid postal code or not.\n ";
        codingQuestion6.category = 1;
        codingQuestion6.difficulty = 2;
        codingQuestion6.timeToSolve = 3;
        codingQuestion6.baseCode = "# Enter your code here. Read input from STDIN. Print output to STDOUT\n" ;
        codingQuestion6.programmingLanguage = "5";
        codingQuestion6.testcases = "[\"110000\"]";
        codingQuestion6.outputs = "False";
        codingQuestion6.save();



        CodingQuestion codingQuestion7 = new CodingQuestion();
        codingQuestion7.questionContent = "The Java instanceof operator is used to test if the object or instance is an\n" +
                "instanceof the specified type.\n" +
                "&nbsp In this problem we have given you three classes in the editor:\n" +
                "&nbsp Student class\n" +
                "&nbsp Rockstar class\n" +
                "&nbsp Hacker class\n" +
                "&nbsp In the main method, we populated an ArrayList with several instances of these classes.\n" +
                "count method calculates how many instances of each type is present in the ArrayList.\n" +
                "\nThe code prints three integers, the number of instance of Student class,\n" +
                "the number of instance of Rockstar class, the number of instance of Hacker class.\n"+
                "&nbsp But some lines of the code are missing, and you have to fix it by modifying only lines!\n" +
                "Don't add, delete or modify any extra line.\n" +
                "&nbsp To restore the original code in the editor,\n" +
                "click on the top left icon in the editor and create a new buffer.\n" ;
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
                "&nbsp 1.Reads an integer from stdin and saves it to a variable, n , denoting some number of integers.\n" +
                "&nbsp 2.Reads n integers corresponding to a0,a1,..,an-1 from stdin and saves each integer to a variable,\n" +
                "&nbsp 3.Attempts to print each element of an array of integers named .\n" +
                "\n" +
                "Write the following code in the unlocked portion of your editor:\n" +
                "\n" +
                "&nbsp 1.Create an array,a, capable of holding n integers.\n" +
                "&nbsp 2.Modify the code in the loop so that it saves each sequential value to its corresponding location in the array.\n" +
                " For example, the first value must be stored in , the second value must be stored in , and so on.\n" +
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
        codingQuestion9.questionContent = "You have to write a function int max_of_four(int a, int b, int c, int d)\n" +
                " which reads four arguments and returns the greatest of them.\n" +
                "\n" +
                "+= : Add and assignment operator. It adds the right operand to the\n" +
                "left operand and assigns the result to the left operand.\n" +
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


        MultipleChoice multipleChoiceQ1 = new MultipleChoice();
        multipleChoiceQ1.questionContent = "What is Encapsulation?";
        multipleChoiceQ1.category = 1;
        multipleChoiceQ1.difficulty = 1;
        multipleChoiceQ1.timeToSolve = 2;
        multipleChoiceQ1.choice1 = "Encapsulation is a technique to define different methods of same type.";
        multipleChoiceQ1.choice2 = "Encapsulation is the ability of an object to take on many forms.";
        multipleChoiceQ1.choice3 = "Encapsulation is the technique of making the fields in a class private and providing access to the fields via public methods.";
        multipleChoiceQ1.choice4 = "None of the above.";
        multipleChoiceQ1.correctAnswer = "Encapsulation is the technique of making the fields in a class private and providing access to the fields via public methods.";
        multipleChoiceQ1.save();


        MultipleChoice multipleChoiceQ2 = new MultipleChoice();
        multipleChoiceQ2.questionContent = " What is synchronization?";
        multipleChoiceQ2.category = 1;
        multipleChoiceQ2.difficulty = 1;
        multipleChoiceQ2.timeToSolve = 2;
        multipleChoiceQ2.choice1 = "Synchronization is the capability to control the access of multiple threads to shared resources.";
        multipleChoiceQ2.choice2 = "Synchronization is the process of writing the state of an object to another object.";
        multipleChoiceQ2.choice3 = "Synchronization is the process of writing the state of an object to byte stream.";
        multipleChoiceQ2.choice4 = "None of the above.";
        multipleChoiceQ2.correctAnswer = "Synchronization is the capability to control the access of multiple threads to shared resources.";
        multipleChoiceQ2.save();



        MultipleChoice multipleChoiceQ3 = new MultipleChoice();
        multipleChoiceQ3.questionContent = "Which of the following access specifier in C# allows a class to hide\n" +
                "its member variables and member functions from other functions and objects?\n";
        multipleChoiceQ3.category = 1;
        multipleChoiceQ3.difficulty = 1;
        multipleChoiceQ3.timeToSolve = 2;
        multipleChoiceQ3.choice1 = "Public";
        multipleChoiceQ3.choice2 = "Private";
        multipleChoiceQ3.choice3 = "Protected";
        multipleChoiceQ3.choice4 = "Internal";
        multipleChoiceQ3.correctAnswer = "Private";
        multipleChoiceQ3.save();




        MultipleChoice multipleChoiceQ4 = new MultipleChoice();
        multipleChoiceQ4.questionContent = "Which of the following searching techniques do not require the data to be in sorted form";
        multipleChoiceQ4.category = 1;
        multipleChoiceQ4.difficulty = 2;
        multipleChoiceQ4.timeToSolve = 2;
        multipleChoiceQ4.choice1 = "Binary Search";
        multipleChoiceQ4.choice2 = "Interpolation Search";
        multipleChoiceQ4.choice3 = "Linear Search";
        multipleChoiceQ4.choice4 = "All of the above";
        multipleChoiceQ4.correctAnswer = "Binary Search";
        multipleChoiceQ4.save();



        MultipleChoice multipleChoiceQ5 = new MultipleChoice();
        multipleChoiceQ5.questionContent = "What data structure is used for breadth first traversal of a graph?";
        multipleChoiceQ5.category = 1;
        multipleChoiceQ5.difficulty = 2;
        multipleChoiceQ5.timeToSolve = 2;
        multipleChoiceQ5.choice1 = "queue";
        multipleChoiceQ5.choice2 = "stack";
        multipleChoiceQ5.choice3 = "list";
        multipleChoiceQ5.choice4 = "none of the above";
        multipleChoiceQ5.correctAnswer = "queue";
        multipleChoiceQ5.save();




        MultipleChoice multipleChoiceQ6 = new MultipleChoice();
        multipleChoiceQ6.questionContent = "Graph traversal is different from a tree traversal, because";
        multipleChoiceQ6.category = 1;
        multipleChoiceQ6.difficulty = 2;
        multipleChoiceQ6.timeToSolve = 2;
        multipleChoiceQ6.choice1 = "trees are not connected.";
        multipleChoiceQ6.choice2 = "graphs may have loops.";
        multipleChoiceQ6.choice3 = "trees have root.";
        multipleChoiceQ6.choice4 = "None is true as tree is a subset of graph.";
        multipleChoiceQ6.correctAnswer = "trees have root.";
        multipleChoiceQ6.save();

        MultipleChoice multipleChoiceQ7 = new MultipleChoice();
        multipleChoiceQ7.questionContent = " What is the output of the following program?\n" +
                "\n" +
                "#include<stdio.h>\n" +
                "\n" +
                "main()\n" +
                "{\n" +
                "   printf(\"\\\");\n" +
                "}";
        multipleChoiceQ7.category = 1;
        multipleChoiceQ7.difficulty = 3;
        multipleChoiceQ7.timeToSolve = 2;
        multipleChoiceQ7.choice1 = "\\";
        multipleChoiceQ7.choice2 = "\\\"";
        multipleChoiceQ7.choice3 = "\"";
        multipleChoiceQ7.choice4 = "Compile error";
        multipleChoiceQ7.correctAnswer = "Compile error";
        multipleChoiceQ7.save();



        MultipleChoice multipleChoiceQ8 = new MultipleChoice();
        multipleChoiceQ8.questionContent = "What is the output of the following program?\n" +
                "\n" +
                "#include<stdio.h>\n" +
                "\n" +
                "main()\n" +
                "{&nbsp\n" +
                "   fprintf(stdout,\"Hello, World!\");\n" +
                "}";
        multipleChoiceQ8.category = 1;
        multipleChoiceQ8.difficulty = 3;
        multipleChoiceQ8.timeToSolve = 2;
        multipleChoiceQ8.choice1 = "Hello, World!";
        multipleChoiceQ8.choice2 = "No output";
        multipleChoiceQ8.choice3 = "Compile error";
        multipleChoiceQ8.choice4 = "Runtime error";
        multipleChoiceQ8.correctAnswer = "Hello, World!";
        multipleChoiceQ8.save();


        MultipleChoice multipleChoiceQ9 = new MultipleChoice();
        multipleChoiceQ9.questionContent = "#include<stdio.h>\n" +
                "\n" +
                "int main()\n" +
                "{\n" +
                "    int y = 100;\n" +
                "    const int x = y;\n" +
                "    \n" +
                "    printf(\"%d\\n\", x);\n" +
                "    return 0;\n" +
                "}";
        multipleChoiceQ9.category = 1;
        multipleChoiceQ9.difficulty = 3;
        multipleChoiceQ9.timeToSolve = 2;
        multipleChoiceQ9.choice1 = "100";
        multipleChoiceQ9.choice2 = "0";
        multipleChoiceQ9.choice3 = "Print x";
        multipleChoiceQ9.choice4 = "Return Error";
        multipleChoiceQ9.correctAnswer = "100";
        multipleChoiceQ9.save();

        ///////////////////////Front-end Development Questions//////////////////////

        //////Difficulty 1//////////////////
        MultipleChoice multipleChoiceQ10 = new MultipleChoice();
        multipleChoiceQ10.questionContent = "What does HTML stand for?";
        multipleChoiceQ10.category = 2;
        multipleChoiceQ10.difficulty = 1;
        multipleChoiceQ10.timeToSolve = 2;
        multipleChoiceQ10.choice1 = "Home Tool Markup Language";
        multipleChoiceQ10.choice2 = "Hyperlinks and Text Markup Language";
        multipleChoiceQ10.choice3 = "Hyper Text Markup Language";
        multipleChoiceQ10.choice4 = "Home Text Markup Language";
        multipleChoiceQ10.correctAnswer = "Hyper Text Markup Language";
        multipleChoiceQ10.save();



        MultipleChoice multipleChoiceQ11 = new MultipleChoice();
        multipleChoiceQ11.questionContent = "Choose the correct HTML element for the largest heading:";
        multipleChoiceQ11.category = 2;
        multipleChoiceQ11.difficulty = 1;
        multipleChoiceQ11.timeToSolve = 2;
        multipleChoiceQ11.choice1 = "<h6>";
        multipleChoiceQ11.choice2 = "<head>";
        multipleChoiceQ11.choice3 = "<h1>";
        multipleChoiceQ11.choice4 = "<heading>";
        multipleChoiceQ11.correctAnswer = "<h1>";
        multipleChoiceQ11.save();

        MultipleChoice multipleChoiceQ12 = new MultipleChoice();
        multipleChoiceQ12.questionContent = "What is the correct HTML for adding a background color?";
        multipleChoiceQ12.category = 2;
        multipleChoiceQ12.difficulty = 1;
        multipleChoiceQ12.timeToSolve = 2;
        multipleChoiceQ12.choice1 = "<body style=\"background-color:yellow;\">";
        multipleChoiceQ12.choice2 = "<body bg=\"yellow\">";
        multipleChoiceQ12.choice3 = "<background>yellow</background>";
        multipleChoiceQ12.choice4 = "<bg>blue</bg>";
        multipleChoiceQ12.correctAnswer = "<body style=\"background-color:yellow;\">";
        multipleChoiceQ12.save();





        MultipleChoice multipleChoiceQ13 = new MultipleChoice();
        multipleChoiceQ13.questionContent = "How can you get the total number of arguments passed to a function in javascript?";
        multipleChoiceQ13.category = 2;
        multipleChoiceQ13.difficulty = 1;
        multipleChoiceQ13.timeToSolve = 2;
        multipleChoiceQ13.choice1 = "Using args.length property";
        multipleChoiceQ13.choice2 = "Using arguments.length property";
        multipleChoiceQ13.choice3 = "Both of the above.";
        multipleChoiceQ13.choice4 = "None of the above.";
        multipleChoiceQ13.correctAnswer = "Using arguments.length property";
        multipleChoiceQ13.save();




        MultipleChoice multipleChoiceQ14 = new MultipleChoice();
        multipleChoiceQ14.questionContent = "Which of the following is correct about features of JavaScript?";
        multipleChoiceQ14.category = 2;
        multipleChoiceQ14.difficulty = 1;
        multipleChoiceQ14.timeToSolve = 2;
        multipleChoiceQ14.choice1 = "JavaScript is is complementary to and integrated with HTML.";
        multipleChoiceQ14.choice2 = "JavaScript is open and cross-platform.";
        multipleChoiceQ14.choice3 = "Both of the above.";
        multipleChoiceQ14.choice4 = "All of the above.";
        multipleChoiceQ14.correctAnswer = "Both of the above.";
        multipleChoiceQ14.save();



        MultipleChoice multipleChoiceQ15 = new MultipleChoice();
        multipleChoiceQ15.questionContent = "Which of the following type of variable takes precedence over other\n" +
                "if names are same in JavaScript?";
        multipleChoiceQ15.category = 2;
        multipleChoiceQ15.difficulty = 1;
        multipleChoiceQ15.timeToSolve = 2;
        multipleChoiceQ15.choice1 = "global variable";
        multipleChoiceQ15.choice2 = "local variable";
        multipleChoiceQ15.choice3 = "Both of the above.";
        multipleChoiceQ15.choice4 = "None of the above.";
        multipleChoiceQ15.correctAnswer = "local variable";
        multipleChoiceQ15.save();




        MultipleChoice multipleChoiceQ16 = new MultipleChoice();
        multipleChoiceQ16.questionContent = "Which of the following is correct about CSS?";
        multipleChoiceQ16.category = 2;
        multipleChoiceQ16.difficulty = 1;
        multipleChoiceQ16.timeToSolve = 2;
        multipleChoiceQ16.choice1 = "Style sheets allow content to be optimized for more than one type of device.";
        multipleChoiceQ16.choice2 = "CSS can store web applications locally with the help of an offline cache.";
        multipleChoiceQ16.choice3 = "Using CSS, we can view offline websites.\n" +
                "The cache also ensures faster loading and better overall performance of the website.";
        multipleChoiceQ16.choice4 = "All of the above.";
        multipleChoiceQ16.correctAnswer = "All of the above.";
        multipleChoiceQ16.save();





        MultipleChoice multipleChoiceQ17 = new MultipleChoice();
        multipleChoiceQ17.questionContent = "Which of the following defines a measurement in centimeters in CSS?";
        multipleChoiceQ17.category = 2;
        multipleChoiceQ17.difficulty = 1;
        multipleChoiceQ17.timeToSolve = 2;
        multipleChoiceQ17.choice1 = "%";
        multipleChoiceQ17.choice2 = "cm";
        multipleChoiceQ17.choice3 = "em";
        multipleChoiceQ17.choice4 = "ex";
        multipleChoiceQ17.correctAnswer = "cm";
        multipleChoiceQ17.save();


        MultipleChoice multipleChoiceQ18 = new MultipleChoice();
        multipleChoiceQ18.questionContent = "Which of the following property is used to control the scrolling of \n" +
                "an image in the background in CSS?";
        multipleChoiceQ18.category = 2;
        multipleChoiceQ18.difficulty = 1;
        multipleChoiceQ18.timeToSolve = 2;
        multipleChoiceQ18.choice1 = "background-attachment";
        multipleChoiceQ18.choice2 = "background";
        multipleChoiceQ18.choice3 = "background-repeat";
        multipleChoiceQ18.choice4 = "background-position";
        multipleChoiceQ18.correctAnswer = "background-attachment";
        multipleChoiceQ18.save();


        //////Difficulty 2//////////////////

        MultipleChoice multipleChoiceQ19 = new MultipleChoice();
        multipleChoiceQ19.questionContent = " Which of the following CSS property is used to align the text of a document in?";
        multipleChoiceQ19.category = 2;
        multipleChoiceQ19.difficulty = 2;
        multipleChoiceQ19.timeToSolve = 2;
        multipleChoiceQ19.choice1 = "text-indent";
        multipleChoiceQ19.choice2 = "text-align";
        multipleChoiceQ19.choice3 = "text-decoration";
        multipleChoiceQ19.choice4 = "text-transform";
        multipleChoiceQ19.correctAnswer = "text-align";
        multipleChoiceQ19.save();



        MultipleChoice multipleChoiceQ20 = new MultipleChoice();
        multipleChoiceQ20.questionContent = " Which of the following CSS property is used to set the width of an image border?";
        multipleChoiceQ20.category = 2;
        multipleChoiceQ20.difficulty = 2;
        multipleChoiceQ20.timeToSolve = 2;
        multipleChoiceQ20.choice1 = "border";
        multipleChoiceQ20.choice2 = "height";
        multipleChoiceQ20.choice3 = "width";
        multipleChoiceQ20.choice4 = "moz-opacity";
        multipleChoiceQ20.correctAnswer = "border";
        multipleChoiceQ20.save();



        MultipleChoice multipleChoiceQ21 = new MultipleChoice();
        multipleChoiceQ21.questionContent = "Which of the following CSS property changes the width of bottom border?";
        multipleChoiceQ21.category = 2;
        multipleChoiceQ21.difficulty = 2;
        multipleChoiceQ21.timeToSolve = 2;
        multipleChoiceQ21.choice1 = ":border-bottom-width";
        multipleChoiceQ21.choice2 = ":border-top-width";
        multipleChoiceQ21.choice3 = ":border-left-width";
        multipleChoiceQ21.choice4 = ":border-right-width";
        multipleChoiceQ21.correctAnswer = ":border-bottom-width";
        multipleChoiceQ21.save();



        MultipleChoice multipleChoiceQ22 = new MultipleChoice();
        multipleChoiceQ22.questionContent = "Which of the following Javascript function of Boolean object returns \n" +
                "a string containing the source of the Boolean object?";
        multipleChoiceQ22.category = 2;
        multipleChoiceQ22.difficulty = 2;
        multipleChoiceQ22.timeToSolve = 2;
        multipleChoiceQ22.choice1 = "toSource()";
        multipleChoiceQ22.choice2 = "valueOf()";
        multipleChoiceQ22.choice3 = "toString()";
        multipleChoiceQ22.choice4 = "None of the above.";
        multipleChoiceQ22.correctAnswer = "toSource()";
        multipleChoiceQ22.save();


        MultipleChoice multipleChoiceQ23 = new MultipleChoice();
        multipleChoiceQ23.questionContent =  " Which of the following Javascript function of String object returns the\n" +
                "index within the calling String object of the first occurrence of the specified value?";
        multipleChoiceQ23.category = 2;
        multipleChoiceQ23.difficulty = 2;
        multipleChoiceQ23.timeToSolve = 2;
        multipleChoiceQ23.choice1 = "indexOf()";
        multipleChoiceQ23.choice2 = "substr()";
        multipleChoiceQ23.choice3 = "search()";
        multipleChoiceQ23.choice4 = "lastIndexOf()";
        multipleChoiceQ23.correctAnswer = "indexOf()";
        multipleChoiceQ23.save();



        MultipleChoice multipleChoiceQ24 = new MultipleChoice();
        multipleChoiceQ24.questionContent = "Which of the following function of String object returns a string \n" +
                "representing the specified object?";
        multipleChoiceQ24.category = 2;
        multipleChoiceQ24.difficulty = 2;
        multipleChoiceQ24.timeToSolve = 2;
        multipleChoiceQ24.choice1 = "toLocaleUpperCase()";
        multipleChoiceQ24.choice2 = "toUpperCase()";
        multipleChoiceQ24.choice3 = "toString()";
        multipleChoiceQ24.choice4 = "substring()";
        multipleChoiceQ24.correctAnswer = "toString()";
        multipleChoiceQ24.save();


        MultipleChoice multipleChoiceQ25 = new MultipleChoice();
        multipleChoiceQ25.questionContent = "Choose the correct HTML element to define important text";
        multipleChoiceQ25.category = 2;
        multipleChoiceQ25.difficulty = 2;
        multipleChoiceQ25.timeToSolve = 2;
        multipleChoiceQ25.choice1 = "<important>";
        multipleChoiceQ25.choice2 = "<b>";
        multipleChoiceQ25.choice3 = "<i>";
        multipleChoiceQ25.choice4 = "<strong>";
        multipleChoiceQ25.correctAnswer = "<strong>";
        multipleChoiceQ25.save();



        MultipleChoice multipleChoiceQ26 = new MultipleChoice();
        multipleChoiceQ26.questionContent = "How can you open a link in a new tab/browser window?";
        multipleChoiceQ26.category = 2;
        multipleChoiceQ26.difficulty = 2;
        multipleChoiceQ26.timeToSolve = 2;
        multipleChoiceQ26.choice1 = "<a href=\"url\" target=\"_blank\">";
        multipleChoiceQ26.choice2 = "<a href=\"url\" new>";
        multipleChoiceQ26.choice3 = "<a href=\"url\" target=\"new\">";
        multipleChoiceQ26.choice4 = "<a href=\"url\" target=\"_new\">";
        multipleChoiceQ26.correctAnswer = "<a href=\"url\" target=\"_blank\">";
        multipleChoiceQ26.save();



        MultipleChoice multipleChoiceQ27 = new MultipleChoice();
        multipleChoiceQ27.questionContent = "Which of these HTML elements are all <table> elements?";
        multipleChoiceQ27.category = 2;
        multipleChoiceQ27.difficulty = 2;
        multipleChoiceQ27.timeToSolve = 2;
        multipleChoiceQ27.choice1 = "<table><tr><td>";
        multipleChoiceQ27.choice2 = "<table><tr><tt>";
        multipleChoiceQ27.choice3 = "<table><head><tfoot>";
        multipleChoiceQ27.choice4 = "<thead><body><tr>";
        multipleChoiceQ27.correctAnswer = "<table><tr><td>";
        multipleChoiceQ27.save();



        /////////////////Difficulty 3//////////////////////

        MultipleChoice multipleChoiceQ28 = new MultipleChoice();
        multipleChoiceQ28.questionContent = "Which of the following Javascript function of String \n" +
                "object causes a string to be italic, as if it were in an <i> tag?";
        multipleChoiceQ28.category = 2;
        multipleChoiceQ28.difficulty = 3;
        multipleChoiceQ28.timeToSolve = 2;
        multipleChoiceQ28.choice1 = "fixed()";
        multipleChoiceQ28.choice2 = "fontcolor()";
        multipleChoiceQ28.choice3 = "fontsize()";
        multipleChoiceQ28.choice4 = "italics()";
        multipleChoiceQ28.correctAnswer = "italics() ";
        multipleChoiceQ28.save();


        MultipleChoice multipleChoiceQ29 = new MultipleChoice();
        multipleChoiceQ29.questionContent = "Which of the following Javascript function of Array \n" +
                "object applies a function simultaneously against two values of \n" +
                "the array (from left-to-right) as to reduce it to a single value?\n";
        multipleChoiceQ29.category = 2;
        multipleChoiceQ29.difficulty = 3;
        multipleChoiceQ29.timeToSolve = 2;
        multipleChoiceQ29.choice1 = "pop()";
        multipleChoiceQ29.choice2 = "push()";
        multipleChoiceQ29.choice3 = "reduce()";
        multipleChoiceQ29.choice4 = "reduceRight()";
        multipleChoiceQ29.correctAnswer = "reduceRight()";
        multipleChoiceQ29.save();


        MultipleChoice multipleChoiceQ30 = new MultipleChoice();
        multipleChoiceQ30.questionContent = "Which of the following Javascript function of Array\n" +
                "object applies a function simultaneously against two values of\n" +
                "the array (from right-to-left) as to reduce it to a single value?\n";
        multipleChoiceQ30.category = 2;
        multipleChoiceQ30.difficulty = 3;
        multipleChoiceQ30.timeToSolve = 2;
        multipleChoiceQ30.choice1 = "pop()";
        multipleChoiceQ30.choice2 = "push()";
        multipleChoiceQ30.choice3 = "reduce()";
        multipleChoiceQ30.choice4 = "reduceRight()";
        multipleChoiceQ30.correctAnswer = "reduceRight()";
        multipleChoiceQ30.save();


        MultipleChoice multipleChoiceQ31 = new MultipleChoice();
        multipleChoiceQ31.questionContent = "Which of the following CSS property specifies whether a border \n" +
                "should be solid, dashed line, double line, or one of \n" +
                "the other possible values?\n";
        multipleChoiceQ31.category = 2;
        multipleChoiceQ31.difficulty = 3;
        multipleChoiceQ31.timeToSolve = 2;
        multipleChoiceQ31.choice1 = ":border-color";
        multipleChoiceQ31.choice2 = ":border-style";
        multipleChoiceQ31.choice3 = ":border-width";
        multipleChoiceQ31.choice4 = ":border-bottom-color";
        multipleChoiceQ31.correctAnswer = ":border-style";
        multipleChoiceQ31.save();


        MultipleChoice multipleChoiceQ32 = new MultipleChoice();
        multipleChoiceQ32.questionContent = "Which of the following value of cursor shows it as an arrow in CSS?";
        multipleChoiceQ32.category = 2;
        multipleChoiceQ32.difficulty = 3;
        multipleChoiceQ32.timeToSolve = 2;
        multipleChoiceQ32.choice1 = "crosshair";
        multipleChoiceQ32.choice2 = "default";
        multipleChoiceQ32.choice3 = "pointer";
        multipleChoiceQ32.choice4 = "move";
        multipleChoiceQ32.correctAnswer = "default";
        multipleChoiceQ32.save();



        MultipleChoice multipleChoiceQ33 = new MultipleChoice();
        multipleChoiceQ33.questionContent = "Which of the following property changes the width of right border?";
        multipleChoiceQ33.category = 2;
        multipleChoiceQ33.difficulty = 3;
        multipleChoiceQ33.timeToSolve = 2;
        multipleChoiceQ33.choice1 = ":border-bottom-width";
        multipleChoiceQ33.choice2 = ":border-top-width";
        multipleChoiceQ33.choice3 = ":border-left-width";
        multipleChoiceQ33.choice4 = ":border-right-width";
        multipleChoiceQ33.correctAnswer = ":border-right-width";
        multipleChoiceQ33.save();

        MultipleChoice multipleChoiceQ34 = new MultipleChoice();
        multipleChoiceQ34.questionContent = "Which HTML attribute specifies an alternate text for an image,\n" +
                "if the image cannot be displayed?";
        multipleChoiceQ34.category = 2;
        multipleChoiceQ34.difficulty = 3;
        multipleChoiceQ34.timeToSolve = 2;
        multipleChoiceQ34.choice1 = "alt";
        multipleChoiceQ34.choice2 = "longdesc";
        multipleChoiceQ34.choice3 = "src";
        multipleChoiceQ34.choice4 = "title";
        multipleChoiceQ34.correctAnswer = "alt";
        multipleChoiceQ34.save();



        MultipleChoice multipleChoiceQ35 = new MultipleChoice();
        multipleChoiceQ35.questionContent = "In HTML, onblur and onfocus are:";
        multipleChoiceQ35.category = 2;
        multipleChoiceQ35.difficulty = 3;
        multipleChoiceQ35.timeToSolve = 2;
        multipleChoiceQ35.choice1 = "Event attributes";
        multipleChoiceQ35.choice2 = "HTML elements";
        multipleChoiceQ35.choice3 = "Style attributes";
        multipleChoiceQ35.choice4 = "Inlier element";
        multipleChoiceQ35.correctAnswer = "Event attributes";
        multipleChoiceQ35.save();



        MultipleChoice multipleChoiceQ36 = new MultipleChoice();
        multipleChoiceQ36.questionContent = "The HTML <canvas> element is used to:";
        multipleChoiceQ36.category = 2;
        multipleChoiceQ36.difficulty = 3;
        multipleChoiceQ36.timeToSolve = 2;
        multipleChoiceQ36.choice1 = "draw graphics";
        multipleChoiceQ36.choice2 = "display database records";
        multipleChoiceQ36.choice3 = "manipulate data in MySQL";
        multipleChoiceQ36.choice4 = "create draggable elements";
        multipleChoiceQ36.correctAnswer = "draw graphics";
        multipleChoiceQ36.save();


        return ok();
    }



    public Result checkAnswerMultiple(Long id){
        MultipleChoice multipleChoice = MultipleChoice.find.byId(id);
        DynamicForm requestData = formFactory.form().bindFromRequest();
        String choice = requestData.get("choice");
        Logger.debug("Choice: " + choice);
        if(multipleChoice.correctAnswer.equals(choice)){
            session().put(id.toString(), "correct");
        }
        else
            session().put(id.toString(), "wrong");

        return ok();
    }

    public Result checkAnswerCoding(Long id){
        DynamicForm requestData = formFactory.form().bindFromRequest();
        String output = requestData.get("output"+id.toString());
        CodingQuestion codingQuestion = CodingQuestion.find.byId(id);
        Logger.debug(output);
        Logger.debug(codingQuestion.outputs);
        if(output.equals(codingQuestion.outputs)) {
            session().put(id.toString(), "correct");
        }
        else {
            session().put(id.toString(), "wrong");
        }
        return ok();
    }


    public Result categories(){

        return ok(views.html.categories.render());
    }

    public Result startTest(int category){
        String email = session().get("user");
        session().clear();
        session().put("user", email);
        session().put("correct", "0");
        session().put("wrong", "0");
        session().put("category", String.valueOf(category));
        List<Question> questions = newTest(category);
        int timeToSolve = 1;
        return ok(test.render(questions, 1));
    }

//    public Result renderTestPage(Long current, Long next){
//        Question question = Question.find.byId(current);
//        Question next = Question.find.byId(next);
//        if(question.getClass().isInstance(CodingQuestion.class)){
//            return ok(codingQuestionView.render((CodingQuestion) question));
//        }
//        else
//            return badRequest();
//    }

    public List<Question> newTest(int category){
        DynamicForm requestData = formFactory.form().bindFromRequest();
        String star = requestData.get("rating");
        int difficulty = Integer.parseInt(star.substring(2));
        Logger.debug("Star: " + star.substring(2));
        List<MultipleChoice> multipleChoices = MultipleChoice.find.all();//3 tane multip random
        Logger.debug("Multiple: " + multipleChoices.size());
        List<CodingQuestion> codingQuestions = CodingQuestion.find.all();// 2 tane coding
        Logger.debug("Coding: " + codingQuestions.size());

        List<Question> test = new ArrayList<>();
        int n = 3;
        while(n > 0) {
            MultipleChoice multipleChoice = multipleChoices.get(new Random().nextInt(multipleChoices.size()));
            if(multipleChoice.difficulty == difficulty && multipleChoice.category == category && !test.contains(multipleChoice)){
                n--;
                test.add(multipleChoice);
                session().put(multipleChoice.id.toString(), "wrong");
            }
        }

        n = 2;
        while(n > 0) {
            CodingQuestion codingQuestion = codingQuestions.get(new Random().nextInt(codingQuestions.size()));
            if(codingQuestion.difficulty == difficulty && codingQuestion.category == category && !test.contains(codingQuestion)){
                n--;
                test.add(codingQuestion);
                session().put(codingQuestion.id.toString(), "wrong");
            }
        }


        return test;
    }


    public Result codeMirror(){
        return ok(codeEditor.render());
    }
}
