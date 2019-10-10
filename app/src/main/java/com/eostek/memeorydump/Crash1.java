package com.eostek.memeorydump;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class Crash1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crash1);

        crash();
    }

    private static Context mContext;

    //重复进入退出此类，通过studio内存工具可以看到crash1实例不断新增。
    //说明内存泄漏了
    private void crash() {
        mContext = this;
    }

    @Override
    protected void onDestroy() {
//        mContext = null;
        super.onDestroy();
        Log.e("Crash1", "destroying.........");
    }

    /*@Override
    public void onBackPressed() {
//        super.onBackPressed();
//        finish();
//        startActivity(new Intent(this,  MainActivity.class));
    }*/
}
