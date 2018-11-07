package kr.co.company.locationtest1;
// 소스만 입력하고 Alt+Enter를 눌러서 import 문장을 자동으로 생성한다.

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView status;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        status = (TextView) findViewById(R.id.status);

        LocationManager locationManager = (LocationManager) this
                .getSystemService(Context.LOCATION_SERVICE);


        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                status.setText("위도; " + location.getLatitude() + "\n경도:"
                        + location.getLongitude() + "\n고도:"
                        + location.getAltitude());
            }

            public void onStatusChanged(String provider, int status,
                                        Bundle extras) {
            }

            public void onProviderEnabled(String provider) {

            }

            public void onProviderDisabled(String provider) {
            }
        };


        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

    }
}