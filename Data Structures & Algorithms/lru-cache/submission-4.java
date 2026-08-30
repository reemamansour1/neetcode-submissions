class Entry{
    int key;
    int value;
    public Entry(int key, int value){
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    ArrayList<Entry> cache;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
       cache = new ArrayList<>(capacity);

    }
    public int get(int key) {
        for(int i = 0; i<cache.size(); i++){
            if(cache.get(i).key == key){
                // does that automatically moves the initial first element to the next index if we move this element to index 0?
                Entry entry = cache.remove(i);
                // does cache.remove(i) return the removed key?
                cache.add(0, entry);
                return entry.value;
            }
        }
        return -1; 
    }
    
    public void put(int key, int value) {
        for(int i = 0; i<cache.size(); i++){
            if(cache.get(i).key == key){
                Entry entry = cache.remove(i);
                entry.value = value;
                cache.add(0, entry);
                return;
            }}
            if(cache.size() == capacity){
                    cache.remove(cache.size() - 1);
                    // why do i need to remove cache.add(0, new Entry(key, value)); from inside the if?
                    // because we want them to add the new key wethear there is space or not.
                }
                cache.add(0, new Entry(key, value));
            }
    }

