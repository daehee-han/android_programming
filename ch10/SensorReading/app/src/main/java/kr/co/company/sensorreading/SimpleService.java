package kr.co.company.sensorreading;
// 소스만 입력하고 Alt+Enter를 눌러서 import 문장을 자동으로 생성한다.

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class SimpleService extends Service implements SensorEventListener {
    final static String MY_ACTION = "kr.co.company.sensorreading.SimpleService.MY_ACTION";
    private TextView output;
    private String reading;
    private SensorManager mgr;
    private List<Sensor> sensorList;
    static final String LOG_TAG = "SimpleService";
    Intent intent = new Intent("kr.co.company.sensorreading.SimpleService.MY_ACTION");

    @Override
    public void onCreate() {
        Log.d(LOG_TAG, "onStartCommand");
        mgr = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorList = mgr.getSensorList(Sensor.TYPE_ACCELEROMETER);
        for (Sensor sensor : sensorList) {
            mgr.registerListener(this, sensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    public void onDestroy() {
        Log.d( LOG_TAG, "onDestroy" );
        mgr.unregisterListener(this);
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.d( LOG_TAG, "onSensorChanged" );
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < event.values.length; i++) {
            builder.append("   [");
            builder.append(i);
            builder.append("] = ");
            builder.append(event.values[i]);
            builder.append("\n");
        }

        reading=builder.toString();

        // 센서값을 액티비티로 보낸다.
        intent.putExtra("measurement", reading);
        sendBroadcast(intent);
    }

}