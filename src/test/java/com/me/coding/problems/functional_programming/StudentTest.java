package com.me.coding.problems.functional_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StudentTest {

    public static void main(String[] args) {
        List<Student> listOfStudents = new ArrayList<>();

        listOfStudents.add(new Student(111, "John", 81.0, "Mathematics"));
        listOfStudents.add(new Student(222, "Harsha", 79.5, "History"));
        listOfStudents.add(new Student(333, "Ruth", 87.2, "Computers"));
        listOfStudents.add(new Student(444, "Aroma", 63.2, "Mathematics"));
        listOfStudents.add(new Student(555, "Zade", 83.5, "Computers"));
        listOfStudents.add(new Student(666, "Xing", 58.5, "Geography"));
        listOfStudents.add(new Student(777, "Richards", 72.6, "Banking"));
        listOfStudents.add(new Student(888, "Sunil", 86.7, "History"));
        listOfStudents.add(new Student(999, "Jordan", 58.6, "Finance"));
        listOfStudents.add(new Student(101010, "Chris", 89.8, "Computers"));

        // Predicate Example - We want only a list of "Mathematics" students from the above listOfStudents
        Predicate<Student> mathsPredicate = (Student student) -> student.getSpecialization().equals("Mathematics");

        List<Student> mathsStudentList = new ArrayList<>();
        for (Student s : listOfStudents) {
            if (mathsPredicate.test(s)) {
                mathsStudentList.add(s);
            }
        }
        System.out.println(mathsStudentList);

        // Consumer Example - displaying all students with their percentage
        Consumer<Student> percentageConsumer = (Student student) -> System.out.println(student.getName() + " : " + student.getPercentage());

        for (Student s : listOfStudents) {
            percentageConsumer.accept(s);
        }

        // Function Example - Extracting only the names of all students
        Function<Student, String> nameFunction = (Student Student) -> Student.getName();
        List<String> studentNames = new ArrayList<>();

        for (Student student : listOfStudents) {
            studentNames.add(nameFunction.apply(student));
        }

        // Supplier Example - Creating a new Student
        Supplier<Student> studentSupplier = () -> new Student(111111, "New Student", 92.9, "Java 8");
        listOfStudents.add(studentSupplier.get());

        // Method reference

        // 1. Method reference to static method (ClassName::MethodName)
        Function<String, Integer> lambdaFunction = (String s) -> Integer.parseInt(s);
        System.out.println(lambdaFunction.apply("12"));

        Function<String, Integer> referenceFunction = Integer::parseInt;
        System.out.println(referenceFunction.apply("12"));

        // 2. Method reference to instance method (ClassName::MethodName)
        Function<String, String> lf1 = (String s) -> s.toLowerCase();
        System.out.println(lf1.apply("JAVA"));

        Function<String, String> rf1 = String::toLowerCase;
        System.out.println(rf1.apply("JAVA"));

        // 3. Method reference to instance method (ReferenceVariable::MethodName)
        class Company {
            String name;

            public Company(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }
        }

        Company c = new Company("My_Company");

        Supplier<String> lambdaSupplier = () -> c.getName();
        System.out.println(lambdaSupplier.get());

        Supplier<String> referenceSupplier = c::getName;
        System.out.println(referenceSupplier.get());

        // 4. Constructor References
        class Org {
        }
        Supplier<Org> ls1 = () -> new Org();
        ls1.get();

        Supplier<Org> rs1 = Org::new;
        rs1.get();

    }
}
