package ArrayManipulatationHashing;

import java.util.Arrays;

public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelfEfficient(nums)));
    }


    // Brute Force Approach
    // time complexity = O(n^2) space complexity = O(1)
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) product *= nums[j];
            }
            result[i] = product;
        }
        return result;
    }

    // efficient
    // time complexity = O(n) space complexity = O(1)
    public static int[] productExceptSelfEfficient(int[] nums) {
        int arrLength = nums.length;
        int[] leftArr = new int[arrLength];
        int[] rightArr = new int[arrLength];
        int[] result = new int[arrLength];

        leftArr[0] = 1;
        rightArr[arrLength - 1] = 1;

        for (int i = 1; i < arrLength; i++) {
            leftArr[i] = leftArr[i - 1] * nums[i - 1];
        }

        for (int i = arrLength - 2; i > 0 ; i--) {
            rightArr[i] = rightArr[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < arrLength; i++) {
            result[i] = leftArr[i] * rightArr[i];
        }

        return result;
    }

}
