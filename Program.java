package dcst;

import java.util.ArrayList;
import java.util.List;

public class Program implements Reportable {
    private final String name;
    private final String level;
    private final List<Course> subjects = new ArrayList<Course>();
    public Program(String name, String level) {
        this.name = name;
        this.level = level;
    }
    public void addSubject(Course course) { subjects.add(course); }
    @Override public void displayReport() {
        System.out.println(level + " programme: " + name);
        for (Course subject : subjects) System.out.println("  - " + subject);
    }
}
