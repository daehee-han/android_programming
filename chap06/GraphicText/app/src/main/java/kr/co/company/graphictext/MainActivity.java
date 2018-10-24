package kr.co.company.graphictext;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

class MyView extends View {
    public MyView(Context context) {
        super(context);
        setBackgroundColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(100);

        Typeface t;
        t = Typeface.create(Typeface.DEFAULT, Typeface.NORMAL);
        paint.setTypeface(t);
        canvas.drawText("DEFAULT 폰트", 10, 400, paint);

        t = Typeface.create(Typeface.DEFAULT_BOLD, Typeface.NORMAL);
        paint.setTypeface(t);
        canvas.drawText("DEFAULT_BOLD 폰트", 10, 600, paint);

        t = Typeface.create(Typeface.MONOSPACE, Typeface.NORMAL);
        paint.setTypeface(t);
        canvas.drawText("MONOSPACE 폰트", 10, 800, paint);

        t = Typeface.create(Typeface.SERIF, Typeface.NORMAL);
        paint.setTypeface(t);
        canvas.drawText("SERIF 폰트", 10, 1000, paint);

        t = Typeface.create(Typeface.SANS_SERIF, Typeface.NORMAL);
        paint.setTypeface(t);
        canvas.drawText("SANS_SERIF 폰트", 10, 1200, paint);
    }
}

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView w = new MyView(this);
        setContentView(w);
    }
}