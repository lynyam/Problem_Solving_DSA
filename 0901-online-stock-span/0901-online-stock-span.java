class StockSpanner {
    List<int[]> stack;
    public StockSpanner() {
        stack = new ArrayList<>();
    }
    
    public int next(int price) {
        int answer = 1;
        while (stack.size() > 0 && stack.get(stack.size() - 1)[0] <= price) {
            answer += stack.remove(stack.size() - 1)[1];
        }
        stack.add(new int[]{price, answer});
        return answer;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */