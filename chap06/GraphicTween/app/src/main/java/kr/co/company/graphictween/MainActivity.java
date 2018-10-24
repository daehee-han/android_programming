package kr.co.company.graphictween;

import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout mLinearLayout;
    Animation anim;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 리니어 레이아웃을 생성한다.
        mLinearLayout = new LinearLayout(this);

        float[] array = new float[] { 20, 20, 20, 20, 20, 20, 20, 20 };
        ShapeDrawable rect = new ShapeDrawable(new RoundRectShape(array, null,
                null));
        rect.setIntrinsicHeight(300);
        rect.setIntrinsicWidth(600);
        rect.getPaint().setColor(Color.BLUE);

        ImageView i = new ImageView(this);
        i.setImageDrawable(rect); // 여기서 바로 설정하면 된다.
        i.setVisibility(View.VISIBLE);
        anim = AnimationUtils.loadAnimation(this, R.anim.rotate);
        i.startAnimation(anim);
        // ImageView를 레이아웃에 추가한다.
        mLinearLayout.addView(i);
        setContentView(mLinearLayout);

        // Load the appropriate animation
    }
}