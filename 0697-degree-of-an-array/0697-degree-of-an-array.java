import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            count.put(x, count.getOrDefault(x, 0) + 1);
            left.putIfAbsent(x, i);
            right.put(x, i);
        }
        
        int degree = 0;
        for (int freq : count.values()) {
            degree = Math.max(degree, freq);
        }
        
        int minLength = nums.length;
        
        for (int x : count.keySet()) {
            if (count.get(x) == degree) {
                int length = right.get(x) - left.get(x) + 1;
                minLength = Math.min(minLength, length);
            }
        }
        
        return minLength;
    }
}