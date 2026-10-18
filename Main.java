package dcst;

import java.io.IOException;
import java.util.*;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final List<Student> students = new ArrayList<Student>();
    private static final List<Staff> staff = new ArrayList<Staff>();
    private static final Set<String> subjects = new TreeSet<String>();
    private static final Queue<String> tasks = new LinkedList<String>();
    private static final Map<Integer, List<Activity>> activities = new TreeMap<Integer, List<Activity>>();
    private static final List<Program> programs = new ArrayList<Program>();

    public static void main(String[] args) {
        seedData();
        System.out.println("========================================================");
        System.out.println(" DCST / GOA BUSINESS SCHOOL - STUDENT DEVELOPMENT SYSTEM");
        System.out.println(" MCA OOP Assignment | Roll No: 2605 | Batch: B1");
        System.out.println("========================================================");
        System.out.println("Demo records are illustrative and are not official NIRF data.");

        boolean running = true;
        while (running) {
            menu();
            try {
                System.out.print("Enter choice: ");
                int choice = Integer.parseInt(input.nextLine().trim());
                switch (choice) {
                    case 1: showStudents(); break;
                    case 2: showStaff(); break;
                    case 3: showPrograms(); break;
                    case 4: showActivities(true); break;
                    case 5: showActivities(false); break;
                    case 6: showThreeYearReport(); break;
                    case 7: addStudent(); break;
                    case 8: demonstrateReferencesAndCloning(); break;
                    case 9: OOPDemo.run(students.get(0)); break;
                    case 10: showCollections(); break;
                    case 11: MemberCounter.displayCount(); break;
                    case 12: saveReport(); break;
                    case 13: loadReport(); break;
                    case 0: running = false; break;
                    default: System.out.println("Invalid choice. Select 0 to 13.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input error: please enter a whole number.");
            } catch (CustomException e) {
                System.out.println("Validation error: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("File operation failed: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Handled application error: " + e.getMessage());
            } finally {
                System.out.println();
            }
        }
        input.close();
        System.out.println("Thank you. Student Development System closed.");
    }

    private static void menu() {
        System.out.println("\n-------------------- MAIN MENU --------------------");
        System.out.println("1. Student details");
        System.out.println("2. Teaching and non-teaching staff");
        System.out.println("3. Programs and subjects");
        System.out.println("4. Academic activities");
        System.out.println("5. Non-academic activities");
        System.out.println("6. Three-year NIRF-style summary");
        System.out.println("7. Add a student");
        System.out.println("8. Object references and cloning");
        System.out.println("9. OOP concepts demonstration");
        System.out.println("10. Collection framework");
        System.out.println("11. Static member counter");
        System.out.println("12. Save report to file");
        System.out.println("13. Read saved report");
        System.out.println("0. Exit");
        System.out.println("---------------------------------------------------");
    }

    private static void seedData() {
        students.add(new Student("ST101", "Aarav Naik", 22, 2601, ProgramType.MCA,
                new AcademicRecord(82.5, "Illustrative sample record")));
        students.add(new Student("ST102", "Mira Kamat", 23, 2602, ProgramType.MCA,
                new AcademicRecord(86.0, "Illustrative sample record")));
        students.add(new Student("ST103", "Rohan Dessai", 21, 2605, ProgramType.MCA,
                new AcademicRecord(79.5, "Illustrative sample record")));

        staff.add(new TeachingStaff("T101", "Dr. Leena Rao", "Computer Science", "Assistant Professor"));
        staff.add(new TeachingStaff("T102", "Prof. Joel Fernandes", "Data Science", "Associate Professor"));
        staff.add(new NonTeachingStaff("N101", "Ms. Anita Naik", "Department Office", "Office Assistant"));

        Program mca = new Program("Master of Computer Applications (MCA)", "Postgraduate");
        mca.addSubject(new Course("CS101", "Object-Oriented Programming", 4));
        mca.addSubject(new Course("CS102", "Data Structures and Algorithms", 4));
        mca.addSubject(new Course("CS103", "Database Management Systems", 3));
        programs.add(mca);
        subjects.add("Object-Oriented Programming (sample subject)");
        subjects.add("Data Structures and Algorithms (sample subject)");
        subjects.add("Database Management Systems (sample subject)");
        subjects.add("Operating Systems and Computer Networks (sample subject)");
        subjects.add("Software Engineering (sample subject)");
        subjects.add("Web Technologies / Data Science electives (sample subject area)");

        addActivity(new AcademicActivity("ISA", 2024, "Internal assessment - verify actual schedule"));
        addActivity(new AcademicActivity("Midpoint Assessment", 2024, "Assessment category - sample entry"));
        addActivity(new NonAcademicActivity("InfoFest", 2024, "Student event - verify year and details"));
        addActivity(new AcademicActivity("SEA", 2025, "Semester-end assessment - sample entry"));
        addActivity(new AcademicActivity("Study Tour / Industrial Visit", 2025, "Sample category; verify records"));
        addActivity(new NonAcademicActivity("Plateaunica", 2025, "Event name supplied in assignment; verify spelling/details"));
        addActivity(new AcademicActivity("Internship and Placement Preparation", 2026, "Sample category; verify actual events"));
        addActivity(new AcademicActivity("Guest Lecture / Technical Workshop", 2026, "Sample category; verify records"));
        addActivity(new NonAcademicActivity("Play-on", 2026, "Event name supplied in assignment; verify details"));
        addActivity(new NonAcademicActivity("Sports, Cultural and Student Club Activities", 2026, "Additional illustrative category"));

        tasks.offer("Verify official subject list");
        tasks.offer("Confirm activity dates and participation figures");
        tasks.offer("Add verified staff and placement data");
    }

    private static void addActivity(Activity activity) {
        if (!activities.containsKey(activity.getYear())) activities.put(activity.getYear(), new ArrayList<Activity>());
        activities.get(activity.getYear()).add(activity);
    }

    private static void showStudents() {
        System.out.println("\n--- STUDENT RECORDS (SAMPLE) ---");
        for (Student student : students) ReportService.print(student);
    }

    private static void showStaff() {
        System.out.println("\n--- STAFF RECORDS (SAMPLE) ---");
        for (Staff member : staff) ReportService.print(member);
    }

    private static void showPrograms() {
        System.out.println("\n--- PROGRAMS AND SUBJECTS ---");
        for (Program program : programs) ReportService.print(program);
        System.out.println("Unique subject areas (Set): " + subjects);
        System.out.println("Verify exact current programme and semester-wise syllabus before official use.");
    }

    private static void showActivities(boolean academic) {
        System.out.println(academic ? "\n--- ACADEMIC ACTIVITIES ---" : "\n--- NON-ACADEMIC ACTIVITIES ---");
        for (List<Activity> yearList : activities.values()) {
            for (Activity activity : yearList) {
                if (academic == (activity instanceof AcademicActivity)) activity.displayReport();
            }
        }
    }

    private static void showThreeYearReport() {
        System.out.println("\n--- THREE-YEAR SUMMARY (ILLUSTRATIVE DATA) ---");
        for (Map.Entry<Integer, List<Activity>> entry : activities.entrySet()) {
            int acad = 0, nonAcad = 0;
            for (Activity a : entry.getValue()) {
                if (a instanceof AcademicActivity) acad++; else nonAcad++;
            }
            System.out.println("\nAcademic year ending " + entry.getKey()
                    + " | Academic activities: " + acad + " | Non-academic activities: " + nonAcad);
            for (Activity a : entry.getValue()) a.displayReport();
        }
        System.out.println("\nStudents in demonstration dataset: " + students.size());
        System.out.println("Staff in demonstration dataset: " + staff.size());
        System.out.println("These counts are sample records, not official department statistics.");
    }

    private static void addStudent() throws CustomException {
        System.out.print("Student ID: ");
        String id = input.nextLine().trim();
        System.out.print("Full name: ");
        String name = input.nextLine().trim();
        System.out.print("Age: ");
        int age = Integer.parseInt(input.nextLine().trim());
        System.out.print("Roll number: ");
        int roll = Integer.parseInt(input.nextLine().trim());
        System.out.print("Program (MCA/MSC/PHD/OTHER): ");
        ProgramType type;
        try { type = ProgramType.valueOf(input.nextLine().trim().toUpperCase()); }
        catch (IllegalArgumentException e) { throw new CustomException("Program must be MCA, MSC, PHD or OTHER."); }
        if (id.isEmpty() || name.isEmpty() || age < 16 || roll <= 0)
            throw new CustomException("ID/name cannot be empty; age and roll number must be valid.");
        for (Student s : students) if (s.getRollNumber() == roll) throw new CustomException("Roll number already exists.");
        students.add(new Student(id, name, age, roll, type, new AcademicRecord(0.0, "New student record")));
        System.out.println("Student record added successfully.");
    }

    private static void demonstrateReferencesAndCloning() throws CloneNotSupportedException {
        Student original = students.get(0);
        Student secondReference = original;
        System.out.println("\n--- SHARED OBJECT REFERENCE ---");
        System.out.println("Original name: " + original.getName());
        secondReference.setName("Aarav Naik (updated via second reference)");
        System.out.println("Name through original reference: " + original.getName());
        original.setName("Aarav Naik");

        Student shallow = original.clone();
        Student deep = original.deepClone();
        original.getAcademicRecord().setRemark("Changed after cloning");
        System.out.println("\n--- CLONING ---");
        System.out.println("Original nested record: " + original.getAcademicRecord().getSummary());
        System.out.println("Shallow copy nested record: " + shallow.getAcademicRecord().getSummary());
        System.out.println("Deep copy nested record: " + deep.getAcademicRecord().getSummary());
        System.out.println("Shallow copy shares AcademicRecord; deep copy has an independent AcademicRecord.");
    }

    private static void showCollections() {
        System.out.println("\n--- COLLECTION FRAMEWORK ---");
        List<String> studentNames = new ArrayList<String>();
        for (Student s : students) studentNames.add(s.getName());
        System.out.println("List<Student names>: " + studentNames);
        System.out.println("Set<subjects> (unique): " + subjects);
        System.out.println("Queue<tasks> next task: " + tasks.peek());
        Map<Integer, Integer> studentCountByYear = new TreeMap<Integer, Integer>();
        studentCountByYear.put(2024, 2);
        studentCountByYear.put(2025, 3);
        studentCountByYear.put(2026, students.size());
        System.out.println("Map<year, sample student count>: " + studentCountByYear);
        GenericBox<String> box = new GenericBox<String>("NIRF report data");
        System.out.println("GenericBox<T> value: " + box.getValue());
    }

    private static void saveReport() throws IOException {
        List<String> lines = new ArrayList<String>();
        lines.add("DCST / Goa Business School - Academic Information Report (DEMO)");
        lines.add("Period: 2023-24 to 2025-26");
        lines.add("Student records in this demo: " + students.size());
        lines.add("Staff records in this demo: " + staff.size());
        lines.add("Subject areas: " + subjects);
        for (Map.Entry<Integer, List<Activity>> entry : activities.entrySet()) {
            lines.add("Year ending " + entry.getKey());
            for (Activity a : entry.getValue()) lines.add(a.getCategory() + " | " + a.getName() + " | " + a.getDescription());
        }
        DataManager.saveLines("data/dcst_report.txt", lines);
        System.out.println("Report saved to data/dcst_report.txt.");
    }

    private static void loadReport() throws IOException {
        System.out.println("\n--- SAVED REPORT FILE ---");
        DataManager.displayFile("data/dcst_report.txt");
    }
}
