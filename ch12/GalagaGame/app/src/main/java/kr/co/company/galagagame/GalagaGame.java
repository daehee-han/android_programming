package kr.co.company.galagagame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

public class GalagaGame extends SurfaceView implements  SurfaceHolder.Callback {

 private static final String TAG = GalagaGame.class.getSimpleName();

 private MainThread thread;
 private boolean running = true;

 ArrayList sprites = new ArrayList();
 Sprite starship;
 Bitmap shipImage, alienImage, shotImage;


 public GalagaGame(Context context) {
  super(context);
  // adding the callback (this) to the surface holder to intercept events
  getHolder().addCallback(this);

  // create droid and load bitmap
   shipImage = BitmapFactory.decodeResource(getResources(), R.drawable.starship);
   shotImage = BitmapFactory.decodeResource(getResources(), R.drawable.fire);
   alienImage = BitmapFactory.decodeResource(getResources(), R.drawable.alien);

   initSprites();
  // create the game loop thread
  thread = new MainThread(getHolder(), this);

  // make the GamePanel focusable so it can handle events
  setFocusable(true);
 }

 @Override
 public void surfaceChanged(SurfaceHolder holder, int format, int width,
   int height) {
 }

 @Override
 public void surfaceCreated(SurfaceHolder holder) {
  // at this point the surface is created and
  // we can safely start the game loop
  thread.setRunning(true);
  thread.start();
 }

 @Override
 public void surfaceDestroyed(SurfaceHolder holder) {
  Log.d(TAG, "Surface is being destroyed");
  // tell the thread to shut down and wait for it to finish
  // this is a clean shutdown
  boolean retry = true;
  while (retry) {
   try {
    thread.join();
    retry = false;
   } catch (InterruptedException e) {
    // try again shutting down the thread
   }
  }
  Log.d(TAG, "Thread was shut down cleanly");
 }

 private void initSprites() {
  starship = new StarShipSprite(this, shipImage, 370, 1550);
  sprites.add(starship);
  for (int y = 0; y < 3; y++) {
   for (int x = 0; x < 10; x++) {
    Sprite alien = new AlienSprite(this, alienImage,
            100 + (x * 100), (50) + y * 80);
    sprites.add(alien);
   }
  }
 }
 private void startGame() {
  sprites.clear();
  initSprites();
 }

 public void endGame() {
  // System.exit(0);
 }

 public void removeSprite(Sprite sprite) {
  sprites.remove(sprite);
 }

 public void fire() {
  ShotSprite shot = new ShotSprite(this, shotImage, starship.getX() + 10,
          starship.getY() - 30);
  sprites.add(shot);
 }

 @Override
 public boolean onTouchEvent(MotionEvent event) {
  if (event.getAction() == MotionEvent.ACTION_DOWN)
    fire();
   return true;
 }

 public void paint(Canvas g) {
  g.drawColor(Color.BLACK);
   for (int i = 0; i < sprites.size(); i++) {
    Sprite sprite = (Sprite) sprites.get(i);
    sprite.draw(g);
   }
  }
}