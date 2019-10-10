package com.eostek.memeorydump;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.lang.ref.WeakReference;

public class Crash2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crash1);

        crash();
    }

    private Handler mHandler;

    public static class HealthHandler extends Handler {
        private final WeakReference<Activity> mActivity;

        public HealthHandler(Activity activity) {
            mActivity = new WeakReference<>(activity);
        }

        @Override public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.e("crash2", "handler message is doing");
        }
    }

    //内存泄漏了
    private void crash() {
        mHandler = new HealthHandler(this);
        mHandler.sendEmptyMessageDelayed(1, 10000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Crash2", "destroying.........");
//        mHandler.removeCallbacksAndMessages(null);
//        mHandler = null;
    }

    /*@Override
    public void onBackPressed() {
//        super.onBackPressed();
//        finish();
//        startActivity(new Intent(this,  MainActivity.class));
    }*/
}
