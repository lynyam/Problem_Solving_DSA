class LFUCache {
        Map<Integer, int[]> store;//store(k, v) k = key, v = {value, freq}
        List<LinkedHashSet<Integer>> frequency;//frequency(i) i = freq - 1
        int capacity;
        int minimumFreq = Integer.MAX_VALUE;
        int size;
        public LFUCache(int capacity) {
            this.capacity = capacity;
            store = new HashMap<>();
            frequency = new ArrayList<>();
        }
    
    public int get(int key) {
        int[] data = store.get(key);
        if (data == null)
            return (-1);
        LinkedHashSet<Integer> set = frequency.get(data[1] - 1);
        set.remove(key);
        if (frequency.size() == data[1])
            frequency.add(new LinkedHashSet<Integer>());
        frequency.get(data[1]).add(key);
        if (minimumFreq == data[1] && set.isEmpty())
            minimumFreq = data[1] + 1;
        data[1] += 1;
        store.put(key, data);
        return (data[0]);
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
			store.put(key, new int[]{value, 1});
			if (frequency.size() == 0)
				frequency.add(new LinkedHashSet<Integer>());
			frequency.get(0).add(key);
			minimumFreq = 1;
            size++;
		} else {
                get(key);
                int[] data = store.get(key);
                data[0] = value;
        }
	} 		
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */