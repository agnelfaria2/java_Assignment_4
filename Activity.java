package dcst;

public abstract class Activity implements Reportable {
    private final String name;
    private final int year;
    private final String description;
    public Activity(String name, int year, String description) {
        this.name = name;
        this.year = year;
        this.description = description;
    }
    public String getName() { return name; }
    public int getYear() { return year; }
    public String getDescription() { return description; }
    public abstract String getCategory();
    @Override public void displayReport() {
        System.out.println("[" + getCategory() + "] " + name + " | Year: " + year + " | " + description);
    }
}
