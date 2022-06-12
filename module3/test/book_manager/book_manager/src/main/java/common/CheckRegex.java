package common;

public class CheckRegex {
    private static final String REGEX_BOOK_CARD_ID = "^MS-[0-9]{4}$";

    public static boolean CheckBookCardId(String value) {
        if (value.matches(REGEX_BOOK_CARD_ID)) {
            return false;
        }
        return true;
    }
}
