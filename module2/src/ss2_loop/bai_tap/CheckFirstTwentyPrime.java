package ss2_loop.bai_tap;

public class CheckFirstTwentyPrime {
    public static void main(String[] args) {
        int count = 0;
        int number = 0;

        while (count<20){
            boolean check = true;
            if(number< 2){
                check = false;
            }
            for (int i=2; i<=Math.sqrt(number) ; i++){
                    if(number%i==0){
                        check = false;
                        break;
                    }
            }
            if(check){
                    System.out.println(number);
                    count++;
            }
            number++;
        }
    }
}

