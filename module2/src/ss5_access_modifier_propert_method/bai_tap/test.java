package ss5_access_modifier_propert_method.bai_tap;

public class test {

    public static void main(String[] args) {
        String str = "";
        String str1 = "";
        for (int i = 1; i < 8; i++) {
            for (int j = 0; j <= 9; j++) {
                if ((j == 8 / 2 + 1 - i) || (j == 8 / 2 + i)) {
                    str += "" + i;
                } else {
                    str += " ";
                }
            }
            if (i < 5) {
                str += "\n";
            }
        }
        for (int i = 4; i > 0; i--) {
            for (int j = 0; j <= 9; j++) {
                if (j == 7 / 2 + 2 - i || j == i + 4) {
                    str1 += "" + i;
                } else {
                    str1 += " ";
                }
            }
            str1 += "\n";
        }
        String str3 = str + "\n" + str1;
        System.out.println(str3);

    }
}
