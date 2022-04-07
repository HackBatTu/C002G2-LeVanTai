package ss5_access_modifier_propert_method.bai_tap;



public class test {

    public static void main(String[] args) {

        String str = "";
        for (int i = 1; i < 8; i++) {
            for (int j = 0; j <= 9; j++) {
                if ((j == 5 - i) || (j == 4 + i)) {
                    str += "" + i;
                } else {
                    str += " ";
                }
            }
            if(i<5) {
                str += "\n";
            }
        }
        for (int i = 4; i > 0; i--) {
            for (int j = 0; j <= 9; j++) {
                if (j == 5 - i || j == i+4 ) {

                    str += "" + i;
                } else {
                    str += " ";
                }
            }
            str += "\n";
        }
        System.out.println(str);
    }
}
