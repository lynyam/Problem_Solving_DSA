class LFUCache {
        Map<Integer, int[]> store;
        List<LinkedHashSet<Integer>> frequency;
        int capacity;
        int minimumFreq = Integer.MAX_VALUE;
        int size;
        public LFUCache(int capacity) {
            this.capacity = capacity;
            store = new HashMap<>();
            frequency = new ArrayList<>();
        }
    
    public int get(int key) {//[1]
        int value  = -1;
        if (store.containsKey(key)) {
            value = store.get(key)[0];//1
            int freq = store.get(key)[1];//1
            frequency.get(freq - 1).remove(key);//{{2}}
            if (frequency.size() == freq)
                frequency.add(new LinkedHashSet<Integer>());//{{2}->{}}
            frequency.get(freq).add(key);//{{2}->{1}}
            //manage minimumFreq
            if (minimumFreq == freq && frequency.get(freq - 1).size() == 0)
                minimumFreq = freq + 1;
            store.put(key, new int[] {value, freq + 1});//{1:[1, 2], 2:[2, 1]}
        }
        return (value);
    }
    
    public void put(int key, int value) {//[1,1],[2,2],[1],[3,3]
        if (capacity <= 0)//2
            return ;
        if (!store.containsKey(key)) {
            if (size == capacity) {
                int nkey = frequency.get(minimumFreq - 1).iterator().next();
                frequency.get(minimumFreq - 1).remove(nkey);
                store.remove(nkey);
                size--;
                if (frequency.get(minimumFreq - 1).size() == 0)
                    minimumFreq = Integer.MAX_VALUE;
            }
			store.put(key, new int[]{value, 1});//{1:[1, 2], 2:[2, 1]}
			if (frequency.size() == 0) //0
				frequency.add(new LinkedHashSet<Integer>());//{}
			frequency.get(0).add(key);//{{2}->{1}}
			minimumFreq = 1;//1
            size++;
		} else {
                get(key);
                store.put(key, new int[] {value, store.get(key)[1]++});
        }
	} 		
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */