package dcst;

import java.lang.reflect.Field;
import java.util.*;

public class OOPDemo {
    private OOPDemo() { }
    public static void run(Student student) {
        System.out.println("\n--- ABSTRACT CLASS / INTERFACE / MESSAGE PASSING ---");
        Person person = student;
        person.displayReport();
        student.attendActivity("Coding workshop");
        notifyParticipant(student, "Please submit activity details for the annual report.");

        System.out.println("\n--- POLYMORPHISM ---");
        List<Reportable> reportables = new ArrayList<Reportable>();
        reportables.add(student);
        reportables.add(new TeachingStaff("T999", "Demo Faculty", "Programming", "Lecturer"));
        for (Reportable r : reportables) ReportService.print(r);
        ReportPrinter printer = new ReportPrinter();
        printer.print("Annual activity report");
        printer.print("Annual activity report", 3);

        System.out.println("\n--- ACCESS MODIFIERS ---");
        AccessExample access = new AccessExample();
        access.showInside();
        System.out.println("Public field outside class: " + access.publicField);
        System.out.println("Private field via getter: " + access.getPrivateField());

        System.out.println("\n--- REFLECTION / RTTI ---");
        System.out.println("Runtime class: " + student.getClass().getName());
        System.out.print("Declared fields: ");
        for (Field field : student.getClass().getDeclaredFields()) System.out.print(field.getName() + " ");
        System.out.println();
        System.out.println("Interfaces: " + Arrays.toString(student.getClass().getInterfaces()));
        System.out.println("Java supports multiple interface inheritance, not multiple superclass inheritance.");
    }

    private static void notifyParticipant(Attendable participant, String message) {
        participant.attendActivity(message);
    }
}

class ReportPrinter {
    public void print(String title) { System.out.println("Report: " + title); }
    public void print(String title, int years) {
        System.out.println("Report: " + title + " | Period: " + years + " years");
    }
}

class AccessExample {
    public String publicField = "public";
    private String privateField = "private";
    protected String protectedField = "protected";
    public void showInside() {
        System.out.println("Inside class: " + publicField + ", " + privateField + ", " + protectedField);
    }
    public String getPrivateField() { return privateField; }
}
