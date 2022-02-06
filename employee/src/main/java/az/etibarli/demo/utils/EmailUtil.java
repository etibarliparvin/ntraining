package az.etibarli.demo.utils;

import java.util.List;

public class EmailUtil {

    public static boolean checkOneEmail(String newEmail, String dbEmail) {
        return !newEmail.equals(dbEmail);
    }

    public static boolean checkAllEmails(String newEmail, List<String> emails) {
        return emails.stream().noneMatch(a -> a.equals(newEmail));

//        for (String s : emails) {
//            if (s.equals(newEmail)) return true;
//        }
//        return false;
    }
}
