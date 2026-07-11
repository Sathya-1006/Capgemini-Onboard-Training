package Day3;


import java.util.*;

public class MaxOccurringChar {
	public static void main(String[] args) {
        String str = "programming";

        HashMap<Character, Integer> map = new HashMap<>();

        // Count frequency of each character
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        char maxChar = '\0';
        int maxCount = 0;

        // Find character with maximum frequency
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxChar = entry.getKey();
            }
        }

        System.out.println("Maximum occurring character: " + maxChar);
        System.out.println("Frequency: " + maxCount);
    }
}
