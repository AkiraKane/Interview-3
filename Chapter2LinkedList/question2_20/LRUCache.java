package question2_20;

import java.util.HashMap;

class CacheNode {
    public Integer key;
    public Integer value;
    public CacheNode prev;
    public CacheNode next;
    
    public CacheNode() {
    }
    
    public CacheNode(Integer key, Integer value){
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    
    private int capability;
    private int size;
    private CacheNode head;
    private CacheNode tail;
    private HashMap<Integer, CacheNode> map; 
    
    public LRUCache(int capability){
        this.capability = capability;
        this.size = 0;
        this.head = new CacheNode();
        this.tail = null;
        map = new HashMap<Integer, CacheNode>();
    }
    
    public Integer get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        int result = map.get(key).value;
        // move this cacheNode to the first position
        moveCacheNodeToHead(map.get(key));
        return result;
    }
    
    public void set(int key, int value){
        if(map.containsKey(key)){
            // update this cachenode
            CacheNode node = map.get(key);
            node.value = value;
            moveCacheNodeToHead(node);
        } else {
            if(size==capability){
                // remove the cachenode at tail
                this.tail.prev.next=null;
                this.tail = this.tail.prev;
                this.map.remove(this.tail.key);
                this.size--;
            }
            // create new cachenode
            CacheNode newNode = new CacheNode(key, value);
            newNode.next = head.next;
            head.next = newNode;
            this.map.put(key, newNode);
            this.size++;
        }
    }
    
    private void moveCacheNodeToHead(CacheNode node){
        node.prev.next = node.next;
        node.next = head.next;
        head.next = node;
    }
}
