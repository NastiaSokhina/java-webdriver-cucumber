package pages;

public class Dog extends Animal {

    public void speak() {
        System.out.println(classAndName() + " is barking");
    }

    public void fetch(String what) {
        System.out.println(classAndName() + " is looking for " + what);
    }

}