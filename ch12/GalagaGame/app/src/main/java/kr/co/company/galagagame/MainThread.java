package kr.co.company.galagagame;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class MainThread extends Thread {

    private static final String TAG = MainThread.class.getSimpleName();

    private SurfaceHolder surfaceHolder;
    private GalagaGame gamePanel;
    private boolean running;
    public void setRunning(boolean running) {
        this.running = running;
    }

    public MainThread(SurfaceHolder surfaceHolder, GalagaGame gamePanel) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gamePanel = gamePanel;
    }

    @Override
    public void run() {
        long tickCount = 0L;
        Log.d(TAG, "Starting game loop");
        while (running) {
            tickCount++;
                for (int i = 0; i < gamePanel.sprites.size(); i++) {
                    Sprite sprite = (Sprite) gamePanel.sprites.get(i);
                    sprite.move();
                }

                for (int p = 0; p < gamePanel.sprites.size(); p++) {
                    for (int s = p + 1; s < gamePanel.sprites.size(); s++) {
                        Sprite me = (Sprite) gamePanel.sprites.get(p);
                        Sprite other = (Sprite) gamePanel.sprites.get(s);

                        if (me.checkCollision(other)) {
                            me.handleCollision(other);
                            other.handleCollision(me);
                        }
                    }
                }
            Canvas canvas = null;
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.gamePanel.paint(canvas);
                }
            } finally {
                if (canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            } // end finally
        }
        Log.d(TAG, "Game loop executed " + tickCount + " times");
    }
}