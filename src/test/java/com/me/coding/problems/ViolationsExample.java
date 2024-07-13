import java.util.*;

public class ViolationsExample {
    private String name;
    private int age;
    private List<String> hobbies;

    public ViolationsExample() {
        this.name = "John Doe";
        this.age = 25;
        this.hobbies = new ArrayList<String>();
    }

    public void addHobby(String hobby) {
        hobbies.add(hobby);
    }

    public void printHobbies() {
        for (int i = 0; i < hobbies.size(); i++) {
            System.out.println(hobbies.get(i));
        }
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Hobbies: ");
        printHobbies();
    }
}
