package com.example.chatregistersreen;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class Utils {
    // method to check for phone number validity

    public boolean isValidPhoneNumber (Context context , String mobile  ) {
        String regEx = "^[0-9]{11}$";
        return mobile.matches(regEx);
    }

    public boolean isValidEmail (Context context, CharSequence email) {
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
}
