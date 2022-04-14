package ss10_array_list_link_list.bai_tap.link_list;

import javax.xml.soap.Node;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes = 0;

    private class Node {
        private Node next;
        private Object data;

        public Node(Object element) {
            this.data = element;
        }

        private Object getData() {
            return this.data;
        }
    }

    public MyLinkedList() {
    }

  // thêm phần tử tại vị trí đầu
    public void addFirst(E element) {
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }

    // thêm phần tử vào cuối
    public void addLast(E element) {
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(element);
        numNodes++;
    }

   // thêm phần tử vào vị trí index
    public void add(int index, E element) {
        Node temp = head;

        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }

   //lấy gái trị index
    public Object get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    // kích thước
    public int size() {
        return numNodes;
    }

    // xóa phần tử tại vị trí index
    public E remove(int index) {
        if (index < 0 || index > numNodes) {
            throw new IllegalArgumentException("Index: " + index);
        }
        Node temp = head;

        Object data;

        if (index == 0) {
            data = temp.data;
            head = head.next;
            numNodes--;
        } else {
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            data = temp.next.data;
            temp.next = temp.next.next;
            numNodes--;
        }
        return (E) data;
    }

   // xóa 1 phần tử
    public boolean remove(E element) {
        if (head.data.equals(element)) {
            remove(0);
            return true;
        } else {
            Node temp = head;
            while (temp.next != null) {
                if (temp.next.data.equals(element)) {
                    temp.next = temp.next.next;
                    numNodes--;
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

  // sao chép Linkedlist
    public MyLinkedList<E> clone() {
        if (numNodes == 0) {
            throw new NullPointerException("Linkedlist is null");
        }
        MyLinkedList<E> myCloneLinkedList = new MyLinkedList<>();
        Node temp = head;
        myCloneLinkedList.addFirst((E) temp.data);
        temp = temp.next;
        while (temp != null) {
            myCloneLinkedList.addLast((E) temp.data);
            temp = temp.next;
        }
        return myCloneLinkedList;
    }

    // kiểm tra tồn tại
    public boolean contains(E element) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.data.equals(element)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

   // trả về vị trí muốn tìm
    public int indexOf(E element) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.getData().equals(element)) {
                return i;
            }
        }
        return -1;
    }

   // trả về phần tử đầu
    public E getFirst() {
        Node temp = head;
        return (E) temp.data;
    }


     //Trả về phần tử ở vị trí cuối cùng

    public E getLast() {
        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

    // xóa all
    public void clear() {
        Node temp = head;
        while (temp.next != null) {
            temp.data = null;
            temp = temp.next;
        }
        numNodes = 0;
    }
}
