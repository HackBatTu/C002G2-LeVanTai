package ss3_array.thuc_hanh;

import java.util.Scanner;

public class FindValue {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Name Find : ");
        String find_name = sc.nextLine();
        boolean check = false;
        for(int i =0; i<students.length; i++){
            if(students[i].equals(find_name)){
                System.out.println("Position of the students in the list " + find_name + " is: " + i);
                check =true;
                break;
            }
        }
        if(!check){
            System.out.print("Not found " + find_name + " in the list.");
        }
}
}
