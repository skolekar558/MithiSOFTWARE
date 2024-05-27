package Assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class ExcludeWordsReaderDemo {
	 public static Set<String> readExcludeWords(String filename) throws IOException {
	        Set<String> excludeWords = new HashSet<>(Files.readAllLines(Paths.get(filename)));
	        return excludeWords;
	    }
}
