class Stock {
    int price;
    int days;
    public Stock(int price, int day) {
        this.price = price;
        this.days = day;
    }
}

class StockSpanner {
    Stack<Stock> stack;

    public StockSpanner() {
        stack = new Stack<Stock>();
    }
    
    public int next(int price) {
        int countDay = 1;
        while (!stack.empty() && stack.peek().price <= price) {
            Stock old = stack.pop();
            countDay = countDay + old.days;
        }
        stack.push(new Stock(price, countDay));
        return (countDay);
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */