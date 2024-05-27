package Assignment;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	        try {
	            Set<String> excludeWords = ExcludeWordsReaderDemo.readExcludeWords("Resource/exclude-words.txt");
	            Map<Integer, String> pages = new HashMap<>();
	            pages.put(1, PageReaderDemo.readPageMethod("Resource/Page1.txt"));
	            pages.put(2, PageReaderDemo.readPageMethod("Resource/Page2.txt"));
	            pages.put(3, PageReaderDemo.readPageMethod("Resource/Page3.txt"));
	            Map<String, Set<Integer>> index = IndexerDemo.processPages(pages, excludeWords);
	            IndexerDemo.writeIndexToFile(index, "Resource/index.txt");
	            System.out.println("Index created successfully in Resource/index.txt");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

}
