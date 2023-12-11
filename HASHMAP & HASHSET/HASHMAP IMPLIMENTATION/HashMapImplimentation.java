import java.util.*;
public class HashMapImplimentation {
    // Defining a generic HashMap class
    static class HashMap<K, V> {
        // Nested class for storing key-value pairs
        private class Node {
            K key;
            V value;

            // Constructor to initialize key and value
            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        // Number of elements in the map
        private int n;
        // Number of buckets in the hash table
        private int N;
        // Array of linked lists to store key-value pairs
        private LinkedList<Node>[] buckets;

        // Constructor for the HashMap
        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            // Initializing the array of linked lists
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        // Hash function to determine the bucket index for a key
        private int hashFunction(K key) {
            int bi = key.hashCode(); // Get the hash code of the key
            return Math.abs(bi) % N; // Calculate the bucket index
        }

        // Search for a key in a specific linked list (bucket)
        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi]; // Get the linked list at the bucket index

            // Iterate through the linked list to find the key
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) { // If the key is found
                    return i; // Return the index of the key in the linked list
                }
            }

            return -1; // Key not found in the linked list
        }

        // Rehashing the HashMap when the load factor exceeds a threshold
        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBucket = buckets; // Store the old buckets
            buckets = new LinkedList[N * 2]; // Create new buckets with doubled size

            // Initialize the new buckets
            for (int i = 0; i < N * 2; i++) {
                buckets[i] = new LinkedList<>();
            }

            // Iterate through the old buckets and re-insert key-value pairs
            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    put(node.key, node.value); // Re-insert the key-value pair
                }
            }
        }

        // Method to add or update a key-value pair in the HashMap
        public void put(K key, V value) {
            int bi = hashFunction(key); // Get the bucket index for the key
            int di = searchInLL(key, bi); // Search for the key in the linked list

            if (di == -1) { // If key not found, add a new Node
                buckets[bi].add(new Node(key, value));
                n++; // Increment the number of elements

            } else { // If key is found, update the value
                Node node = buckets[bi].get(di);
                node.value = value;
            }

            double lambda = (double) n / N; // Calculate the load factor

            if (lambda > 2.0) { // If load factor exceeds the threshold, rehash
                rehash();
            }
        }

        // Method to check if a key exists in the HashMap
        public boolean containsKey(K key) {
            int bi = hashFunction(key); // Get the bucket index for the key
            int di = searchInLL(key, bi); // Search for the key in the linked list

            // If key index is -1, key was not found; otherwise, it was found
            return di != -1;
        }

        // Method to remove a key-value pair from the HashMap
        public void remove(K key) {
            int bi = hashFunction(key); // Get the bucket index for the key
            int di = searchInLL(key, bi); // Search for the key in the linked list

            if (di == -1) { // If key not found, return null
            } else {
                Node node = buckets[bi].remove(di); // Remove the Node from the linked list
                n--; // Decrement the number of elements
            }
        }

        // Method to get the value associated with a key
        public V get(K key) {
            int bi = hashFunction(key); // Get the bucket index for the key
            int di = searchInLL(key, bi); // Search for the key in the linked list

            if (di == -1) { // If key not found, return null
                return null;
            } else {
                Node node = buckets[bi].get(di); // Get the Node with the key
                return node.value; // Return the Node's value
            }
        }

        // Method to get a list of all keys in the HashMap
        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>(); // Initialize a list to store keys

            // Iterate through all buckets and linked lists to gather keys
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(j);
                    keys.add(node.key); // Add the key to the list
                }
            }

            return keys; // Return the list of keys
        }

        // Method to check if the HashMap is empty
        public boolean isEmpty() {
            return n == 0; // Return true if the number of elements is 0
        }
    }

    // Main method to test the HashMap implementation
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(); // Create an instance of the HashMap
        map.put("India", 190); // Insert key-value pairs
        map.put("China", 200);
        map.put("US", 50);

        ArrayList<String> keys = map.keySet(); // Get a list of keys
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i) + " " + map.get(keys.get(i))); // Print key-value pairs
        }

        map.remove("India"); // Remove a key-value pair
        System.out.println(map.get("India")); // Print the value associated with "India" (should be null)
    }
}

