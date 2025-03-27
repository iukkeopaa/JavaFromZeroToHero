package DaChangBrushUpClass.Class2;

import java.util.HashMap;

class HashTableWithSetAll {
    private HashMap<Integer, Integer> map;
    private int setAllValue;
    private boolean hasSetAll;

    public HashTableWithSetAll() {
        map = new HashMap<>();
        hasSetAll = false;
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            if (hasSetAll) {
                return Math.max(map.get(key), setAllValue);
            }
            return map.get(key);
        }
        return hasSetAll ? setAllValue : -1;
    }

    public void setAll(int value) {
        setAllValue = value;
        hasSetAll = true;
    }
}    