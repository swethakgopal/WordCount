package src;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class WordCounter {

	// read input and store to dictionary based on values
	private static Map<String, Integer> countWords(File inputFile) throws IOException{
		// create a hashmap
		Map<String, Integer> countedWords = new HashMap<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
			String line;
			
			while ((line = reader.readLine()) != null) {
				String[] words = line.split("\s+"); // splitting by whitespace in regex
				
				for (String word : words) {
					word = word.replaceAll("[^a-zA-Z]", "").toLowerCase(); // convert all to lowercase and removes punctuation
					
					if (!word.isEmpty()) {
						countedWords.put(word, countedWords.getOrDefault(word, 0)+1); // incrementing count value if key exists else create key
					}
				}
			}
		}
		return countedWords;
	}

	// sort the hashmap in descending order
	private static void sortHashmapAndPrint(Map<String, Integer> map) {
		map.entrySet()
		.stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEach((set) -> System.out.println(set.getKey() + ": " + set.getValue()));
	}
	public static void main(String[] args) {
		
		// if more than 1 or less than 1 arguement exists which program is run
		if (args.length != 1) {
            System.out.println("Usage: java WordCounter <file_path>");
            return;
        }

        String filePath = args[0];
        File file = new File(filePath);

        // Handle Invalid file
        if  (!file.exists() || !file.isFile()) {
            System.out.println("Invalid file");
            return;
        }

        try {
        	Map<String, Integer> wordCount = countWords(file);
			sortHashmapAndPrint(wordCount);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
	}
	
}
