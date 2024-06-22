public class Check{
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
