package common;

public class CheckRegex {
    private static final String REGEX_NAME = "^((\\D)+)|([a-z]{1,200})|([A-Z]{1,200})|([\\s]{1,200})$";

    public static boolean regexName (String value) {
        if (value.matches(REGEX_NAME)) {
            return false;
        }
        return true;
    }
}
