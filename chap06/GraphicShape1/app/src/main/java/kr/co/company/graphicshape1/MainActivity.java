package kr.co.company.graphicshape1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
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
        paint.setColor(Color.YELLOW);

        canvas.drawColor(Color.BLUE);
        canvas.drawRoundRect(new RectF(30,50,330,550), 15, 15, paint);
        canvas.drawOval(new RectF(450,50,750,550), paint);
        paint.setColor(Color.RED);
        canvas.drawArc(new RectF(30,600,330,1100), 360, 1000,
                true, paint);
        paint.setColor(Color.YELLOW);
        float[] pts={ 30, 1250, 300, 1350, 300, 1350, 60, 1450,
                60, 1450, 360, 1500};
        paint.setStrokeWidth(10);
        canvas.drawLines(pts, paint);
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView w = new MyView(this);
        setContentView(w);
    }
}
