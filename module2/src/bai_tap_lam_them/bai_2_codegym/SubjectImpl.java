package bai_tap_lam_them.bai_2_codegym;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SubjectImpl implements IService {
    static List<Subject> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static {
        list.add(new Subject("BC-YYYY", "math", "5.5", "hard", "10h"));
        list.add(new Subject("BC-XXXX", "mathS", "5.5", "easy", "8h"));
        list.add(new Subject("BC-ZZZZ", "mathSS", "5.5", "nomal", "15h"));
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
        String id = Regex.inputID();
        System.out.println("enter the name : ");
        String name = sc.nextLine();
        String ver = Regex.inputVer();
        String hard = menuHard();
        String h = Regex.inputHours();
        list.add(new Subject(id, name, ver, hard, h));
    }

    public static String menuHard() {
        while (true) {
            System.out.println("select: \n" +
                    "1.hard\n" +
                    "2.normal\n" +
                    "3.easy\n" +
                    "you choice: ");
            int choice = 0;
            choice = Regex.getChoice(choice);
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
            if(list.get(i).getId().equals(id)){
                check= false;
                break;
            }
        }
        if (!check){
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i).getId().equals(id)){
                    System.out.println("enter the name : ");
                    list.get(i).setName(sc.nextLine());
                    list.get(i).setVersion(Regex.inputVer());
                    list.get(i).setHard(menuHard());
                    list.get(i).setHours(Regex.inputHours());
                }
            }
        }else {
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
                if(list.get(i).getId().equals(id)){
                    check= false;
                    break;
                }
            }
            if (!check){
                for (int i = 0; i < list.size(); i++) {
                    if(list.get(i).getId().equals(id)){
                        list.remove(i);
                        break;
                    }
                }
            }else {
                throw new RegexException("dont find id");
            }
        }catch (RegexException e) {
            e.printStackTrace();
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public void sort(){
        Collections.sort(list);
    }

}
