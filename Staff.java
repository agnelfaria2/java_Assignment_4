package dcst;

public abstract class Staff extends Person {
    private final String staffId;
    private final String designation;
    protected Staff(String staffId, String name, int age, String section, String designation) {
        super(name, age, section, "Goa University / Goa Business School");
        this.staffId = staffId;
        this.designation = designation;
        MemberCounter.increment();
    }
    public String getStaffId() { return staffId; }
    @Override public void displayReport() {
        super.displayReport();
        System.out.println("  Staff ID: " + staffId + " | Designation: " + designation);
    }
}
