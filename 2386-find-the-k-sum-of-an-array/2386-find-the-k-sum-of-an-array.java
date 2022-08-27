import java.util.*;

public class Solution {
    public long kSum(int[] nums, int k) {
        long sum = 0, result = 0;
        Queue<Map.Entry<Long, Integer>> pq = new PriorityQueue<>((a, b) -> Long.compare(b.getKey(), a.getKey()));
        for(int i = 0; i < nums.length; i++) sum += Math.max(0, nums[i]);
        for(int i = 0; i < nums.length; i++) nums[i] = Math.abs(nums[i]);
        Arrays.sort(nums);

        result = sum;
        pq.offer(new AbstractMap.SimpleEntry<>(sum - nums[0], 0));
        while(--k > 0) {
            Map.Entry<Long, Integer> pair = pq.poll();
            result = pair.getKey();
            int index = pair.getValue();
            if(index < nums.length - 1) {
                pq.offer(new AbstractMap.SimpleEntry<>(result + nums[index] - nums[index + 1], index + 1));
                pq.offer(new AbstractMap.SimpleEntry<>(result - nums[index + 1], index + 1));
            }
        }
        return result;
    }
}