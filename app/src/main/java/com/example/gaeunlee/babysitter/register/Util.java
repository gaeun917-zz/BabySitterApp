package com.example.gaeunlee.babysitter.register;

/**
 * Created by gaeunlee on 7/26/16.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Util {

    // ID normalization
    public static final Pattern VALID_ID_REGEX_ALPHA_NUM =
            Pattern.compile("^[a-zA-Z0-9!@.#$%^&*?_~]{4,16}$");



    public static boolean validateId(String idStr) {
        Matcher matcher = VALID_ID_REGEX_ALPHA_NUM.matcher(idStr);
        return matcher.find();
    }



    //password normalization
    public static final Pattern VALID_PASSWORD_REGEX_ALPHA_NUM =
            Pattern.compile("^[a-zA-Z0-9!@.#$%^&*?_~]{4,16}$"); // 4자리 ~ 16자리까지 가능



    public static boolean validatePassword(String pwStr) {
        Matcher matcher = VALID_PASSWORD_REGEX_ALPHA_NUM.matcher(pwStr);
        return matcher.matches();
    }



    // email normalization
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-] + @[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);



    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

//    Util.validatePassword("가나다라");     // => false
//    Util.validatePassword("aaa");    // => false

}