package Unit1;

public class StudentResultImpl implements StudentResultInterface{
    @Override
    public void totalMarksObtainedByStudent(Student s) {
        System.out.println("Total Marks = "+s.getTotalMarks());
    }

    @Override
    public void createResult(Student student) {
        student.setTotalMarks(this.totalMarks(student));
        student.setPercentage(this.totalPercentage(student));
    }

    @Override
    public int totalMarks(Student student) {
        int sum=0;
        for(var it:student.getSubjectMarks()){
            sum+=it;
        }
        return sum;
    }

    @Override
    public float totalPercentage(Student student) {
        return Math.round(student.getTotalMarks()/5);
    }
}
