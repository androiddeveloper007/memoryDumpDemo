package com.eostek.memeorydump;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class Crash3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crash1);

        crash();
    }

    private static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(100*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    //匿名内部类导致的
    //内存泄漏了
    private void crash() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(100*1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
        new Thread(runnable).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Crash3", "destroying.........");
        runnable = null;
    }

}
