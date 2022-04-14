package ss10_array_list_link_list.bai_tap.link_list;

import ss10_array_list_link_list.thuc_hanh.MyLinkedList;

public class Node {
    private Node next;
    private Object data;

    public Node(Object data){
        this.data = data;
    }
    public Object getData(){
        return data;

    }
}
