package kr.co.company.galagagame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

// �ҽ��� �Է��ϰ� Ctrl+Shift+O�� ������.
public class Sprite {
	protected int x; // ���� ��ġ�� x��ǥ
	protected int y; // ���� ��ġ�� y��ǥ
	protected int dx; // �����ð��� �����̴� x���� �Ÿ�
	protected int dy; // �����ð��� �����̴� y���� �Ÿ�
	private Bitmap image; // ��������Ʈ�� ������ �ִ� �̹���

	// ������
	public Sprite(Bitmap image, int x, int y) {
		this.image = image;
		this.x = x;
		this.y = y;
	}

	// ��������Ʈ�� ���� ���̸� ��ȯ�Ѵ�.
	public int getWidth() {
		return image.getWidth();
	}

	// ��������Ʈ�� ���� ���̸� ��ȯ�Ѵ�.
	public int getHeight() {
		return image.getHeight();
	}

	// ��������Ʈ�� ȭ�鿡 �׸���.
	public void draw(Canvas g) {
		g.drawBitmap(image, x, y, null);
	}

	// ��������Ʈ�� �����δ�.
	public void move() {
		x += dx;
		y += dy;
	}

	// dx�� �����Ѵ�.
	public void setDx(int dx) {
		this.dx = dx;
	}

	// dy�� �����Ѵ�.
	public void setDy(int dy) {
		this.dy = dy;
	}

	// dx�� ��ȯ�Ѵ�.
	public int getDx() {
		return dx;
	}

	// dy�� ��ȯ�Ѵ�.
	public int getDy() {
		return dy;
	}

	// x�� ��ȯ�Ѵ�.
	public int getX() {
		return x;
	}

	// y�� ��ȯ�Ѵ�.
	public int getY() {
		return y;
	}

	// �ٸ� ��������Ʈ���� �浹 ���θ� ����Ѵ�. �浹�̸� true�� ��ȯ�Ѵ�.
	public boolean checkCollision(Sprite other) {
		Rect myRect = new Rect(x, y, getWidth(), getHeight());
		Rect otherRect = new Rect(other.getX(), other.getY(), other.getWidth(),
				other.getHeight());
		return myRect.intersect(otherRect);
	}

	// �浹�� ó���Ѵ�.
	public void handleCollision(Sprite other) {

	}
}