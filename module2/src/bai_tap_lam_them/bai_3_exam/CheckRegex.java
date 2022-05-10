package bai_tap_lam_them.bai_3_exam;

public class CheckRegex {
    private static final String REGEX_POINT = "^([0-9])|10$";
    public static int checkRegexPoint() {
        int value = CheckException.checkParseInteger();
        while (!String.valueOf(value).matches(REGEX_POINT)) {
            System.out.print("Enter again: ");
            value = CheckException.checkParseInteger();
        }
        return value;
    }
}
