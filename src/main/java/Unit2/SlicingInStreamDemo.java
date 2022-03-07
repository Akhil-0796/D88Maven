package Unit2;

import Unit1.Student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SlicingInStreamDemo {
    public static void main(String[] args) {

        List<Student> students = Student.getListOfStudents();

        // Slicing Helper
        List<Student> newList1 = helper1(students.stream(),0,5);
       // newList1.stream().forEach(student-> System.out.println(student.getId()));


        List<Student> newList2 = helper2(students.stream(),0,5);
        newList2.stream().forEach(student-> System.out.println(student.getId()));

    }

    private static List<Student> helper2(Stream<Student> stream, int start, int end) {
        return stream.skip(2).limit(2).collect(Collectors.toList());
    }

    private static List<Student> helper1(Stream<Student> stream, int start, int end) {
        return stream.collect(Collectors.toList()).subList(start,end).stream().collect(Collectors.toList());
    }
}
