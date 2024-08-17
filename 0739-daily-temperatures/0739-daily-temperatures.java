class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int i = 0;
        int n = temperatures.length;
        List<Integer> stack = new ArrayList<>();
        int[] answer = new int[n];

        while (i < n) {
            int t = temperatures[i];
            int days = 0;
            while (stack.size() > 0 && temperatures[stack.get(stack.size() - 1)] < t) {
                int curr = stack.remove(stack.size() - 1);
                answer[curr] = i - curr;
            }
            stack.add(i);
            i++;
        }
        return (answer);
    }
}