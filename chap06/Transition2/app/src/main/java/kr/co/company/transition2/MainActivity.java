package kr.co.company.transition2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.AutoTransition;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layout;
    private Button fadeButton, slideButton, explodeButton;
    private ImageView imageView, imageView2;
    boolean visible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = (LinearLayout) findViewById(R.id.layout);
        fadeButton = (Button) findViewById(R.id.fade);
        slideButton = (Button) findViewById(R.id.slide);
        explodeButton = (Button) findViewById(R.id.explode);
        imageView = (ImageView) findViewById(R.id.imageview);

        fadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(layout, new Fade());
                visible = !visible;
                imageView.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });
        slideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(layout, new Slide());
                visible = !visible;
                imageView.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });
        explodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(layout, new Explode());
                visible = !visible;
                imageView.setVisibility(visible ? View.VISIBLE : View.GONE);
            }
        });
    }
}