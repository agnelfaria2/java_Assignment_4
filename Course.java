package dcst;

public class Course {
    private final String code;
    private final String name;
    private final int credits;
    public Course(String code, String name, int credits) {
        this.code = code;
        this.name = name;
        this.credits = credits;
    }
    public String getName() { return name; }
    @Override public String toString() { return code + " - " + name + " (" + credits + " credits; sample)"; }
}
