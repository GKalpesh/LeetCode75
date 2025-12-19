package ArrayManipulatationHashing;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int length = nums.length;
        int maxCount = 0;
//        for (int i = 0; i < length; i++) {
//            int currentCount = 0;
//            while (i < length && nums[i] == 1) {
//                currentCount++;
//                i++;
//            }
//            maxCount = Math.max(currentCount, maxCount);
//        }

        int currentCount = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 1) currentCount++;
            else currentCount = 0;
            if (currentCount > maxCount) maxCount = currentCount;
        }
        return maxCount;
    }
}
