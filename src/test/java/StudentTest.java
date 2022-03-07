import Unit1.Student;
import Unit1.StudentResultImpl;
import Unit2.MatchingStreamDemo1;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void test_StudentResult() {
        try {
            Student student1 = new Student(101, "student1", List.of(45, 65, 70, 25, 98), "Ryan", "mother1", 13);
            assertTrue(student1.getPercentage() == 0.0);

            StudentResultImpl studentResult = new StudentResultImpl();
            studentResult.createResult(student1);
            assertTrue(student1.getPercentage() == 60.0);
            assertTrue(student1.getTotalMarks() == 303);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void test_allStudentsPassed() {
        try {
            Student student1 = new Student(101, "student1", List.of(45, 65, 60, 25, 98), "Ramesh", "Shakuntala", 16);
            Student student2 = new Student(102, "student2", List.of(42, 65, 70, 25, 98), "Ryan", "mother1", 13);
            Student student3 = new Student(103, "student3", List.of(43, 65, 76, 25, 98), "Sher", "mother2", 12);
            List<Student> students = List.of(student1, student2, student3);
            MatchingStreamDemo1 matchingStreamDemo1 = new MatchingStreamDemo1();

            var result = matchingStreamDemo1.isAllStudentsPassed(students);
            assertEquals(result, true);

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void test_isStudentIsPassedInAllSubject() {
        try {
            MatchingStreamDemo1 matchingStreamDemo1 = new MatchingStreamDemo1();
            List<Integer> marks = List.of(45, 65, 60, 25, 98);

            assertEquals(matchingStreamDemo1.isStudentPassedInAllSubject(marks), true);

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void test_studentGotDistinction() {
        try {
            Student student1 = new Student(101, "student1", List.of(78, 76, 78, 75, 79), "Ramesh", "Shakuntala", 16);
            Student student2 = new Student(102, "student2", List.of(82, 85, 80, 85, 98), "Ryan", "mother1", 13);
            Student student3 = new Student(103, "student3", List.of(43, 65, 76, 25, 98), "Sher", "mother2", 12);
            List<Student> students = List.of(student1, student2, student3);
            MatchingStreamDemo1 matchingStreamDemo1 = new MatchingStreamDemo1();
            assertEquals("student1",matchingStreamDemo1.studentGotDistinction(students).get(0).getName());


        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void test_studentNameWithPassingMraks(){
        try{
            Student student1 = new Student(101, "student1", List.of(45, 65, 60, 25, 98), "Ramesh", "Shakuntala", 16);
            Student student2 = new Student(102, "student2", List.of(42, 65, 70, 25, 98), "Ryan", "mother1", 13);
            Student student3 = new Student(103, "student3", List.of(40, 35, 25, 25, 38), "Sher", "mother2", 12);
            List<Student> students = List.of(student1, student2, student3);
            MatchingStreamDemo1 matchingStreamDemo1 = new MatchingStreamDemo1();
            var studentList = matchingStreamDemo1.studentGotPassed(students);
            assertTrue(studentList.contains("student1"));
            assertTrue(studentList.contains("student2"));
            assertFalse(studentList.contains("student3"));

        }catch (Exception e){
            e.printStackTrace();
            fail();
        }
    }
}
