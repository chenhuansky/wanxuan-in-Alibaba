package com.example.demo.leedcode;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author <a herf="wanxuan.ywx@alibaba-inc.com">婉璇</a>
 * @date 2021-02-16 14:22
 * @time 14:22
 * @description
 */
public class LRUTest {
    public static void main(String[] args) {
        LRU<Integer, String> lru = new LRU<>(3);
        lru.put(0, "0");
        lru.put(1, "1");
        lru.put(2, "2");

        test1(lru.list);
        System.out.println(lru.map.keySet());

        lru.put(3, "3");
        lru.put(4, "4");

        test1(lru.list);
        System.out.println(lru.map.keySet());
        for (Integer key : lru.map.keySet()) {
            System.out.println(lru.get(key));
        }
    }

    private static void test1(DoublyLinkList list) {
        System.out.println("_________________");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}

class LRU<K, V> {

    HashMap<K, ValueNode<K, V>> map;
    DoublyLinkList<K> list;
    Integer maxSize;

    LRU(int maxSize) {
        this.maxSize = maxSize;
        map = new HashMap<>(maxSize);
        list = new DoublyLinkList<>();
    }

    public void put(K object, V value) {

        if (map.get(object) != null) {
            ValueNode now = map.get(object);
            now.node.pre.next = now.node.next;
            now.node.next.pre = now.node.pre;
            list.add(object);
            now.node = list.tail;
            map.put(object, now);
        } else {
            if (map.size() == maxSize) {
                map.remove(list.head.value);
                list.removeBefore();
            }
            list.add(object);
            ValueNode<K, V> valueNode = new ValueNode<>();
            valueNode.value = value;
            valueNode.node = list.tail;
            map.put(object, valueNode);
        }
    }

    public V get(K key) {
        return map.get(key).value;
    }

}

class DoublyLinkList<T> {
    Node<T> head;
    Node<T> tail;
    int size;

    public int size() {
        return size;
    }

    DoublyLinkList() {
        size = 0;
    }

    public void add(T object) {
        if (tail == null) {
            head = new Node<>();
            head.value = object;
            tail = head;
        } else {
            Node<T> temp = new Node<>();
            temp.pre = tail;
            temp.value = object;
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    T get(int index) {
        if (size == 0 || tail == null) {
            return null;
        }
        Node<T> result = head;
        while (index-- > 0) {
            result = result.next;
        }
        return result.value;
    }

    public void removeBefore() {
        if (size == 0 || tail == null) {
            throw new RuntimeException("list is empty");
        }
        if (size == 1 || tail.pre == null) {
            tail = null;
            head = null;
            return;
        }
        head = head.next;
        head.pre = null;
        size--;
    }

    void remove(T object) {
        if (size == 0 || tail == null) {
            return;
        }

        Node<T> p = head;
        if (p.value == object) {
            head = head.next;
            head.pre = null;
            size--;
        }
        while (p.next != null) {
            Node<T> now = p.next;
            if (now.value == object) {
                p.next = now.next;
                if (now.next != null) {
                    now.next.pre = p;
                }
                size--;
                return;
            }
            p = now;
        }
    }
}

class ValueNode<K, V> {
    Node<K> node;
    V value;
}
class Node<T> {
    Node<T> next;
    Node<T> pre;
    T value;

    @Override
    public boolean equals(Object obj) {
        return (this == obj);
    }

    @Override
    public native int hashCode();
}
