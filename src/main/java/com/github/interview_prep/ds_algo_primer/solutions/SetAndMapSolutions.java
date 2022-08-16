package com.github.interview_prep.ds_algo_primer.solutions;
/*
 *   Title: SetAndMapSolutions
 *
 *   This file contains the solutions for the Set and Map exercises in
 *   the DS & Algos Primer. If you have not already attempted these exercises,
 *   we highly recommend you complete them before reviewing the solutions here.
 *
 *   Execution: javac SetAndMapSolutions.java && java -ea SetAndMapSolutions
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SetAndMapSolutions {

    private static final Logger LOGGER = Logger.getLogger(SetAndMapSolutions.class.getName());

    /*
     * Exercise 1.1: Implement a HashSet
     */
    public static class MyHashSet {

        // We'll use an array to store each of our buckets
        private List<String>[] data;
        private int size;

        /*
         * Constructor
         *
         * Time Complexity: O(n)
         * Space Complexity: O(1)
         */
        public MyHashSet(int capacity) {
            // Initialize all of the empty buckets
            data = new LinkedList[capacity];
            for (int i = 0; i < capacity; i++) {
                data[i] = new LinkedList<String>();
            }
        }

        /*
         * Add a value to the set
         *
         * Time Complexity: O(size(set) + len(val))
         * Space Complexity: O(1)
         */
        public void add(String val) {
            // Find the bucket index
            int idx = val.hashCode() % data.length;

            // If the value isn't in the bucket, add it to the bucket
            if (!data[idx].contains(val)) {
                data[idx].add(val);
                size++;
            }
        }

        /*
         * Does the set contain val?
         *
         * Time Complexity: O(size(set) + len(val))
         * Space Complexity: O(1)
         */
        public boolean contains(String val) {
            // Find the bucket and see if it contains the desired value
            int idx = val.hashCode() % data.length;
            return data[idx].contains(val);
        }

        /*
         * Remove value from the set
         *
         * Time Complexity: O(size(set) + len(val))
         * Space Complexity: O(1)
         */
        public void remove(String val) {
            // Find the bucket and if it contains the value, remove it
            int idx = val.hashCode() % data.length;
            if (data[idx].contains(val)) {
                data[idx].remove(val);
                size--;
            }
        }

        /*
         * Convert the set into a list
         *
         * Time Complexity: O(n * average value length)
         * Space Complexity: O(1)
         */
        public List<String> toList() {
            // Just iterate over all the buckets and combine them into a list
            List<String> result = new LinkedList<>();
            for (List<String> l : data) {
                result.addAll(l);
            }

            return result;
        }

        /*
         * Exercise 2.1: Resize the set backing array
         *
         * We probably want to do this once size > 2*capacity to keep our lookup
         * times low
         *
         * Time Complexity: O(capacity + size(set) * average value length)
         * Space Complexity: O(1)
         */
        public void resize(int newCapacity) {
            // Create a new backing array
            List<String>[] newData = new LinkedList[newCapacity];

            // Initialize the empty buckets
            for (int i = 0; i < newData.length; i++) newData[i] = new LinkedList<String>();

            // For every value in the current set, we need to rehash it to see
            // what bucket it goes in
            for (List<String> l : data) {
                for (String s : l) {
                    int idx = s.hashCode() % newCapacity;
                    newData[idx].add(s);
                }
            }

            data = newData;
        }
    }

    /*
     * Exercise 1.2: Implement a HashMap
     */
    public static class MyHashMap {

        // Rather than have to maintain two parallel list for keys and values,
        // we can just create a MapEntry that contains both together
        private static class MapEntry {
            String key;
            String val;

            MapEntry(String key, String val) {
                this.key = key;
                this.val = val;
            }
        }

        // Backing array to store our buckets
        private List<MapEntry>[] data;
        private int size;

        /*
         * Constructor
         *
         * Time Complexity: O(n)
         * Space Complexity: O(1)
         */
        public MyHashMap(int capacity) {
            data = new LinkedList[capacity];
            for (int i = 0; i < capacity; i++) {
                data[i] = new LinkedList<MapEntry>();
            }
        }

        /*
         * Add a key-value pair to the map. If the key already exists, update
         * the corresponding value
         *
         * Time Complexity: O(size(map) + len(key))
         * Space Complexity: O(1)
         */
        public void put(String key, String val) {
            // Get the bucket index
            int idx = key.hashCode() % data.length;

            // Check whether the map already contains the key and if it does,
            // update the value
            for (MapEntry e : data[idx]) {
                if (e.key == key) {
                    e.val = val;
                    return;
                }
            }

            // The key is not in the map, so add the MapEntry
            data[idx].add(new MapEntry(key, val));
            size++;
        }

        /*
         * Get the value in the map for the corresponding key
         *
         * Time Complexity: O(size(map) + len(key))
         * Space Complexity: O(1)
         */
        public String get(String key) {
            // Get the correct bucket
            int idx = key.hashCode() % data.length;

            // Find the MapEntry with the matching key
            for (MapEntry e : data[idx]) {
                if (e.key == key) return e.val;
            }

            // If they key is not in the map, return null
            return null;
        }

        /*
         * Return true if the key is in the map
         *
         * Time Complexity: O(size(map) + len(key))
         * Space Complexity: O(1)
         */
        public boolean containsKey(String key) {
            // Get the correct bucket
            int idx = key.hashCode() % data.length;

            // See if the key exists in the current bucket
            for (MapEntry e : data[idx]) {
                if (e.key == key) return true;
            }

            return false;
        }

        /*
         * Remove the key-value pair from the map
         *
         * Time Complexity: O(size(map) + len(key))
         * Space Complexity: O(1)
         */
        public void remove(String key) {
            // Get the correct bucket
            int idx = key.hashCode() % data.length;

            // Find the map entry that needs to be removed
            MapEntry toRemove = null;
            for (MapEntry e : data[idx]) {
                if (e.key == key) {
                    toRemove = e;
                    break;
                }
            }

            // Remove the map entry
            if (toRemove != null) {
                data[idx].remove(toRemove);
                size--;
            }
        }

        /*
         * Exercise 2.2: Resize the backing array to the new capacity
         *
         * Time Complexity: O(capacity + size(map) * average value length)
         * Space Complexity: O(1)
         */
        public void resize(int newCapacity) {
            // Initialize new array
            List<MapEntry>[] newData = new LinkedList[newCapacity];

            // Initialize buckets
            for (int i = 0; i < newData.length; i++) newData[i] = new LinkedList<MapEntry>();

            // Rehash every entry and add to the new array
            for (List<MapEntry> l : data) {
                for (MapEntry e : l) {
                    int idx = e.key.hashCode() % newCapacity;
                    newData[idx].add(e);
                }
            }

            data = newData;
        }
    }

    /*
     * Exercise 1.3: Flatten a dictionary
     *
     * Time Complexity: O(items in dict)
     * Space Complexity: O(depth of nested items)
     */
    public static Map<String, Object> flattenDictionary(Map<String, Object> dict) {
        Map<String, Object> result = new HashMap<>();

        // Walk through dict recursively. For any inner maps, we track the
        // key-path to that level so that we can prepend it
        flattenDictionary(dict, result, "");
        return result;
    }

    // Inner recursive function
    private static void flattenDictionary(
            Map<String, Object> dict, Map<String, Object> result, String path) {
        // Add the . here so we don't have to worry about cases where path is
        // empty later on
        if (path.length() != 0) path += ".";

        // Iterate over each key in the dictionary and either add it to the
        // result if the value is a string or recursively iterate through the
        // dict
        for (String k : dict.keySet()) {
            Object value = dict.get(k);

            // If it's a string, add it to the result with the correct path
            if (value instanceof String) {
                result.put(path + k, (String) value);
            } else if (value instanceof Map) {
                // If it's a dict, recurse
                // Note: Jave doesn't like us casting here and will give us a
                // warning
                Map<String, Object> valDict = (Map<String, Object>) value;
                flattenDictionary((Map<String, Object>) valDict, result, path + k);
            }
        }
    }

    // Sample test cases
    public static void main(String[] args) {
        MyHashSet s = new MyHashSet(10);
        s.add("abc");
        s.add("bcd");
        // System.out.println(s.contains("abc"));
        LOGGER.log(Level.INFO, String.valueOf(s.contains("abc")));
        s.remove("abc");
        // System.out.println(s.contains("abc"));
        LOGGER.log(Level.INFO, String.valueOf(s.contains("abc")));
        s.add("bcd");
        s.add("cde");
        // System.out.println(s.toList());
        s.toList().forEach(str -> LOGGER.log(Level.INFO, str));
        s.resize(100);
        // System.out.println(s.toList());
        s.toList().forEach(str -> LOGGER.log(Level.INFO, str));

        MyHashMap m = new MyHashMap(10);
        m.put("abc", "bcd");
        m.put("123", "234");
        m.put("xyz", "abc");
        m.put("abc", "xyz");
        // System.out.println(m.containsKey("abc"));
        LOGGER.log(Level.INFO, String.valueOf(m.containsKey("abc")));
        // System.out.println(m.get("abc"));
        LOGGER.log(Level.INFO, m.get("abc"));
        m.remove("abc");
        // System.out.println(m.containsKey("abc"));
        LOGGER.log(Level.INFO, String.valueOf(m.containsKey("abc")));
        // System.out.println(m.get("abc"));
        LOGGER.log(Level.INFO, m.get("abc"));
        m.resize(100);
        // System.out.println(m.containsKey("xyz"));
        LOGGER.log(Level.INFO, String.valueOf(m.containsKey("xyz")));
        // System.out.println(m.get("xyz"));
        LOGGER.log(Level.INFO, m.get("xyz"));

        HashMap<String, Object> dict = new HashMap<>();
        dict.put("key1", "1");
        HashMap<String, Object> c = new HashMap<String, Object>();
        c.put("d", "3");
        c.put("e", "1");
        HashMap<String, Object> key2 = new HashMap<String, Object>();
        key2.put("a", "2");
        key2.put("b", "3");
        key2.put("c", c);
        dict.put("key2", key2);

        // System.out.println(dict);
        dict.forEach(
                (key, value) -> {
                    LOGGER.log(Level.INFO, "Key : " + key + " Value : " + value);
                });
        // System.out.println(flattenDictionary(dict));
        flattenDictionary(dict)
                .forEach(
                        (key, value) -> {
                            LOGGER.log(Level.INFO, "Key : " + key + " Value : " + value);
                        });
    }
}
