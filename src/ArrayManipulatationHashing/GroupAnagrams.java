package ArrayManipulatationHashing;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] stringArray = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(withMapWithoutSort(stringArray));
    }

    // with hashmap with sorting
    // time complexity = O(n * klog(k)) space complexity = O(n)
    public static List<List<String>> withHashMap(String[] stringArray){
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < stringArray.length; i++) {
            String currentString = stringArray[i];
            char[] currentStringToChar = currentString.toCharArray();
            Arrays.sort(currentStringToChar);
            String sortedStringKey = String.valueOf(currentStringToChar);
            if (map.containsKey(sortedStringKey))
                map.get(sortedStringKey).add(currentString);
            else {
                map.put(sortedStringKey, new ArrayList<>());
                map.get(sortedStringKey).add(currentString);
            }
        }
        for (Map.Entry<String, List<String>> mapElement: map.entrySet()){
            result.add(mapElement.getValue());
        }
        return result;
    }

    // with hashmap without sorting
    // time complexity = O(n * k) time complexity = O(n * k)
    public static List<List<String>> withMapWithoutSort(String[] stringArray){
        List<List<String>> result = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < stringArray.length; i++) {
            String currentString = stringArray[i];
            String frequencyString = frequencyString(currentString);
            if (map.containsKey(frequencyString))
                map.get(frequencyString).add(currentString);
            else {
                map.put(frequencyString, new ArrayList<>());
                map.get(frequencyString).add(currentString);
            }
        }
        for (Map.Entry<String, List<String>> mapElement: map.entrySet()){
            result.add(mapElement.getValue());
        }
        return result;
    }

    private static String frequencyString(String str){
        int[] intArray = new int[26];
        for (char c : str.toCharArray())
            intArray[c - 'a']++;

        StringBuilder frequencyPatterString = new StringBuilder();
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] > 0){
                char letter = (char) (i + 'a');
                frequencyPatterString.append(letter).append(intArray[i]);
            }
        }
        return new String(frequencyPatterString);
    }

}
