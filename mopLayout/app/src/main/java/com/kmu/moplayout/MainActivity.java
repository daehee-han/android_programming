// Modified from
/*
 * CS 193A, Marty Stepp
 * This activity class represents the event handling and state
 * of our ninja turtle app.
 */


package com.kmu.moplayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    // 각 radion button 이 클릭될 때 불리는 event handler (callback) 함수

    public void pickTurtle(View view) {
        ImageView img = (ImageView) findViewById(R.id.turtle);
        if (view.getId() == R.id.leo) {
            img.setImageResource(R.drawable.tmntleo);
        } else if (view.getId() == R.id.mike) {
            img.setImageResource(R.drawable.tmntmike);
        } else if (view.getId() == R.id.don) {
            img.setImageResource(R.drawable.tmntdon);
        } else if (view.getId() == R.id.raph) {
            img.setImageResource(R.drawable.tmntraph);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
