package kr.co.company.sensorreading;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
// 소스만 입력하고 Alt+Enter를 눌러서 import 문장을 자동으로 생성한다.

public class MyReceiver extends BroadcastReceiver {
    static final String LOG_TAG = "MyReceiver";

    @Override
    public void onReceive(Context arg0, Intent arg1){
        String measurement = arg1.getStringExtra("measurement");
        Log.d(LOG_TAG, "onReceive"+measurement);
    }
}