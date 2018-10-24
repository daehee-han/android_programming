package kr.co.company.customcomponent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RatingBar ratingbar = (RatingBar)
                findViewById(R.id.ratingBar);

        VolumeControlView view = (VolumeControlView) findViewById(R.id.volume);
        view.setKnobListener(new VolumeControlView.KnobListener() {
            @Override
            public void onChanged(double angle) {
                float rating = ratingbar.getRating();
                if (angle > 0 && rating < 7.0)
                    // 오른쪽으로 회전
                    ratingbar.setRating(rating+1.0f);
                else if (rating > 0.0)
                    // 왼쪽으로 회전
                    ratingbar.setRating(rating-1.0f);
            }
        });
    }
}
