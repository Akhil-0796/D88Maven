package Unit2;

import Unit1.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIDemo {
    public static void main(String[] args){


        List<Student> students = Student.getListOfStudents();

        // Filter operation in Stream API
        FilterOperation(students);

        // Map operation in Stream API
        MapOperation(students.get(0).getSubjectMarks());
    }

    private static void MapOperation(List<Integer> marks) {
        List<Integer> newList = marks.stream().map(mark -> mark+10).collect(Collectors.toList());
        newList.stream().forEach(System.out::println);
    }

    private static void FilterOperation(List<Student> students) {
        List<Student> filteredList = students.stream().filter(student-> student.getAge()>10).collect(Collectors.toList());
        filteredList.forEach(student -> System.out.println(student.getName()));
    }
}
