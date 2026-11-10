class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left, right, n, result, curr;
        n = nums.length;
        left = right = result = curr = 0;

        while (right < n) {
            if (!set.contains(nums[right])) {
                set.add(nums[right]);
                curr += nums[right];
            } else {
                while (nums[left] != nums[right]) {
                    set.remove(nums[left]);
                    curr -= nums[left];
                    left++;
                }
                left++;
            }

            result = Math.max(result, curr);
            right++;
        }
        return result;
    }
}
/*
for this type of problem, naive solution when the talk about subarray id:
    - list all the subarray in total partial sum of suite 1 .. n = n(n+1)) / 2
        - i could demonstrate if needed: basycally we have n sub of 1, n-2 sub of 2 ... 1 sub of n
        - for each of them check if it is valid array or not and search best valid array
        - we have in best scenariio 0(n3)
    
    - I think better approach will avoid list all the sub, ans when sub is invalidate directly 
    reduce the array utile have something valid,
    - Also for the check avoid walk through by linear way instead i could combine with set
    - the told us that valid = exactly one for each sequence. -. i could use set for this one
    - better approach could be use array to avoid hash with boundarie min and mac of array. 
    - depend for scerario it could be interesing or or not
*/