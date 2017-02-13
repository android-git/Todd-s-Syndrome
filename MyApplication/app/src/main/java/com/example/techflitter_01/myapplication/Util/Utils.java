package com.example.techflitter_01.myapplication.Util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by techflitter_01 on 2/3/2017.
 */

public class Utils {
    public static void showToast(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
