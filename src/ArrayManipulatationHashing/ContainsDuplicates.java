package ArrayManipulatationHashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {

    public static void main(String[] args) {
        int[] arraySet = new int[]{1, 2, 3, 1};
        System.out.println(withHashSet(arraySet));
    }

    // Brute Force
    // time complexity = O(n^2) space complexity = O(1)
    public static boolean bruteForce(int[] arraySet){
        for (int i = 0; i < arraySet.length; i++) {
            for (int j = i + 1; j < arraySet.length; j++) {
                if (arraySet[i] == arraySet[j]) return true;
            }
        }
        return false;
    }

    // Sorting
    // time complexity = O(logn) space complexity = O(1)
    public static boolean sorting(int[] arraySet){
        Arrays.sort(arraySet);
        for (int i = 0; i < arraySet.length - 1; i++) {
            if (arraySet[i] == arraySet[i + 1]) return true;
        }
        return false;
    }

    // hashset
    // time complexity = O(n) space complexity = O(n)
    public static boolean withHashSet(int[] arraySet){
        Set<Integer> set = new HashSet<>();
        for (int currentValue : arraySet){
            if (set.contains(currentValue)) return true;
            set.add(currentValue);
        }
        return false;
    }

}
