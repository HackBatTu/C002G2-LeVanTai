package common;


public class Validate {
    private static final String REGEX_CUSTOMER_ID = "^(KH-)\\d{4}$";
    private static final String REGEX_SERVICE_ID = "^(DV-)\\d{4}$";
    private static final String REGEX_PHONE = "^(09|\\(84\\)\\+9)[01]\\d{7}$";
    private static final String REGEX_DATE = "^([0-1][0-9]{1,2}|(1)[0-9]{3}|(20)[0-2]{2})(\\/|-)\\d{2}(\\/|-)\\d{2}$";
    private static final String REGEX_ID_CARD = "^\\d{9}|\\d{12}$";
    private static final String REGEX_EMAIL = "^\\w{3,}(\\.?\\w+)*@[a-z]{2,7}(.[a-z]{2,5}){1,3}$";
    private static final String REGEX_SD = "^\\d+|\\d+\\.\\d+$";

    public static boolean regexPhone(String phone)  {
        if (!phone.matches(REGEX_PHONE)) {
            return true;
        }
        return false;
    }

    public static boolean regexIdCard(String idCard)  {
        if (!idCard.matches(REGEX_ID_CARD)) {
            return true;
        }
        return false;
    }
    public  static boolean regexDate(String date){
        if(!date.matches(REGEX_DATE)){
            return true;
        }
        return false;
    }
    public  static boolean regexEmail(String email){
        if(!email.matches(REGEX_EMAIL)){
            return true;
        }
        return false;
    }
    public  static boolean regexSD(String sd){
        if(!sd.matches(REGEX_SD)){
            return true;
        }
        return false;
    }
}
