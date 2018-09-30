package kr.co.company.sensorreading;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MyReceiver myReceiver=null;

    Intent i;
    static final String LOG_TAG = "ServiceActivity";
    TextView textfield;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textfield = (TextView) findViewById(R.id.editText);

        // 서비스를 시작한다.
        i= new Intent(this, SimpleService.class);
        startService(i);
        Log.d( LOG_TAG, "onCreate/startService" );
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(LOG_TAG, "onResume/registering receiver");
        myReceiver = new MyReceiver();

        // 서비스로부터 가속도 센서 값을 받을 수 있도록 방송수신자를 등록한다.
        IntentFilter filter = new IntentFilter();
        filter.addAction(SimpleService.MY_ACTION);
        registerReceiver(myReceiver, filter);
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d( LOG_TAG, "onPause/unregistering receiver" );
        stopService(i);

        if (myReceiver != null){
            unregisterReceiver(myReceiver);
            myReceiver = null;
        }
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d( LOG_TAG, "onStop" );
        if (myReceiver != null) {
            unregisterReceiver (myReceiver);
            myReceiver = null;
        }
        stopService(i);
    }
}
