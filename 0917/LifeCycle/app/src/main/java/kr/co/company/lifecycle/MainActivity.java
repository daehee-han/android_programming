package kr.co.company.lifecycle;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        @Override
        public void onStart() {
            super.onStart();
            Log.i("LifeCycle", "onStart() 호출");
        }


        @Override
        public void onResume() {
            super.onResume();
            Log.i("LifeCycle", "onResume() 호출");
        }

        @Override
        public void onPause() {
            super.onPause();
            Log.i("LifeCycle", "onPause() 호출");
        }


        @Override
        public void onStop() {
            super.onStop();
            Log.i("LifeCycle", "onStop() 호출");
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            Log.i("LifeCycle", "onDestroy() 호출");
        }
    }
