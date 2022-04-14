package ss10_array_list_link_list.bai_tap.array_list;

public class MainArrayList {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("C2022G2: ");
        list.add("Hội");
        list.add("Đẹp");
        list.add("Trai");

        print(list.getElements());

        System.out.println(list.indexOf("Yes"));
        System.out.println(list.indexOf("No"));

        list.remove(1);
        list.add("very", 1);
        print(list.getElements());

        ArrayList<String> clone = list.clone();

        System.out.println(clone.contains("Đẹp"));
        System.out.println(clone.contains("handsome"));

        System.out.println(clone.get(3));
        System.out.println(clone.size());
        clone.clear();
        System.out.println(clone.size());
        print(clone.getElements());


    }

    static void print(Object[] list) {
        for (Object x : list) {
            if (!(x == null)) {
                System.out.println((String) x);
            }
        }
        System.out.println("\n");
    }
}

