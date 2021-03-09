package com.example.demo.leedcode;

/**
 * @author <a herf="wanxuan.ywx@alibaba-inc.com">婉璇</a>
 * @date 2021-02-23 15:04
 * @time 15:04
 * @description
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue queue = new Queue<Integer>(5);
        queue.offer(0);
        queue.offer(1);
        queue.offer(2);
        queue.print();

        queue.offer(3);
        queue.offer(4);
        queue.print();

        Integer ret = (Integer)queue.pop();
        queue.offer(5);
        queue.print();

        Integer ret2 = (Integer)queue.pop();
        queue.offer(6);
        queue.print();
    }
}

class Queue<T> {
    /**
     * The queued items
     */
    T[] items;

    int head;
    int tail;
    int size;

    Queue(int size) {
        this.size = size;
        head = 0;
        tail = 0;
        items = (T[])new Object[size];
    }

    public void offer(T item) {
        if (items[head] != null && tail == head) {
            throw new RuntimeException("size out");
        }
        items[tail] = item;
        tail = tail + 1;
        if (tail == size) {
            tail = 0;
        }
    }

    public T pop() {
        T obj = items[head];
        items[head] = null;
        head = head + 1;
        if (head == size) {
            head = 0;
        }
        return obj;
    }

    public void print() {
        if (tail <= head) {
            for (int i = head; i < size; i++) {
                System.out.print(items[i]);
            }
            for (int i = 0; i < tail; i++) {
                System.out.print(items[i]);
            }
        } else {
            for (int i = head; i < tail; i++) {
                System.out.print(items[i]);
            }
        }

        System.out.println("");
    }

}