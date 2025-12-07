package ArrayManipulatationHashing;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] arraySet = new int[]{8, 5, 4, 15, 12, 7, 2};
        int target = 11;
        System.out.println(Arrays.toString(bruteForce(arraySet, target)));
//        System.out.println(Arrays.toString(twoPointer(arraySet, target)));
        System.out.println(Arrays.toString(withHashMap(arraySet, target)));
    }


    // Brute Force
    // time complexity = O(n^2) Space complexity = O(1)
    public static int[] bruteForce(int[] arraySet, int target){
        for (int i = 0; i < arraySet.length; i++) {
            for (int j = 1; j < arraySet.length; j++) {
                if (arraySet[i] + arraySet[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }


    // Sorting and Two Pointer
    // time complexity = O(nlog(n)) space complexity = O(1)
    public static int[] twoPointer(int[] arraySet, int target){
        Arrays.sort(arraySet);
        int left = 0, right = arraySet.length - 1;
        while (left < right){
            if (arraySet[left] + arraySet[right] == target){
                return new int[]{left, right};
            } else if (arraySet[left] + arraySet[right] > target) {
                right--;
            } else if (arraySet[left] + arraySet[right] < target) {
                left++;
            }
        }
        return new int[]{0, 0};
    }

    // With HashMap
    // time complexity = O(n) space complexity = O(n)
    public static int[] withHashMap(int[] arraySet, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arraySet.length; i++) {
            int diff = target - arraySet[i];
            if (map.containsKey(diff)) return new int[]{map.get(diff), i};
            else map.put(arraySet[i], i);
        }
        return new int[]{0, 0};
    }
}
