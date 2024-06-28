package MODEL;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class Check{

    private static final String EMAIL_PATTERN = "^[\\w!#$%&'*+/=?^`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?$";

    public static boolean isValidEmail(String email) {
        return email != null && email.trim().matches(EMAIL_PATTERN);
    }

    public static Boolean isPhoneNumber(String s){
        if (s.length()>=10 && s.length() <=12 ){
            for (int i = 0; i < s.length(); i++){
                if (!Character.isDigit(s.charAt(i))){
                    return false;
                }
            }
            return true;
        } 
        return false;
    }

    public static void RemoveTableData(DefaultTableModel model) {
        int count = model.getRowCount();
        for(int i = 0; i< count;i++){
            model.removeRow(0);
        }
    }
   public static String DateToString(Date date){
        return String.valueOf(date);
    }

    public static Date StringToDate(String s) throws ParseException{
        return new SimpleDateFormat("dd/MM/yyyy").parse(s);
    }
}
