package Transport;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TransportManager transportManager = new TransportManager();
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        int choice;
        while (true) {
            menu();
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    int ch;
                    menuTransport();
                    ch = Integer.parseInt(sc.nextLine());
                    switch (ch) {
                        case 1:
                            System.out.println("Enter the num");
                            int n1 = Integer.parseInt(sc.nextLine());
                            for (int i = 0; i < n1; i++) {
                                Car car = new Car();
                                transportManager.add();
                                System.out.println("nhập số ghế của xe: ");
                                car.setSoChoNgoi(Integer.parseInt(sc.nextLine()));
                                System.out.println("nhập kiểu xe: ");
                                car.setKieuXe(sc.nextLine());
                            }
                           break;
                        case 2:
                            System.out.println("Enter the num");
                            int n2 = Integer.parseInt(sc.nextLine());
                            for (int i = 0; i < n2; i++) {
                                Motorcycle motorcycle = new Motorcycle();
                                transportManager.add();
                                System.out.println("nhập công suất ");
                                motorcycle.setCongSuat(sc.nextLine());
                            }
                            break;
                        case 3:
                            System.out.println("Enter the num");
                            int n3 = Integer.parseInt(sc.nextLine());
                            for (int i = 0; i < n3; i++) {
                                Truck truck = new Truck();
                                transportManager.add();
                                System.out.println("nhập trọng tải ");
                                truck.setTrongTai(sc.nextLine());
                            }
                            break;
                    }
                case 2:
                    transportManager.display();
                    break;
                case 3:
                    transportManager.delete();
                    break;
                case 4:
                    transportManager.searchBKS();
                    break;
                case 5:
                    System.out.println("see you again");
                    return;
                default:
                    System.out.println("Bạn nhập sai mời nhập lại ");


            }
        }
    }

    public static void menu() {
        System.out.print("Menu : " + "\n" +
                "1.Add" + "\n" +
                "2.Display" + "\n" +
                "3.Delete" + "\n" +
                "4.FindBKS" + "\n" +
                "5.Exit" + "\n" +
                "Enter the choise: ");
    }

    public static void menuTransport() {
        System.out.println("1.nhập thông tin ô tô(Car) :" + "\n" +
                "2. nhập thông tin xe máy(Motorcycle):  " + "\n" +
                "3. nhập thông tin xe tải(Truck) " + "\n" +
                "Enter the number: ");
    }
}
