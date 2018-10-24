package kr.co.company.pingpong;
// 소스만 입력하고 Alt+Enter를 눌러서 import 문장을 자동으로 생성한다.


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

//움직이는 공을 나타내는 클래스
class Ball {
	int x, y, xInc = 1, yInc = 1; // xInc와 yInc는 한번에 움직이는 거리이다.
	int diameter; // 공의 반지름
	static int WIDTH = 1080, HEIGHT = 1920; // 움직이는 공간의 크기

	public Ball(int d) { // 생성자
		this.diameter = d;

		// 볼의 위치를 랜덤하게 설정
		x = (int) (Math.random() * (WIDTH - d) + 3);
		y = (int) (Math.random() * (HEIGHT - d) + 3);

		// 한번에 움직이는 거리도 랜덤하게 설정
		xInc = (int) (Math.random() * 30 + 1);
		yInc = (int) (Math.random() * 30 + 1);

	}

	// 여기서 공을 그린다.
	public void paint(Canvas g) {
		Paint paint = new Paint();

		// 벽이 부딪치면 반사하게 한다.
		if (x < diameter || x > (WIDTH - diameter))
			xInc = -xInc;
		if (y < diameter || y > (HEIGHT - diameter))
			yInc = -yInc;

		// 볼의 좌표를 갱신한다.
		x += xInc;
		y += yInc;

		// 볼을 화면에 그린다.
		paint.setColor(Color.RED);
		g.drawCircle(x, y, diameter, paint);
	}
}

// 서피스 뷰 정의
public class MySurfaceView extends SurfaceView implements
		SurfaceHolder.Callback {
	public Ball basket[] = new Ball[10]; // Ball의 배열 선언
	private MyThread thread; // 스레드 참조 변수

	public MySurfaceView(Context context) { // 생성자
		super(context);

		SurfaceHolder holder = getHolder(); // 서피스 뷰의 홀더를 얻는다.
		holder.addCallback(this); // 콜백 메소드를 처리한다.

		thread = new MyThread(holder); // 스레드를 생성한다.

		// Ball 객체를 생성하여서 배열에 넣는다.
		for (int i = 0; i < 10; i++)
			basket[i] = new Ball(100);
	}

	public MyThread getThread() {
		return thread;
	}

	public void surfaceCreated(SurfaceHolder holder) {
		// 스레드를 시작한다.
		thread.setRunning(true);
		thread.start();
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;

		// 스레드를 중지시킨다.
		thread.setRunning(false);
		while (retry) {
			try {
				thread.join(); // 메인 스레드와 합친다.
				retry = false;
			} catch (InterruptedException e) {
			}
		}
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
							   int height) {
		// Ball.WIDTH = width;
		// Ball.HEIGHT = height;
	}

	// 스레드를 내부 클래스로 정의한다.
	public class MyThread extends Thread {

		private boolean mRun = false;
		private SurfaceHolder mSurfaceHolder;

		public MyThread(SurfaceHolder surfaceHolder) {
			mSurfaceHolder = surfaceHolder;
		}

		@Override
		public void run() {
			while (mRun) {
				Canvas c = null;
				try {
					c = mSurfaceHolder.lockCanvas(null); // 캔버스를 얻는다.
					c.drawColor(Color.BLACK); // 캔버스의 배경을 지운다.
					synchronized (mSurfaceHolder) {
						for (Ball b : basket) { // basket의 모든 원소를 그린다.
							b.paint(c);
						}
					}
				} finally {
					if (c != null) {
						// 캔버스의 로킹을 푼다.
						mSurfaceHolder.unlockCanvasAndPost(c);
					}
				}
				// try { Thread.sleep(100); } catch (InterruptedException e) { }
			}
		}

		public void setRunning(boolean b) {
			mRun = b;
		}
	}
}