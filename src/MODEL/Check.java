public class Check{

    private static final String EMAIL_PATTERN = "^[\\w!#$%&'*+/=?^`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?$";

    public static boolean isValidEmail(String email) {
        return email != null && email.trim().matches(EMAIL_PATTERN);
    }

    public static Boolean isPhoneNumber(String s){
        if (s.length()>=10 && s.length() <=12 ){
            for (int i = 0; i <= s.length(); i++){
                if (!Character.isDigit(s.charAt(i))){
                    return false;
                }
            }
            return true;
        } 
        return false;
    }

   
}
