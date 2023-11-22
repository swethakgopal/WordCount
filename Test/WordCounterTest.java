package Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import src.WordCounter;
import static org.junit.jupiter.api.Assertions.*;

// Unit Test class to validate test cases from WordCounter.java
public class WordCounterTest {

    public File createTestFile(String text) throws IOException {
        // Create a temporary file with repeating words
        File inputFile = File.createTempFile("inputFile", ".txt");

        // Writing repeating words to the file
        FileWriter fileWriter = new FileWriter(inputFile);
        fileWriter.write(text);
        fileWriter.close();

        return inputFile;
    }

    @Test
    public void EmptyFileTest() throws IOException {
        // Creating a temporary empty file for testing
        File emptyFile = createTestFile("") ;

        // Calling the count words functionality with the empty file
        Map<String, Integer> wordCount = WordCounter.countWords(emptyFile);

        // Expected output: An empty word count map
        assertEquals(0, wordCount.size(), "Empty file should produce an empty word count map");
    }

    @Test
    public void punctuationAndSpecialCharactersTest() throws IOException {
        // Create a temporary file with words containing punctuation and special characters
        File fileWithSpecialCharacters = createTestFile("Hello!! This is a test, and this document contains words " +
                "with characters and punctuation and random symbols: *&^%$#@");

        // Test the word counting functionality with the file containing special characters
        Map<String, Integer> wordCount = WordCounter.countWords(fileWithSpecialCharacters);

        // Expected output: count words without considering punctuation and special characters
        assertEquals(14, wordCount.size(), "Should have word count without considering punctuation");

    }

    @Test
    public void repeatingWordsTest() throws IOException {
        // Create a temporary file with repeating words
        File fileWithRepeatingWords = createTestFile("Every person had a star, every star had a friend, and for " +
                "every person carrying a star there was someone else who reflected it, and everyone carried this " +
                "reflection like a secret confidante in the heart.");

        // Test the word counting functionality with the file containing repeating words
        Map<String, Integer> wordCount = WordCounter.countWords(fileWithRepeatingWords);

        assertEquals(3, wordCount.get("every"), "Count of 'star' should be 3");
        assertEquals(2, wordCount.get("person"), "Count of 'this' should be 2");
        assertEquals(3, wordCount.get("star"), "Count of 'and' should be 3");
    }

    @Test
    public void descendingOrderTest(){

        // Creating a hashmap with dummy values
        Map<String, Integer> testingMap = new HashMap<>();
        testingMap.put("Alpha", 2);
        testingMap.put("Beta", 6);
        testingMap.put("Cancel", 4);

        // Creating a hashmap to compare the sorted values
        LinkedHashMap<String, Integer> sortedList = WordCounter.sortHashmapAndPrint(testingMap);

        assertEquals("Beta", sortedList.entrySet().stream().findFirst().get().getKey());
        assertEquals(2, sortedList.get("Alpha"));
    }


}