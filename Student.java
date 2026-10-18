package dcst;

/** A student record; data are sample entries for demonstrating OOP. */
public class Student extends Person implements Attendable, Cloneable {
    private final String studentId;
    private final int rollNumber;
    private final ProgramType program;
    private AcademicRecord academicRecord;

    public Student(String studentId, String name, int age, int rollNumber,
                   ProgramType program, AcademicRecord academicRecord) {
        super(name, age, "CST", "Goa University / Goa Business School");
        this.studentId = studentId;
        this.rollNumber = rollNumber;
        this.program = program;
        this.academicRecord = academicRecord;
        MemberCounter.increment();
    }
    public String getStudentId() { return studentId; }
    public int getRollNumber() { return rollNumber; }
    public ProgramType getProgram() { return program; }
    public AcademicRecord getAcademicRecord() { return academicRecord; }
    public void setAcademicRecord(AcademicRecord record) { academicRecord = record; }
    @Override public String getRole() { return "Student"; }
    @Override public void displayReport() {
        super.displayReport();
        System.out.println("  ID: " + studentId + " | Roll No: " + rollNumber + " | Program: " + program);
        if (academicRecord != null) System.out.println("  Academic record: " + academicRecord.getSummary());
    }
    @Override public void attendActivity(String activityName) {
        System.out.println(getName() + " is attending: " + activityName);
    }
    @Override public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
    public Student deepClone() throws CloneNotSupportedException {
        Student copy = (Student) super.clone();
        if (academicRecord != null) copy.academicRecord = academicRecord.clone();
        return copy;
    }
}
