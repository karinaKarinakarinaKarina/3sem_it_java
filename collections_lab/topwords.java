package collections_lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class topwords {
    public static void main(String[] args) {
        File file = new File("collections_lab/haha.txt");
        Map<String, Integer> wordCount = new HashMap<>();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-zA-Z]", "");
                if (!word.isEmpty()) {
                    if (wordCount.containsKey(word)) {
                        wordCount.put(word, wordCount.get(word) + 1);
                    } else {
                        wordCount.put(word, 1);
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
        sortedWords.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        System.out.println("Top 10 most frequent words:");
        for (int i = 0; i < 10 && i < sortedWords.size(); i++) {
            System.out.println(sortedWords.get(i).getKey() + ": " + sortedWords.get(i).getValue() + " times");
        }
    }
}