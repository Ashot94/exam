package Builders;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by Ash on 7/28/2017.
 */
public class UserBuilder implements Serializable {
    public String name ;
    public String lastName ;
    public String password ;
    public String eMail ;

    public UserBuilder(){
        name = UserBuilder.getRndString(5);
        lastName = UserBuilder.getRndString(6);
        password = UserBuilder.getRndString(7);
        eMail = UserBuilder.getRndString(5)+"@gmail.com";
    }
    public static String getRndString( int length) {
        String valid = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String res = "";
        Random rnd = new Random();
        while (0 < length--)
            res += valid.charAt(rnd.nextInt(valid.length()));
        return res;
    }

}
