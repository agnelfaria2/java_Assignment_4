package dcst;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class DataManager {
    private DataManager() { }
    public static void saveLines(String fileName, List<String> lines) throws IOException {
        Path path = Paths.get(fileName);
        if (path.getParent() != null) Files.createDirectories(path.getParent());
        Files.write(path, lines, StandardCharsets.UTF_8);
    }
    public static void displayFile(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            System.out.println("No saved report found. Choose option 12 to create one first.");
            return;
        }
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        for (String line : lines) System.out.println(line);
    }
}
