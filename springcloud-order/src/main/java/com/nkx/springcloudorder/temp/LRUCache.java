package com.nkx.springcloudorder.temp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class LRUCache {

    private Map<Integer, Node> caCheMap = new HashMap<Integer, Node>();
    private int size;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = caCheMap.get(key);
        if (node != null) {
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node newNode = caCheMap.get(key);
        if (newNode != null) {
            newNode.value = value;
            removeNode(newNode);
            insertHead(newNode);
        } else {
            Node node = new Node(key, value);
            caCheMap.put(key, node);
            insertHead(node);
            size++;
            if (size > capacity) {
                caCheMap.remove(tail.key);
                deleteLastNode();
                size--;
            }
        }
    }

    public void removeNode(Node node) {
        if (node == head) {
            node.next.previous = null;
            head = node.next;
            return;
        }
        if (node == tail) {
            node.previous.next = null;
            tail = node.previous;
            return;
        }
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }


    public void deleteLastNode() {
        tail.previous.next = null;
        tail = tail.previous;
    }


    public void insertHead(Node node) {
        Node current = head;
        if (tail == null) {
            tail = node;
        }
        if (head == null) {
            head = node;
            return;
        }
        current.previous = node;
        node.next = current;
        head = node;
    }

    class Node {
        Node next;
        Node previous;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.previous = null;
        }
    }


    private void print(){
        Iterator<Map.Entry<Integer, Node>> it = caCheMap.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry<Integer, Node> next = it.next();
            System.out.println(next.getKey() + " " + next.getValue().value);
        }
    }




    //result [null,null,1,null,-1,null,-1,3,4]
    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);
        obj.get(1);
        obj.put(3,3);
        obj.get(2); //expected -1
        obj.put(4,4);
        obj.get(1);
        obj.get(3);
        obj.get(4);
        obj.print();

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */