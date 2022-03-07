package Unit1;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Student {
    private int id;
    private String name;
    private float percentage;
    private int totalMarks;
    private List<Integer> subjectMarks= new ArrayList<>();
    private String fatherName;
    private String MotherName;
    private int age;

    public Student(int id, String name, List<Integer> subjectMarks, String fatherName, String motherName, int age) {
        this.id = id;
        this.name = name;
        this.subjectMarks = subjectMarks;
        this.fatherName = fatherName;
        MotherName = motherName;
        this.age = age;
    }
    public static List<Student> getListOfStudents(){
        Student student1 = new Student(101,"student1", List.of(45, 65, 60, 25, 98),"Ramesh", "Shakuntala", 16);
        Student student2 = new Student(102,"student2",List.of(42, 65, 70, 25, 98), "Ryan", "mother1", 13);
        Student student3 = new Student(103,"student3",List.of(43, 65, 76, 25, 98), "Sher", "mother2", 12);
        Student student4 = new Student(104,"student4",List.of(35, 65, 73, 25, 98), "Rajesh", "mother3", 17);
        Student student5 = new Student(105,"student5", List.of(45, 65, 60, 25, 98),"Ramesh", "Shakuntala", 16);
        Student student6 = new Student(106,"student6",List.of(42, 65, 70, 25, 98), "Ryan", "mother1", 13);
        Student student7 = new Student(107,"student7",List.of(43, 65, 76, 25, 98), "Sher", "mother2", 12);
        Student student8 = new Student(108,"student8",List.of(35, 65, 73, 25, 98), "Rajesh", "mother3", 17);
        return List.of(student1,student2,student3,student4,student5,student6,student7,student8);
    }
    public Student(int id, String fatherName, String motherName, int age) {
        this.id = id;
        this.fatherName = fatherName;
        MotherName = motherName;
        this.age = age;
    }
    public Student(int id, String name, List<Integer> subjectMarks) {
        this.id = id;
        this.name = name;
        this.subjectMarks = subjectMarks;
    }
}
