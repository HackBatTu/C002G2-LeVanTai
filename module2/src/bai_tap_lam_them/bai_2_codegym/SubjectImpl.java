package bai_tap_lam_them.bai_2_codegym;

import java.util.*;

public class SubjectImpl implements IService {
    static List<Subject> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static {
        list.add(new Subject("BC-YYYY", "math", "3.5", "hard", "10h"));
        list.add(new Subject("BC-XXXX", "mathS", "1.5", "easy", "8h"));
        list.add(new Subject("BC-ZZZZ", "mathSS", "4.5", "nomal", "15h"));
        list.add(new Subject("BC-AAAA", "mathSSS", "2.5", "nomal", "9h"));
    }

    @Override
    public void display() {
        System.out.println("**List Subject : ");
        for (Subject sub : list) {
            System.out.println(sub);
        }
    }
    @Override
    public void add() {
        boolean check = true;
        while (true) {
            String id = Regex.inputID();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equals(id)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.println("enter the name : ");
                String name = sc.nextLine();
                String ver = Regex.inputVer();
                String hard = menuHard();
                String h = Regex.inputHours();
                list.add(new Subject(id, name, ver, hard, h));
            } else {
                System.out.println("id đã tồn tại");

            }
        }

    }

    public static String menuHard() {
        while (true) {
            System.out.println("select hard: \n" +
                    "1.hard\n" +
                    "2.normal\n" +
                    "3.easy\n" +
                    "you choice: ");
            int choice = Regex.getChoice();
            switch (choice) {
                case 1:
                    return "hard";
                case 2:
                    return "normal";
                case 3:
                    return "easy";
                default:
                    System.out.print("Re- choice: ");
            }
        }
    }

    @Override
    public void update() {
        boolean check = true;
        System.out.println("***---Update Subject by ID---*** ");
        String id = Regex.inputID();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                check = false;
                break;
            }
        }
        if (!check) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equals(id)) {
                    System.out.println("enter the name : ");
                    list.get(i).setName(sc.nextLine());
                    list.get(i).setVersion(Regex.inputVer());
                    list.get(i).setHard(menuHard());
                    list.get(i).setHours(Regex.inputHours());
                }
            }
        } else {
            System.out.println("dont find id: ");
        }
    }

    @Override
    public void delete() {
        boolean check = true;
        try {
            System.out.println("enter the id delete: ");
            String id = Regex.inputID();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equals(id)) {
                    check = false;
                    break;
                }
            }
            if (!check) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getId().equals(id)) {
                        list.remove(i);
                        break;
                    }
                }
            } else {
                throw new RegexException("dont fint id");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void sort() {
        Collections.sort(list, new Comparator<Subject>() {
            @Override
            public int compare(Subject o1, Subject o2) {
                return o1.getVersion().compareToIgnoreCase(o2.getVersion());
            }
        });
        System.out.println("Sorted , Enter the 1 by display list!");
    }

}
