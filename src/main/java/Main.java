import Unit1.Student;
import Unit1.StudentFunctionalInterface;
import Unit1.StudentResultImpl;
import Unit1.StudentResultInterface;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(101, "Arjun", List.of(47, 50, 76, 89, 98));
        Student student2 = new Student(102,"student2", List.of(45, 65, 70, 25, 98),"Ramesh", "Shakuntala", 16);
        Student student3 = new Student(103, "Rakesh", List.of(45, 65, 70, 25, 98));
        Student student4 = new Student(104, "Jimmy", List.of(47, 56, 76, 89, 98));
        Student student5 = new Student(102,"student5",List.of(45, 65, 70, 25, 98), "Ryan", "mother1", 13);
        Student student6 = new Student(102,"student6",List.of(45, 65, 70, 25, 98), "Sher", "mother2", 12);
        Student student7 = new Student(102,"student7",List.of(45, 65, 70, 25, 98), "Rajesh", "mother3", 17);

        StudentResultImpl s = new StudentResultImpl();
        s.createResult(student1);
        s.createResult(student3);
        s.createResult(student4);
        s.createResult(student5);
        s.createResult(student6);
        s.createResult(student7);

        System.out.println("--------------- Default Methods ---------");
        // abstract methods
        System.out.println("Total Marks = " + s.totalMarks(student1));
        System.out.println("Tota Percentage = " + s.totalPercentage(student1));

        // default methods
        s.studentResult(student1);
        // direct calling of static methods
        StudentResultInterface.printDetailsOfStudent(student1);

        System.out.println("--------- Lambda Expressions ------------------");
        // lambda expression to define personalDetailsOfStudent method
        StudentFunctionalInterface studentFunctionalInterface = (student -> System.out.println("Age = " + student.getAge()));

        // calling personalDetailsOfStudent
        studentFunctionalInterface.personalDetailsOfStudent(student2);

        System.out.println("------------ Comparator with Lambdas -------------");
        // Comparator Interface
        ArrayList<Student> studentArrayList = new ArrayList<>(List.of(student1, student3, student4));

        // sorting student list based on the total marks obtained by the students
        Comparator<Student> comparator = (Student o1, Student o2) -> {
            if (o1.getTotalMarks() > o2.getTotalMarks()) {
                return 1;
            }
            return -1;
        };
        Collections.sort(studentArrayList, comparator);
        for (var it : studentArrayList) {
            System.out.println("Name = " + it.getName());
            System.out.println("Name = " + it.getTotalMarks());
        }

        System.out.println("-------------Predicate Code -----------------");
        // use of predicate to find out the students whose age is greater than 14
        List<Student> studentArrayList1 = (List.of(student2, student5, student6,student7));

        // defining the Predicate
        Predicate<Student> predicate = student -> student.getAge()>12;

        List<Student> newFilteredList = (ArrayList<Student>) studentArrayList1.stream().filter(predicate).collect(Collectors.toList());
        // we can aso write it as
        //List<Student> newFilteredList = (ArrayList<Student>) studentArrayList1.stream().filter(student -> student.getAge()>12).collect(Collectors.toList());
        newFilteredList.forEach(student -> System.out.println(student.getName()));

        System.out.println("------------- Supplier Interface Code -----------------");
        // using Supplier Interface to check the student is pass or fail
        Supplier<Boolean> supplier = ()-> student5.getPercentage()>40;
        System.out.println(student5.getName() + " = "+supplier.get());
        Supplier<LocalDateTime> localDateTimeSupplier = () -> LocalDateTime.now();
        System.out.println("Current Time = "+localDateTimeSupplier.get().toLocalTime());

        System.out.println("------------- Consumer Interface Code -----------------");

        var marksList = student5.getSubjectMarks();
        // using consumer Interface to calculate total marks of the students
        Consumer<List<Integer>> consumer = list ->{
            int totalMarks = list.stream()
                    .mapToInt(Integer::intValue)
                    .sum();
            System.out.println(student5.getName()+" has got "+totalMarks+" marks");
        };
        // calling consumer method
        consumer.accept(student5.getSubjectMarks());

    }
}
