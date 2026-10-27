class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) {
            return 0;
        }
        
        int totalPoisonedTime = 0;
        
        for (int i = 0; i < timeSeries.length - 1; i++) {
            int diff = timeSeries[i + 1] - timeSeries[i];
            totalPoisonedTime += Math.min(diff, duration);
        }
        
        totalPoisonedTime += duration;
        
        return totalPoisonedTime;
    }
}