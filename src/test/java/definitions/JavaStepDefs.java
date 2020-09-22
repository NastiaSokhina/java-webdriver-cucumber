package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.apache.commons.lang3.Range;
import pages.*;

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

    @And("I print all numbers from zero to {int}")
    public void iPrintAllNumbersFromZeroTo(int n) {

        for (int i=0; i <= n; i++) {
            System.out.println(i);
        }
    }

    @And("I print all numbers from {int} including negative")
    public void iPrintAllNumbersFromIncludingNegative(int n) {
        if (n>0) {
            for (int i=0; i <= n; i++) {
                System.out.println(i);
            }
        } else if (n<0) {
            for (int i=n; i <= 0; i++) {
                System.out.println(i);
            }
        }
    }

    @And("I print all integer array")
    public void iPrintAllIntegerArray() {
        int[] array = {2, 56,3,4,78,23,1,15}; {
            for (int i : array) {
                System.out.println(i);
            }
        }
    }

    @And("I only even numbers from an array")
    public void iOnlyEvenNumbersFromAnArray() {
        int[] array = {2, 56,3,4,78,23,1,15, 201, 10, 33}; {
            for (int i : array) {
                if (i%2==0) {
                    System.out.println(i);
                }
            }
        }
    }

    @And("I print out all number up to {int} and check if its divisible by three or five")
    public void iPrintOutAllNumberUpToAndCheckIfItsDivisibleByThreeOrFive(int n) {
            for (int i=1; i<=n; i++ ) {
                if (i%15==0) {
                    System.out.println("FizzBuzz");
                }else if (i%5==0) {
                    System.out.println("Buzz");
                } else if (i%3==0) {
                    System.out.println("Fizz");
                } else {
                    System.out.println(i);
                }
            }
    }


    @And("I check if an array is empty")
    public void iCheckIfAnArrayIsEmpty() {
        int[] array = { };
        if (array.length == 0) {
            System.out.println("array is empty");
        } else {
            for (int i : array) {
                System.out.println(i);
            }
        }
    }


    @And("I check if an array has {int}")
    public void iCheckIfAnArrayHas(int num) {
        int[] array = {2,5,13,73,67};
            boolean result = false;
            for (int i: array) {
                if (i == num) {
                    result = true;
                    break;
                }
            }
            if (result) {
                System.out.println("array contains "+num);
            } else {System.out.println(num+" is not in this array");};

    }

    @And("I remove vowels from {string}")
    public void iRemoveVowelsFrom(String s) {
        String str1 = s.replace("a", "");
        String str2 = str1.replace("o", "");
        String str3 = str2.replace("i", "");
        String str4 = str3.replace("e", "");
        String str5 = str4.replace("u", "");
        for (int i = 0; i < str5.length(); i++) {
            System.out.print(str5.charAt(i));
        }
    }

    @And("I input {int} and {int} to check the range that they belong to")
    public void iInputAndToCheckTheRangeThatTheyBelongTo(int num1, int num2) {
        if (num1%5==0 && num2%5==0) {
            Range<Integer> range1 = Range.between(1, 10);
            Range<Integer> range2 = Range.between(11,20);
            if (range1.contains(num1) || range1.contains(num2)) {
                System.out.println("This number belongs to 1...10 range");
            } else if (range2.contains(num1) || range2.contains(num2)) {
                System.out.println("This number belongs to 11...20 range");
            }
        } else {
            System.out.println("Please provide numbers divisible by 5");
        }
    }


    @And("I write a function that counts number of each character in a string {string}")
    public void iWriteAFunctionThatCountsNumberOfEachCharacterInAString(String str) {
        int num = str.length();
        System.out.println("Number of characters: "+num);
    }

    @And("I check if a word {string} is a palindrome")
    public boolean iCheckIfAWordIsAPalindrome(String word) {
        int i = 0;
        int j = word.length() - 1;
        while (j>i) {
            if (word.charAt(i) != word.charAt(j)) {
                System.out.println(word+" is not a palindrome");
                return false;
            }
                i++;
                j--;
            }
        return true;

    }

    @And("I check if array has duplicates")
    public void iCheckIfArrayHasDuplicates() {
        String[] array = {"rose", "lilly", "rose", "violet"};
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    System.out.println("We got a duplicate!");
                }
            }
        }
    }

    @And("I find two max numbers in an array")
    public void iFindTwoMaxNumbersInAnArray() {
        int[] array = {1, 200,6,2,5,3};
        int maxOne = 0;
        int maxTwo = 0;
        for(int n:array) {
            if(maxOne<n) {
                maxTwo = maxOne;
                maxOne =n;
            } else if (maxTwo<n) {
                maxTwo = n;
            }
        }
        System.out.println("First max: "+maxOne);
        System.out.println("Second max: "+maxTwo);

    }

    @And("I work with classes")
    public void iWorkWithClasses() {
        Animal cat = new Cat("Richie");
        System.out.println(cat.getName());
        cat.walk();
        cat.sleep();
        cat.speak();
        cat.eat("fish");

        Animal dog = new Dog();
        dog.setName("Lessi");
        System.out.println(dog.getName());
        dog.walk();
        dog.sleep();
        dog.speak();
        dog.eat("fish");

        Animal canary = new Canary("Tweety");
        canary.speak();

        Animal panda = new Panda("Poh");
        panda.sleep();
        panda.speak();

        List<Animal> list = new ArrayList<>();
        list.add(cat);
        list.add(dog);
        list.add(canary);
        printAnimalNames(list);
    }
    public void printAnimalNames(List<Animal> animals) {
        System.out.println("print names method");
        for (Animal animal : animals) {
            animal.speak();
            System.out.println(animal.getName());
        }
    }

    @And("I print Fibonacci sequence until {int} number")
    public void iPrintFibonacciSequenceUntilNumber(int digitNumber) {
        int n1=0, n2=1;
        System.out.println(n1);
        System.out.println(n2);
        for (int i=0; i < digitNumber; i++) {
            int sum = n1 + n2;
            n1 = n2;
            n2 = sum;
            System.out.println(sum);

        }
    }
}
