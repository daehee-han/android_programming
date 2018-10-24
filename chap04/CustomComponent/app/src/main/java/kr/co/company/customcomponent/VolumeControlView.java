package kr.co.company.customcomponent;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class VolumeControlView extends ImageView implements View.OnTouchListener {

    private double angle = 0.0;
    private KnobListener listener;
    float x, y;
    float mx, my;

    public interface KnobListener {
        public void onChanged(double angle);
    }

    public void setKnobListener(KnobListener lis) {
        listener = lis;
    }

    public VolumeControlView(Context context) {
        super(context);
        this.setImageResource(R.drawable.knob);
        this.setOnTouchListener(this);
    }

    public VolumeControlView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setImageResource(R.drawable.knob);
        this.setOnTouchListener(this);
    }

    private double getAngle(float x, float y) {
        mx = x - (getWidth() / 2.0f);
        my = (getHeight() / 2.0f) - y;

        double degree = Math.atan2(mx, my) * 180.0 / 3.141592;
        return degree;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX(0);
        y = event.getY(0);
        angle = getAngle(x, y);
        invalidate();
        listener.onChanged(angle);

        return true;
    }

    protected void onDraw(Canvas c) {
        Paint paint = new Paint();
        //c.save();
        c.rotate((float) angle, getWidth() / 2, getHeight() / 2);
        super.onDraw(c);
        //c.restore();
    }
}
