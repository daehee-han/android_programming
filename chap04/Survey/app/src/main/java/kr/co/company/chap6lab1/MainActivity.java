package kr.co.company.chap6lab1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
        RadioGroup group;
        RadioButton button1, button2, button3;
        Button button;
        ImageView image;

        View.OnClickListener radio_listener = new View.OnClickListener() {
            public void onClick(View arg0) {
                switch (group.getCheckedRadioButtonId()) {
                    case R.id.radio0:
                        image.setImageResource(R.drawable.image0);
                        break;
                    case R.id.radio1:
                        image.setImageResource(R.drawable.image1);
                        break;
                    case R.id.radio2:
                        image.setImageResource(R.drawable.image2);
                        break;
                }
            }
        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            setTitle("Survey");

            group = (RadioGroup) findViewById(R.id.radioGroup1);
            button1 = (RadioButton) findViewById(R.id.radio0);
            button2 = (RadioButton) findViewById(R.id.radio1);
            button3 = (RadioButton) findViewById(R.id.radio2);

            button1.setOnClickListener(radio_listener);
            button2.setOnClickListener(radio_listener);
            button3.setOnClickListener(radio_listener);

            button = (Button) findViewById(R.id.button1);
            image = (ImageView) findViewById(R.id.imageView1);

        }

    }