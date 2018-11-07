package kr.co.company.mapsintent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MapsIntentActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Uri uri = Uri.parse(String.format("geo:%f,%f?z=10", 37.30, 127.2));
		startActivity(new Intent(Intent.ACTION_VIEW, uri));
	}
}