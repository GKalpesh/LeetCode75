package ArrayManipulatationHashing;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = new int[]{1,0,1,2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxLen = 0;

        // Try to treat each number as a potential start of a sequence
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];

            // 1) Check if 'start' has a predecessor (start - 1)
            // If yes, then this is NOT the beginning of a sequence, so skip it
            boolean hasPrev = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == start - 1) {
                    hasPrev = true;
                    break;  // no need to look further
                }
            }

            if (hasPrev) {
                continue;  // not a start, go to next i
            }

            // 2) Now expand forward: start, start+1, start+2, ...
            int currentLen = 1;
            int currentValue = start;

            while (true) {
                int nextValue = currentValue + 1;
                boolean foundNext = false;

                // Scan array to see if nextValue exists
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == nextValue) {
                        foundNext = true;
                        break;
                    }
                }

                if (foundNext) {
                    currentLen++;
                    currentValue = nextValue;  // move forward in the sequence
                } else {
                    break;  // chain ended
                }
            }

            // 3) Update max length
            if (currentLen > maxLen) {
                maxLen = currentLen;
            }
        }

        return maxLen;
    }
}
