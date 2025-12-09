package ArrayManipulatationHashing;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        String word1 = "brag";
        String word2 = "grab";
        System.out.println(efficientSolution(word1, word2));
    }

    // Brute Force: charArray + sorting
    // time complexity = O(nlog(n)) space complexity = O(1)
    public static boolean bruteForce(String word1, String word2){
        char[] word1Array = word1.toCharArray();
        char[] word2Array = word2.toCharArray();

        Arrays.sort(word1Array);
        Arrays.sort(word2Array);

        if (word1Array.length != word2Array.length) return false;

        for (int i = 0; i < word1Array.length; i++) {
            if (word1Array[i] != word2Array[i]) return false;
        }
        return true;
    }

    // alphabet array
    // time complexity = O(n) space complexity = O(1)
    public static boolean efficientSolution(String word1, String word2){
        if (word1.length() != word2.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : word1.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (char c : word2.toCharArray()){
            if (!map.containsKey(c)) return false;

            map.put(c, map.get(c) - 1);
            if (map.get(c) < 0) return false;
        }

        return true;
    }
}
