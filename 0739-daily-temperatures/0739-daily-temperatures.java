class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        List<Integer> stack = new ArrayList<>();
        int n = temperatures.length;
        int[] answer = new int[n];
        int i = 0;

        while (i < n) {
            while (stack.size() != 0 && temperatures[stack.get(stack.size() - 1)] < 
                temperatures[i]) {
                    int index = stack.get(stack.size() - 1);
                    stack.remove(stack.size() - 1);
                    answer[index] = i - index;
            }
            stack.add(i);
            i++;
        }
        return (answer);
    }
}