package kr.co.company.galagagame;


import android.graphics.Bitmap;

public class StarShipSprite extends Sprite {
	private GalagaGame game;

	public StarShipSprite(GalagaGame game, Bitmap image, int x, int y) {
		super(image, x, y);
		this.game = game;
		dx = 0;
		dy = 0;
	}

	@Override
	public void move() {
		if ((dx < 0) && (x < 10)) {
			return;
		}
		if ((dx > 0) && (x > 800)) {
			return;
		}
		super.move();
	}

	@Override
	public void handleCollision(Sprite other) {
		if (other instanceof AlienSprite) {
			game.endGame();
		}
	}
}