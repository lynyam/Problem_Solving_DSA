class Temp {
    int temp;
    int day;
    public Temp(int temp, int day) {
        this.temp = temp;
        this.day = day; 
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        List<Temp> stack = new ArrayList<>();
        int i = 0;

        while (i < n) {
            int temp = temperatures[i];
            while (stack.size() > 0 && stack.get(stack.size() - 1).temp < temp) {
                ans[stack.get(stack.size() - 1).day] = i - stack.get(stack.size() - 1).day;
                stack.remove(stack.size() - 1);
            }
            stack.add(new Temp(temp, i));
            i++;
        }
        return (ans);
    }
}
// 8 3 4 1 7 9
// 5 1 2 1 1 0
// 8,0 7,4 9,5
// 5 1 2 1 1 0