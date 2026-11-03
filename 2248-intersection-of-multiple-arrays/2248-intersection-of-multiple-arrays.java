class Solution {
    public List<Integer> intersection(int[][] nums) {
        int n = nums.length;
        //System.out.println((m));
        int i = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        
        while (i < n) {
            int j = 0;
            while (j < nums[i].length) {
                //System.out.println(nums[i][j]);
                counts.put(nums[i][j], counts.getOrDefault(nums[i][j], 0) + 1);
                j++;
            }
            i++;
        }

        List<Integer> ans = new ArrayList<>();
        for (int key : counts.keySet()) {
            if (counts.get(key).equals(n))
                ans.add(key);
        }
        Collections.sort(ans);
        return ans;
    }
}