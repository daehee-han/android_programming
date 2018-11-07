package kr.co.company.mapspolyline;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.Arrays;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private static final LatLng SEOUL = new LatLng(37.566535, 126.977969);
    private static final LatLng DAEJEON = new LatLng(36.350412, 127.384548);
    private static final LatLng SUWEON = new LatLng(37.263573, 127.028601);
    private static final LatLng BUSAN = new LatLng(35.179554, 129.075642);
    private static final LatLng KWANGJU = new LatLng(35.159545, 126.852601);

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // 디폴트 옵션으로 간단한 폴리라인을 그려본다.
        mMap.addPolyline((new PolylineOptions())
                .add(SEOUL, BUSAN, DAEJEON));

        // 2개의 구멍을 가지는 사각형을 그린다.
        mMap.addPolygon(new PolygonOptions()
                .addAll(createRectangle(SEOUL, 1, 1))
                .addHole(createRectangle(SUWEON, 0.3, 0.3))
                .fillColor(Color.YELLOW)
                .strokeColor(Color.BLUE)
                .strokeWidth(5));

        // 지도의 중심을 움직인다.
        mMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
    }
    /**
     * 주어진 치수로 사각형을 형성하는 위도/경도 리스트를 생성한다.
     */
    private List<LatLng> createRectangle(LatLng center, double halfWidth,
                                         double halfHeight) {
        return Arrays.asList(
                new LatLng(center.latitude - halfHeight,	center.longitude - halfWidth),
                new LatLng(center.latitude - halfHeight, center.longitude + halfWidth),
                new LatLng(center.latitude + halfHeight, center.longitude + halfWidth),
                new LatLng(center.latitude + halfHeight, center.longitude - halfWidth),
                new LatLng(center.latitude - halfHeight,	center.longitude - halfWidth));
    }
}
