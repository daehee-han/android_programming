package de.vogella.android.sensor.compass;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity implements SensorEventListener {

	private static SensorManager sensorService;
	private MyCompassView compassView;
	private Sensor sensor;
	private Sensor accelerometer;
	private Sensor magnetometer;
	private float[] mGravity;
	private float[] mGeomagnetic;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		compassView = new MyCompassView(this);
		setContentView(compassView);

		sensorService = (SensorManager) XXXX(Context.SENSOR_SERVICE);
		accelerometer = sensorService.XXXX(Sensor.TYPE_ACCELEROMETER);
		magnetometer = sensorService.XXXX(Sensor.TYPE_MAGNETIC_FIELD);

		if (accelerometer == null || magnetometer == null)  {
			Log.e("Compass MainActivity", "No Sensor");
			Toast.makeText(this, "Sensor not found",
					Toast.LENGTH_LONG).show();
			//finish();
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		sensorService.XXXX(this, accelerometer, SensorManager.SENSOR_DELAY_UI);
		sensorService.XXXX(this, magnetometer, SensorManager.SENSOR_DELAY_UI);
	}

	@Override
	protected void onPause() {
		super.onPause();
		sensorService.XXXX(this);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {

	}

	@Override
	public void XXXX(SensorEvent event) {
		Log.i("Compass MainActivity", "Sensor event");
		Toast.makeText(this, "Sensor event", Toast.LENGTH_LONG).show();

		if (event.sensor.XXXX() == Sensor.TYPE_ACCELEROMETER)
			mGravity = event.values;
		if (event.sensor.XXXX() == Sensor.TYPE_MAGNETIC_FIELD)
			mGeomagnetic = event.values;
		if (mGravity != null && mGeomagnetic != null) {
			float R[] = new float[9];
			float I[] = new float[9];
			boolean success = SensorManager.getRotationMatrix(R, I, mGravity, mGeomagnetic);
			if (success) {
				float orientation[] = new float[3];
				SensorManager.getOrientation(R, orientation);
				float azimut = orientation[0]; // orientation contains: azimut, pitch and roll
				compassView.updateData(azimut);
			}
		}
	}
}