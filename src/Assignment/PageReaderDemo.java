package Assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PageReaderDemo {
	public static String readPageMethod(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
}
