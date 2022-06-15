package common;

public class Validate {
    private static final String REGEX_ID = "^([0-9A-Z]{3})\\-([0-9A-Z]{2})\\-([0-9A-Z]{2})$";


    public static boolean regexPhone(String id)  {
        if (!id.matches(REGEX_ID)) {
            return true;
        }
        return false;
    }
}
