package kr.co.company.custombutton;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View target) {
        Toast.makeText(getApplicationContext(), "Beep Bop",
                Toast.LENGTH_SHORT).show();

    }
}
