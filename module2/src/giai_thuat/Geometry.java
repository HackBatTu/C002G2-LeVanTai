package giai_thuat;

public class Geometry {
    public static void main(String[] args) {
        int n = 10;

        for(int i= 1 ; i<=5 ; i++ ){
            for (int a=1 ; a<=i ; a++){
                System.out.print(" ");
            }
            for (int j =i*2 ; j>0 ; j--){
                System.out.print("*");
            }
            System.out.println("\n");
        }
        for(int i= 0 ; i<=5 ; i++ ){
            for (int a=5 ; a>=i ; a--){
                System.out.print(" ");
            }
            for (int j =1 ; j<=i*2 ; j++){
                    System.out.print("*");
            }
            System.out.println("\n");
        }
    }
}
