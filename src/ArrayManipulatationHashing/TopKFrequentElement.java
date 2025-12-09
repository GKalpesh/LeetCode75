package ArrayManipulatationHashing;

import java.util.*;

public class TopKFrequentElement {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(withHashMap(nums, k)));
    }

    private static int[] withHashMap(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (int key : map.keySet()){
            priorityQueue.add(key);
            if (priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!priorityQueue.isEmpty())
            result.add(priorityQueue.poll());

        Collections.reverse(result);
        int[] rs = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            rs[i] = result.get(i);
        }
        return rs;
    }
}
