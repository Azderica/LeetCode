import java.util.SortedMap;

class LFUCache {
    
    class Entry {
        int key, value, accessTime, count;
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
            this.count = 1;
            this.accessTime = ++systemTime;
        }
    }

    int capacity, systemTime = 0;
    Map<Integer, Entry> cacheMap;
    // sorting by count, accessTime
    SortedMap<Integer, SortedMap<Integer, Entry>> cacheSorting;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.cacheSorting = new TreeMap<>();
    }
    
    public int get(int key) {
        if(cacheMap.containsKey(key)) {
            Entry entry = cacheMap.get(key);
            removeEntry(entry);
            ++entry.count;
            entry.accessTime = ++systemTime;
            addEntry(entry);
            return entry.value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;

        Entry entry = cacheMap.get(key);
        if(entry == null) {
            entry = new Entry(key, value);
            if(cacheMap.size() == capacity) {
                SortedMap<Integer, Entry> leastUsedEntries = cacheSorting.get(cacheSorting.firstKey());
                Entry leastUsedEntry = leastUsedEntries.get(leastUsedEntries.firstKey());
                cacheMap.remove(leastUsedEntry.key);
                removeEntry(leastUsedEntry);;
            }
            addEntry(entry);
            cacheMap.put(key, entry);
        } else {
            entry.value = value;
            removeEntry(entry);
            ++entry.count;
            entry.accessTime = ++systemTime;
            addEntry(entry);
        }
    }

    private void removeEntry(Entry entry) {
        cacheSorting.get(entry.count).remove(entry.accessTime);
        if(cacheSorting.get(entry.count).isEmpty()) cacheSorting.remove(entry.count);
    }

    private void addEntry(Entry entry) {
        cacheSorting.putIfAbsent(entry.count, new TreeMap<>());
        cacheSorting.get(entry.count).put(entry.accessTime, entry);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */