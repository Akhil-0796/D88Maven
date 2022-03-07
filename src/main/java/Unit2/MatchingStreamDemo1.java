package Unit2;

import Unit1.Student;
import Unit1.StudentResultImpl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatchingStreamDemo1 {
    private StudentResultImpl studentResult;

    public MatchingStreamDemo1() {
        this.studentResult = new StudentResultImpl();
    }

    public static void main(String[] args) {
        List<Student> studentList = Student.getListOfStudents();
        MatchingStreamDemo1 matchingStreamDemo1 =  new MatchingStreamDemo1();
        // Matching helper
        System.out.println("All the students are passed = "+ matchingStreamDemo1.isAllStudentsPassed(studentList));
        System.out.println("All the students are greater than 18 = "+ matchingStreamDemo1.studentsGreaterThan18(studentList));
    }

    public boolean studentsGreaterThan18(List<Student> studentList) {
        studentList.forEach(student ->studentResult.createResult(student));
        return studentList.stream().allMatch(student -> student.getAge()>40);
    }

    // allMatch case
    public boolean isAllStudentsPassed(List<Student> studentList) {
        studentList.forEach(student ->studentResult.createResult(student));
        return studentList.stream().allMatch(student -> student.getPercentage()>40);
    }

    // anyMatch case
    public boolean isStudentPassedInAllSubject(List<Integer> subjectMarks){
       return subjectMarks.stream().anyMatch(mark -> mark<40);
    }

    // findAny case
    public List<Student> studentGotDistinction(List<Student> studentList){
        studentList.forEach(student ->studentResult.createResult(student));
        var list = studentList.stream().filter(student -> student.getPercentage()>75).findAny();
        return list.stream().toList();
    }

    // collect case
    public List<String> studentGotPassed(List<Student> studentList){
        studentList.forEach(student ->studentResult.createResult(student));
        return studentList.stream().filter(student -> student.getPercentage()>40).map(student -> student.getName()).collect(Collectors.toList());
    }
}
