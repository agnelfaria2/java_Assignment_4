package dcst;

public class MemberCounter {
    private static int count = 0;
    private MemberCounter() { }
    public static void increment() { count++; }
    public static void displayCount() {
        System.out.println("Total Student and Staff objects constructed: " + count);
    }
}
