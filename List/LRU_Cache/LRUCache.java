import java.util.*;
public class LRUCache {
	public class CacheNode {
		public int key;
		public int value;
		public CacheNode prev;
		public CacheNode next;
		CacheNode(int key, int value) {
			this.key = key;
			this.value = value;
			prev = null;
			next = null;
		}
	}
	//fields
	private int capacity;
	private Map<Integer, CacheNode> map;
	private CacheNode start;
	private CacheNode end;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, CacheNode>();
        start = null;
        end = null;
    }
    
    public int get(int key) {
    	CacheNode v = map.get(key);
    	if(v == null) {
    		return -1;
    	} 
    	moveToHead(v);
    	return v.value;
    }
    
    public void set(int key, int value) {
        CacheNode v = map.get(key);
        if(v != null) {
        	v.value = value;
        	moveToHead(v);
        	return;
        }
        if(map.size() < capacity) {
        	CacheNode newNode = new CacheNode(key, value);
        	if(end == null) {
        		end = newNode;
        		start = newNode;
        	} else {
        		newNode.next = start;
        		start.prev = newNode;
        		start = newNode;
        	}
        	map.put(key, newNode);
        } else {
        	if(end == null) {
        		return;
        	}
        	CacheNode newNode = new CacheNode(key, value);
        	newNode.next = start;
        	start.prev = newNode;
        	start = newNode;
        	map.put(key, newNode);
        	end.prev.next = null;
        	map.remove(end.key);
        	end = end.prev;
        }

    }

    private void moveToHead(CacheNode node) {
    	if(start == null) {
    		start = node;
    		end = node;
    		node.next = null;
    		node.prev = null;
    		return;
    	}
    	if(node == start) {
    		return;
    	}
    	if(node == end) {
    		end = node.prev;
    		end.next = null;
    	} else {
    		node.prev.next = node.next;
    		node.next.prev = node.prev;
    	}
    	node.prev = null;
    	node.next = start;
    	start.prev = node;
    	start = node;
    }
}