package ss10_array_list_link_list.bai_tap.link_list;

public class MainMyLinkedList<E> {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(1);
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println(myLinkedList.get(i));
        }
        System.out.println(".............");
        System.out.println((myLinkedList.size()));
        System.out.println(".............");
        myLinkedList.remove(1);
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println(myLinkedList.get(i));
        }
        System.out.println(".............");
        myLinkedList.clone();
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println(myLinkedList.get(i));
        }
        System.out.println("First: " + myLinkedList.getFirst());
        System.out.println("Last: " + myLinkedList.getLast());

        myLinkedList.clear();
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println(myLinkedList.get(i));
        }

    }
}
