public class Bucket {
	int max;
	int min;
	public Bucket() {
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
    }
} 
class Solution {
    public int maximumGap(int[] nums) {
		int len = nums.length;
        if (len <= 1)
            return (0);
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for (int num : nums) {
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		int bucketSize = Math.max(1, (max - min) / (len - 1));
		int nbrBucket = (max - min) / bucketSize + 1;
		Bucket[] buckets = new Bucket[nbrBucket];
		for (int num : nums) {
			int indexBucket = (num - min) / bucketSize;
            if (buckets[indexBucket] == null)
                buckets[indexBucket] = new Bucket();
			buckets[indexBucket].min = Math.min(num, buckets[indexBucket].min);
            buckets[indexBucket].max = Math.max(num, buckets[indexBucket].max);
		}
		int i = 0;
		int maxGap = 0;
		while (i < nbrBucket) {
			int j = i + 1;
			while (j < nbrBucket) {
				if (buckets[j] != null) {
					maxGap = Math.max(maxGap, buckets[j].min - buckets[i].max);
                    break ;
				}
				j++;
			}
			i = j;
		}
		return (maxGap);
}

}