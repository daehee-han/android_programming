package kr.co.company.mybroardcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void broadcastIntent(View view) {
        Intent intent = new Intent("kr.co.company.CUSTOM_INTENT");
        sendBroadcast(intent);
    }
}
