package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.codehaus.groovy.transform.sc.ListOfExpressionsExpression;

import java.util.*;

public class JavaStepDefs {

    @And("I say {string}")
    public void iSay(String text) {
        
        System.out.println(text);
    }

    @And("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String str1, String str2) {
        System.out.println("variable1:" + str1);
        System.out.println("variable2" + str2);

        System.out.println(str1.toUpperCase());
        System.out.println(str2.toUpperCase());

        System.out.println(str1.length());
        System.out.println(str2.length());

        System.out.println("variables are equal: " + str1.equals(str2));
        System.out.println("they equal ignoring the case: " + str1.equalsIgnoreCase(str2));
        System.out.println("variable1 contains variable 2: " + str1.contains(str2));
        System.out.println("variable2 contains variable 1: " + str2.contains(str1));
    }

    @And("I perform math operations with {float} and {float}")
    public void iPerformMathOperationsWithAnd(float num1, float num2) {
        float sum = num1 + num2;
        System.out.println("sum = " + sum);

        float difference = num1 - num2;
        System.out.println("num1 - num2 = " + difference);

        float quotient = num1/num2;
        System.out.println("quotient = " + quotient);

        float product = num1*num2;
        System.out.println("product = " + product);
    }

    @And("I ask is {string} color your favorite")
    public void iAskIsColorYoureFavorite(String color) {
        if (color.equals("purple")) {
            boolean favorite  = true;
            System.out.println("favorite color? " + favorite);
        } else {
            boolean favorite  = false;
            System.out.println("favorite color? " + favorite);
        }
    }

    @And("I print url for {string} page")
    public void iPrintUrlForPage(String url) {
//        if (url.equals("youtube")) {
//            System.out.println("https://www.youtube.com/");
//        } else if (url.equals("vimeo")) {
//            System.out.println("https://vimeo.com/");
//        } else {
//            System.out.println("URL not supported: " + url);
//        }

            switch(url) {
                case "youtube":
                    System.out.println("https://www.youtube.com/");
                    break;
                case "vimeo":
                    System.out.println("https://vimeo.com/");
                    break;
                default:
                    System.out.println("URL not supported: " + url);
                    break;
            }
    }

    @And("I ask what's on grocery list")
    public void iAskWhatSOnGroceryList() {
//        String[] groceryList = {"milk", "bread", "bananas", "chicken"};
//        for (String element : groceryList) {
//            System.out.println(element);
//        }

        List<String> list = List.of("paper towels", "shampoo", "tooth paste", "detergent");
        for (String item : list) {
            System.out.println(item);
        }
    }

    @And("I ask whats number {int} on the grocery list")
    public void iAskWhatsNumberOnTheGroceryList(int num1) {
        String[] groceryList = {"milk", "bread", "bananas", "chicken"};
        int numberOnTheList = num1 - 1;
        System.out.println(groceryList[numberOnTheList]);
    }

    @And("I ask if {double} is positive")
    public void iAskIfIsPossitive(double num) {
        if (num > 0) {
            System.out.println(num + " is positive");
        } else {
            System.out.println(num + " is negative");
        }
    }

    @And("I print {int}th day of the week")
    public void iPrintThDayOfTheWeek(int num) {
        String[] dayOfTheWeek = {"Monday", "Truesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
                System.out.println(num +"th day of the week is " + dayOfTheWeek[num - 1]);
    }


    @And("return true if {float} is even and divisible by five or if odd and divisible by three")
    public void returnTrueIfIsEvenAndDivisibleByFiveOrIfOddAndDivisibleByThree(float num) {
        Float remainderFive = num % 5;
        Float remainderThree = num%3;
        Float isEven = num%2;
        if ( num % 5 == 0 || num%3 == 0) {
            System.out.println(num+ " is even and divisible by five");
        } else if (isEven != 0 && remainderThree == 0) {
            System.out.println(num+ " is odd and divisible by three");
        } else {
            System.out.println(num+ " is out of scope");
        }

    }

    @And("print out all letters from ASCII")
    public void printOutAllLettersFromASCII() {
        char i;
        for (i = 'A'; i <= 'Z'; i++)
        {
            System.out.printf("%c ", i);
        }
    }

    @And("I solve the stocks task")
    public void iSolveTheStocksTask() {
    }

    @Given("I swap first name and middle name")
    public void iSwapFirstNameAndMiddleName() {
        Map<String, String> info = new LinkedHashMap<>();

        info.put("firstName", "John");
        info.put("middleName", "George");
        System.out.println("before: " + info);

        String placeholder = info.get("middleName");

        info.put("middleName", info.get("firstName"));
        info.put("firstName", placeholder);
        System.out.println("after: " + info);
    }

    @Given("I get an array and I swap a {int}rd and {int}th elements")
    public void iGetAnArrayAndISwapARdAndThElements(int third, int fifth) {
        int [] array = new int[] {5,2,9,7,3};

        for (int i = 0; i < array.length-1; i++) {
            System.out.print(array[i] + ", ");
            }
        System.out.println(array[array.length-1]);

        int placeHolder = array[third-1];
        array[third-1] = array[fifth-1];
        array[fifth-1] = placeHolder;

        for (int i = 0; i < array.length-1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length-1]);
    }

    @And("I check if {int} is divisible by three or four")
    public void iCheckIfIsDivisibleByThreeOrFour(int num) {
        if (num%3==0 && num%4==0) {
            System.out.println(num + " is divisible by three and four");
        } else if (num%4==0) {
            System.out.println(num+ " is divisible by four");
        } else if (num%3==0 ) {
            System.out.println(num+ " is divisible by three");
        } else {
            System.out.println(num+ " is not divisible by neither three or four");
        }
    }
}
