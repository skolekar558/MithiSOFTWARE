package Assignment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class IndexerDemo {
	public static Map<String, Set<Integer>> processPages(Map<Integer, String> pages, Set<String> excludeWords) {
        Map<String, Set<Integer>> index = new TreeMap<>();
        for (Map.Entry<Integer, String> entry : pages.entrySet()) {
            int pageNumber = entry.getKey();
            String content = entry.getValue();
            String[] words = content.toLowerCase().replaceAll("[^a-z0-9]", " ").split("\\s+");
            for (String word : words) {
                if (!excludeWords.contains(word) && !word.isEmpty()) {
                    index.computeIfAbsent(word, k -> new HashSet<>()).add(pageNumber);
                }
            }
        }
        return index;
    }

    public static void writeIndexToFile(Map<String, Set<Integer>> index, String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Map.Entry<String, Set<Integer>> entry : index.entrySet()) {
            String word = entry.getKey();
            Set<Integer> pages = entry.getValue();
            writer.write(word + " : " + String.join(",", pages.stream().map(String::valueOf).sorted().toArray(String[]::new)));
            writer.newLine();
        }
        writer.close();
    }
}
