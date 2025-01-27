// LRU Cache
// Difficulty: HardAccuracy: 18.44%Submissions: 162K+Points: 8
// Design a data structure that works like a LRU Cache. Here cap denotes the capacity of the cache and Q denotes the number of queries. Query can be of two types:

// PUT x y: sets the value of the key x with value y
// GET x: gets the key of x if present else returns -1.
// The LRUCache class has two methods get() and put() which are defined as follows.

// get(key): returns the value of the key if it already exists in the cache otherwise returns -1.
// put(key, value): if the key is already present, update its value. If not present, add the key-value pair to the cache. If the cache reaches its capacity it should remove the least recently used item before inserting the new item.
// In the constructor of the class the capacity of the cache should be initialized.
// Examples:

// Input: cap = 2, Q = 2, Queries = [["PUT", 1, 2], ["GET", 1]]
// Output: [2]
// Explanation: Cache Size = 2
// ["PUT", 1, 2] will insert the key-value pair (1, 2) in the cache,
// ["GET", 1] will print the value corresponding to Key 1, ie 2.
// Input: cap = 2, Q = 8, Queries = [["PUT", 1, 2], ["PUT", 2, 3], ["PUT", 1, 5], ["PUT", 4, 5], ["PUT", 6, 7], ["GET", 4], ["PUT", 1, 2], ["GET", 3]]
// Output: [5, -1]
// Explanation: Cache Size = 2
// ["PUT", 1, 2] will insert the pair (1,2) in the cache.
// ["PUT", 2, 3] will insert the pair (2,3) in the cache: 1->2, 2->3(the most recently used one is kept at the rightmost position) 
// ["PUT", 1, 5] will replace the value of 1 from 2 to 5 : 2 -> 3, 1 -> 5
// ["PUT", 4, 5] : 1 -> 5, 4 -> 5 (Cache size is 2, hence we delete the least recently used key-value pair)
// ["PUT", 6, 7] : 4 -> 5, 6 -> 7 
// ["GET", 4] : Prints 5 (The cache now looks like 6 -> 7, 4->5)
// ["PUT", 1, 2] : 4 -> 5, 1 -> 2  (Cache size is 2, hence we delete the least recently used key-value pair)
// ["GET", 3] : No key value pair having key = 3. Hence, -1 is printed.


Soln:

import java.util.*;

class LRUCache {
    private int capacity; // Maximum capacity of the cache
    private HashMap<Integer, Node> map; // HashMap to store key-node pairs
    private DoublyLinkedList dll; // Doubly Linked List to manage the LRU order

    // Constructor for initializing the cache capacity with the given value
    public LRUCache(int cap) {
        this.capacity = cap;
        this.map = new HashMap<>();
        this.dll = new DoublyLinkedList();
    }

    // Function to return value corresponding to the key
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1; // Key not found
        }
        // Move the accessed node to the front of the list (most recently used)
        Node node = map.get(key);
        dll.moveToHead(node);
        return node.value;
    }

    // Function for storing key-value pair
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // If the key already exists, update its value and move it to the front
            Node node = map.get(key);
            node.value = value;
            dll.moveToHead(node);
        } else {
            // If the key does not exist, create a new node
            if (map.size() == capacity) {
                // If the cache is at capacity, remove the least recently used node
                Node tail = dll.removeTail();
                map.remove(tail.key);
            }
            Node newNode = new Node(key, value);
            dll.addToHead(newNode);
            map.put(key, newNode);
        }
    }

    // Inner class for the doubly linked list nodes
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Inner class for the doubly linked list
    private class DoublyLinkedList {
        private Node head;
        private Node tail;

        DoublyLinkedList() {
            this.head = new Node(0, 0); // Dummy head
            this.tail = new Node(0, 0); // Dummy tail
            head.next = tail;
            tail.prev = head;
        }

        // Add a node to the front (head) of the list
        void addToHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        // Remove a node from the list
        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // Move an existing node to the front (head) of the list
        void moveToHead(Node node) {
            removeNode(node);
            addToHead(node);
        }

        // Remove the tail node (least recently used)
        Node removeTail() {
            Node tailNode = tail.prev;
            removeNode(tailNode);
            return tailNode;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        int cap = 2;
        int Q = 8;
        String[][] queries = {
            {"PUT", "1", "2"},
            {"PUT", "2", "3"},
            {"PUT", "1", "5"},
            {"PUT", "4", "5"},
            {"PUT", "6", "7"},
            {"GET", "4"},
            {"PUT", "1", "2"},
            {"GET", "3"}
        };

        LRUCache lruCache = new LRUCache(cap);
        for (String[] query : queries) {
            if (query[0].equals("PUT")) {
                int key = Integer.parseInt(query[1]);
                int value = Integer.parseInt(query[2]);
                lruCache.put(key, value);
            } else if (query[0].equals("GET")) {
                int key = Integer.parseInt(query[1]);
                System.out.println(lruCache.get(key));
            }
        }
    }
}
