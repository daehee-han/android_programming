package kr.co.company.threadbasic1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
        Thread w;
        boolean running = true;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        @Override
        public void onStart() {
            super.onStart();
            w = new Thread(new Runnable() {
                public void run() {
                    int i = 0;
                    for (i = 0; i < 20 && running; i++) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                        }
                        Log.v("THREAD", "time=" + i);
                    }
                }
            });
            running = true;
            w.start();
        }

        @Override
        public void onStop() {
            super.onStop();
            running = false;
        }
    }