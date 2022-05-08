package bai_tap_lam_them.bai_1;

public class Displaycontroller {
    static MovieImpl movie = new MovieImpl();
    public void display(){
        while (true){
            System.out.println("**---Menu MovieManager---***");
            System.out.print(" 1. list Movie.\n" +
                    " 2. add Movie \n" +
                    " 3. delete Movie by id .\n" +
                    " 0. Thoát.\n" +"you choice : ");
            int choice = 0;
            choice = Regex.getChoice(choice);
            switch (choice){
                case 1:
                    movie.display();
                    break;
                case 2:
                    movie.add();
                    break;
                case 3:
                    movie.delete();
                    break;
                case 0:
                    return;
                default:
                    System.out.print("Re- choice: ");
            }
        }
    }
}
