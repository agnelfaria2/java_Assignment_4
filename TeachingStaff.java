package dcst;

public class TeachingStaff extends Staff {
    private final String subjectArea;
    public TeachingStaff(String id, String name, String subjectArea, String designation) {
        super(id, name, 40, "CST - Teaching", designation);
        this.subjectArea = subjectArea;
    }
    @Override public String getRole() { return "Teaching Staff"; }
    @Override public void displayReport() {
        super.displayReport();
        System.out.println("  Subject area: " + subjectArea);
    }
}
