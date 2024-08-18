class StockSpanner {
    List<Integer> store;   
    public StockSpanner() {
        store = new ArrayList<>();
    }
    
    public int next(int price) {
        store.add(price);
        int n = store.size();
        int i = n - 1;
        int count = 0;
        while (i >= 0) {
            if (store.get(i) > price) {
                break ;
            }
            count++;
            i--;
        }
        return (count);
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */