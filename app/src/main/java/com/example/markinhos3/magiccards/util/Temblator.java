package com.example.markinhos3.magiccards.util;


import android.content.Context;
import android.os.Vibrator;


public class Temblator {

    public static void tremble(Context context, int millis){

        // Get instance of Vibrator from current Context
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);

        // Start without a delay
        // Each element then alternates between vibrate, sleep, vibrate, sleep...
        long[] pattern = {0 , 200, 100, 200, 100};

        // The '-1' here means to vibrate once, as '-1' is out of bounds in the pattern array
        v.vibrate(pattern, -1);
    }
}
