package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.codehaus.groovy.transform.sc.ListOfExpressionsExpression;

import java.util.Arrays;
import java.util.List;

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
}
