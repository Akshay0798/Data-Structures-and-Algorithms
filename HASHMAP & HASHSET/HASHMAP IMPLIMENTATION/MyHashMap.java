import java.util.ArrayList;
import java.util.LinkedList;

class MyHashMap<K, V> {
    // Inner class to store key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList<LinkedList<Entry<K, V>>> buckets;
    private int capacity;
    private int size;

    // Constructor initializes the hash map
    public MyHashMap() {
        capacity = 10; // Initial number of buckets
        size = 0;
        buckets = new ArrayList<>(capacity);

        // Initializing each bucket as a linked list
        for (int i = 0; i < capacity; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    // Helper method to find the appropriate bucket for a key
    private LinkedList<Entry<K, V>> getBucket(K key) {
        int hash = key.hashCode(); // Calculate hash code
        int index = Math.abs(hash) % capacity; // Calculate index
        return buckets.get(index); // Return the corresponding bucket
    }

    // Method to add/update a key-value pair
    public void put(K key, V value) {
        LinkedList<Entry<K, V>> bucket = getBucket(key);

        // Check if the key already exists in the bucket
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update the value if key already exists
                return;
            }
        }

        // If key doesn't exist, add a new entry to the bucket
        bucket.add(new Entry<>(key, value));
        size++;

        // Check if rehashing is needed due to high load factor
        if (size > capacity * 0.75) {
            rehash();
        }
    }

    // Method to get the value associated with a key
    public V get(K key) {
        LinkedList<Entry<K, V>> bucket = getBucket(key);

        // Find the key in the bucket and return its value
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null; // Return null if key is not found
    }

    // Method to remove a key-value pair
    public void remove(K key) {
        LinkedList<Entry<K, V>> bucket = getBucket(key);

        // Find the key in the bucket and remove its entry
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                size--;
                return;
            }
        }
    }

    // Method to rehash the hash map when load factor is high
    private void rehash() {
        capacity *= 2; // Double the capacity
        ArrayList<LinkedList<Entry<K, V>>> newBuckets = new ArrayList<>(capacity);

        // Initialize new buckets as linked lists
        for (int i = 0; i < capacity; i++) {
            newBuckets.add(new LinkedList<>());
        }

        // Reinsert all key-value pairs into the new buckets
        for (LinkedList<Entry<K, V>> bucket : buckets) {
            for (Entry<K, V> entry : bucket) {
                LinkedList<Entry<K, V>> newBucket = newBuckets.get(entry.key.hashCode() % capacity);
                newBucket.add(entry);
            }
        }

        buckets = newBuckets; // Replace old buckets with new ones
    }

    // Main method for testing
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("Apple", 5);
        map.put("Banana", 3);
        map.put("Orange", 7);

        System.out.println("Apple: " + map.get("Apple"));
        System.out.println("Banana: " + map.get("Banana"));
        System.out.println("Orange: " + map.get("Orange"));

        map.remove("Banana");
        System.out.println("Banana: " + map.get("Banana")); // Should print null
    }
}
