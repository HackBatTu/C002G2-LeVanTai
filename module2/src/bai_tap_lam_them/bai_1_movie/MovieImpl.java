package bai_tap_lam_them.bai_1_movie;

import java.util.*;

public class MovieImpl implements IService {
    static List<Movie> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    private static final String REGEX_DATE = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    @Override
    public void display() {
        list = File.readMovie();
        for (Movie e : list) {
            System.out.println(e);
        }
    }

    @Override
    public void add() {
        list = File.readMovie();
        String id = Regex.inputID();
        System.out.print("enter the name: ");
        String name = sc.nextLine();
        System.out.println("Enter the day: ");
        String day = Regex.regexYear(sc.nextLine(),REGEX_DATE);
        Integer num = Integer.parseInt(Regex.inputNum());
        list.add(new Movie(id, name, day, num));
        File.writeMovie(list);
    }

    @Override
    public void delete() {
        list = File.readMovie();
        boolean check = false;
        System.out.println("*---Delete Movie!!!");
        System.out.println("enter the id want delete");
        String idDell = sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(idDell)) {
                check = true;
                break;
            }
        }
        if (check) {
            while (check) {
                System.out.print("you want delete Movie: \n" +
                        "1.yes"+"\n"+
                        "2.no\n"+
                        "you choice : ");
                int choice = 0;
                choice = Regex.getChoice(choice);
                switch (choice){
                    case 1:
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getId().equals(idDell)) {
                                list.remove(i);
                                break;
                            }
                        }
                        System.out.println("***Deleted!!!");
                        check = false;
                        break;
                    case 2:
                        System.out.println("no");
                        check = false;
                        break;
                    default:
                        System.out.println("Re- choice: ");
                }
            }
            File.writeMovie(list);
        }else {
            System.out.println("dont find id!!!");
        }
    }
}
