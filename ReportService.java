package dcst;

public class ReportService {
    private ReportService() { }
    public static void print(Reportable item) {
        item.displayReport();
    }
}
