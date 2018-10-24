package kr.co.company.audioplay1;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AudioPlay1Activity extends Activity {

	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	    	Button playButton = (Button) findViewById(R.id.play);
			playButton.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Intent intent =new Intent(Intent.ACTION_VIEW);
					Uri uri = Uri.parse("file:///sdcard/old_pop.mp3");
					intent.setDataAndType(uri, "audio/mp3");
					startActivity(intent);
				}
			});
	    }
	}