import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length < 2 || indexDiff < 1 || valueDiff < 0) {
            return false;
        }

        Map<Long, Long> buckets = new HashMap<>();
        long bucketSize = (long) valueDiff + 1L;

        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            long bucketId = getBucketId(num, bucketSize);

            if (buckets.containsKey(bucketId)) {
                return true;
            }

            if (buckets.containsKey(bucketId - 1L) && Math.abs(num - buckets.get(bucketId - 1L)) <= valueDiff) {
                return true;
            }

            if (buckets.containsKey(bucketId + 1L) && Math.abs(num - buckets.get(bucketId + 1L)) <= valueDiff) {
                return true;
            }

            buckets.put(bucketId, num);

            if (i >= indexDiff) {
                long oldNum = nums[i - indexDiff];
                long oldBucketId = getBucketId(oldNum, bucketSize);
                buckets.remove(oldBucketId);
            }
        }

        return false;
    }

    private long getBucketId(long num, long bucketSize) {
        return num >= 0 ? num / bucketSize : (num + 1L) / bucketSize - 1L;
    }
}