package Unit1;

public interface StudentResultInterface {

    void totalMarksObtainedByStudent(Student s);

    // default method
    default void studentResult(Student student){
        if(student.getPercentage()>40){
            System.out.println("Passed");
        }
    }

    // interface methods can hold static methods
     static void printDetailsOfStudent(Student student){
         System.out.println("Name        : "+student.getName());
         System.out.println("Total Marks : "+student.getTotalMarks());
         System.out.println("Percentage  : "+student.getPercentage());
     }

    void createResult(Student student);

    int totalMarks(Student student);

    float totalPercentage(Student student);
}
