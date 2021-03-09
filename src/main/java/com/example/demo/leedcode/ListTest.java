package com.example.demo.leedcode;

/**
 * @author <a herf="wanxuan.ywx@alibaba-inc.com">婉璇</a>
 * @date 2021-02-19 16:14
 * @time 16:14
 * @description
 */
public class ListTest {

    public static void main(String[] args) {
        LinkList<Integer> linkList = new LinkList<>();
        linkList.add(0);
        linkList.add(1);
        linkList.add(2);
        linkList.add(3);

        System.out.println("_________________");
        for (int i = 0; i < 4; i++) {
            System.out.println(linkList.get(i));
        }

        linkList.reverse();
        System.out.println("_________________");
        for (int i = 0; i < 4; i++) {
            System.out.println(linkList.get(i));
        }

    }

}


class LinkList<T> {
    private Node<T> head;
    private Node<T> tail;

    LinkList() {
    }

    public void add(T object) {
        if (head == null) {
            head = new Node<>();
            head.value = object;
            tail = head;
        } else {
            Node<T> temp = new Node<>();
            temp.value = object;
            tail.next = temp;
            tail = temp;
        }
    }

    T get(int index) {
        if (tail == null) {
            return null;
        }
        Node<T> result = head;
        while (index-- > 0) {
            result = result.next;
        }
        return result.value;
    }

    void reverse() {
        if (head == null || head == tail) {
            return;
        }
        tail = head;
        Node <T> pre = head;
        while (pre.next != null) {
            Node<T> action = pre.next;

            pre.next = action.next;
            action.next = head;
            head = action;
        }
    }
}