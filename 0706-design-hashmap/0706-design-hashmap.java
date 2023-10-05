class MyHashMap {
    private int[] vec;
    private int sz;

    public MyHashMap() {
        sz = 1000001;
        vec = new int[sz];
        Arrays.fill(vec, -1);
    }

    public void put(int key, int value) { //O(1)
        vec[key] = value;
    }

    public int get(int key) { //O(1)
        return vec[key];
    }

    public void remove(int key) { //O(1)
        vec[key] = -1;
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */