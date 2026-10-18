package dcst;

public class NonTeachingStaff extends Staff {
    private final String workArea;
    public NonTeachingStaff(String id, String name, String workArea, String designation) {
        super(id, name, 35, "CST - Administration", designation);
        this.workArea = workArea;
    }
    @Override public String getRole() { return "Non-teaching Staff"; }
    @Override public void displayReport() {
        super.displayReport();
        System.out.println("  Work area: " + workArea);
    }
}
