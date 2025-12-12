package ArrayManipulatationHashing;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {-2};
        System.out.println(maxProduct(nums));
    }


    public static int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int leftProduct = 1;
        int rightProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            leftProduct = leftProduct * nums[i];
            rightProduct = rightProduct * nums[nums.length - 1 - i];

            maxProduct = Math.max(maxProduct, Math.max(leftProduct, rightProduct));
        }
        return maxProduct;
    }
}
