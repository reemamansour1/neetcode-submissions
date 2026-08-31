class Node{
    int value;
    int key;
    Node prev;
    Node next;
   public Node(int key, int value) {
    this.key = key;
    this.value = value;
    }

}
class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    public LRUCache(int capacity) {
        this.capacity = capacity;
        // why did we do this step?
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>(capacity);

    }

    // helper fuctions

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
    }

    public void addtofront(Node node){
        // i do not understand this part

        // like why do we need all those steps to move one node to the top?



        node.prev = head;

        node.next = head.next;

        head.next.prev = node;

        head.next = node;

    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        // also why did we delete the node
        // then add it to the front
        // cannt we just do those two steps in one function?
        remove(node);
        addtofront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            remove(node);
            addtofront(node);
            return;
        }
        if(map.size() == capacity){
            // why did we need to do remove the node not just find the last element in the hashmap oh i guess how would it know
            Node least = tail.prev;
            remove(least);
            map.remove(least.key);
        }
        Node newnode = new Node(key, value);
        addtofront(newnode);
        map.put(key, newnode);
        }
    }

