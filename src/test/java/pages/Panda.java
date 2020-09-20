package pages;

public class Panda extends Animal {

    public Panda(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println(classAndName() + " is not really into talking...");
    }

    public void move() {
        System.out.println(classAndName() + " is rolling around");
    }

}
