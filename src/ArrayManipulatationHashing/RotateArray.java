package ArrayManipulatationHashing;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
    }

    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        if (length < k) k = length % k;
        rotateHelper(nums, 0, length - 1);
        rotateHelper(nums, 0, k - 1);
        rotateHelper(nums, length - k - 1, length - 1);

        System.out.println(Arrays.toString(nums));
    }

    private static void rotateHelper(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
