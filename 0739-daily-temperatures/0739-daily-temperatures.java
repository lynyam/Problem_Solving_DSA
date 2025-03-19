class Solution {

    public int[] dailyTemperatures(int[] temperature) {
        //build a monotonic stack
        List<Integer> stack = new ArrayList<>();
        int n = temperature.length;
        int[] result = new int[n];


        for (int i  = 0; i < n; i++) {
            int temp = temperature[i];
            // assure monotonic stack
            while (!stack.isEmpty() && temp > temperature[stack.get(stack.size() - 1)]) {
                result[stack.get(stack.size() - 1)] = i - stack.get(stack.size() - 1);
                stack.remove(stack.size() - 1);
            }
            stack.add(i);
        }
        return(result);
    }
}
