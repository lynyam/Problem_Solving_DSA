class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        counts.put(0, 1);
        int curr = 0;
        int result = 0;

        for (int num : nums) {
            curr += num;
            result += counts.getOrDefault(curr - k, 0);
            counts.put(curr, counts.getOrDefault(curr, 0) + 1);
        }
        return result;
    }
    // left, right
    // sum(left, right) = nums[left] + nums[left + 1] + ... + nums[right]
    // let call prefix of value of array from 0 to this index (include).
    // prefix(2) = 0, 1, 2
    // prefix(3) = 0, 1, 2, 3
    // prefixSum will be sum of all prefix
    // prefixSum(2) = nums[0] + nums[1] + nums[2]
    // from prefixSum we can deduce sum of subarray
    //imagine subArray index [1, 2]
    // sum(1, 2) = nums[1] + nums[2]
    //           = sum(0, 2) - sum(0)
    //           = nums[0] + nums[1] + nums[2] - nums[0]
    //           = nums[1] - nums[2]
    //sum(0, 2) - sum(0) = prefixSum(2) - prefixSum(0);
    //left = 1, right = 2
    // sum(left, right) = pefixSum(right) - prefixSum(left -1) => with left > 0
    //or                = prefixSum(right) - prefixSum(left) + nums[left]
    //now let say curr give us prefixSum(0, right),
    //to search all subarray btwn 0, right, it mean left is 0 ..right
    // that sum(left, right) = k we can do 
    //.     sum(0, right) - k = sum(left, right)
    //      curr - k = sum(left, right);
    //with this i could store in count all precendent prefixSum ie all curr
    // so if i could found inside counts prev curr/prefixSum that satisfied
    //curr - k it mean from 0 to this prev position we already found 
    // something that satisfied the condition that we have here sum(left, right) = pefixSum(right) - prefixSum(left -1) => with left > 0
    // to trap if curr - k = 0 it mean this subarray start by 0 so we need 
    // to initialise empty subarray [] sum in count by 0
    // now because our array could have neagative value
    // 1 1 -1 3 => [1, 2, 1, 4] if k = 1 => [1] [1 1 -1]
    // for that we have to add a count for all the store 

}