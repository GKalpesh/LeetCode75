package ArrayManipulatationHashing;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(maxSubArray(arr));
    }

    // Kadane's Algorithm
    // time complexity = O(n) space complexity = O(n)
    public static int maxSubArray(int[] nums) {
        int first_element = nums[0];
        int result = first_element;
        int currentSum = first_element;
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            result = Math.max(result, currentSum);
        }
        return result;
    }
}
