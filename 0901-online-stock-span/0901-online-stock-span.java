class Stock {
    int price;
    int days;
    public Stock(int price, int days) {
        this.price = price;
        this.days = days;
    }
}

class StockSpanner {
    List<Stock> store;   
   // List<Integer> consecutive;   
    public StockSpanner() {
        store = new ArrayList<>();
       // consecutive = new ArrayList<>();
    }
    
    public int next(int price) {
        int day = 1;
        while (!store.isEmpty() && store.get(store.size() - 1).price < price) {
            Stock stock = store.remove(store.size() - 1);
            day += stock.days;
        }
        store.add(new Stock(price, day));
        /*int n = store.size();
        int i = n - 1;
        int count = 0;
        while (i >= 0) {
            if (store.get(i) > price) {
                break ;
            }
            count += i > 1 ? consecutive.get(i - 1) : 1;
            i -= i > 1 ? consecutive.get(i - 1) : 1;
        }
        consecutive.add(count);*/
        return (day);
    }
}
/**
    1 2 3 4 5 6
    [80, 60] 


   store  List<Integer>
    consec List<Integer>




 */

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */