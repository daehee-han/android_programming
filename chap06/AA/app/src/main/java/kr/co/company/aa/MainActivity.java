package kr.co.company.aa;

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
    protected void onDraw(Canvas canvas)
    {
        Paint paint = new Paint();
        paint.setColor(0x88FF0000);

        paint.setAntiAlias(true);
        paint.setTextSize(80);

        canvas.drawText("앤티 에일리어싱 ON", 10, 100, paint);
        canvas.drawOval(new RectF(10,100,910,500), paint);

        paint.setAntiAlias(false);
        canvas.drawText("앤티 에일리어싱 OFF", 10, 600, paint);
        canvas.drawOval(new RectF(10,600,910,1000), paint);
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