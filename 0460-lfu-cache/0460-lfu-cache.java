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
    
    public int get(int key) {
        int value  = -1;
        if (store.containsKey(key)) {
            int[] data = store.get(key);
            value = data[0];
            LinkedHashSet<Integer> set = frequency.get(data[1] - 1);
            set.remove(key);
            if (frequency.size() == data[1])
                frequency.add(new LinkedHashSet<Integer>());
            frequency.get(data[1]).add(key);
            if (minimumFreq == data[1] && set.isEmpty())
                minimumFreq = data[1] + 1;
            data[1] += 1;
            store.put(key, data);
        }
        return (value);
    }
    
    public void put(int key, int value) {
        if (capacity <= 0)
            return ;
        if (!store.containsKey(key)) {
            if (size == capacity) {
                LinkedHashSet<Integer> set = frequency.get(minimumFreq - 1);
                int nkey = set.iterator().next();
                set.remove(nkey);
                store.remove(nkey);
                size--;
                if (set.isEmpty())
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
                store.put(key, new int[] {value, store.get(key)[1]});
        }
	} 		
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */