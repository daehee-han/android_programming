package kr.co.company.videoplay;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.net.Uri;
import android.os.Environment;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main);

        VideoView videoview = (VideoView)this.findViewById(R.id.videoview);
        MediaController mc = new MediaController(this);
        videoview.setMediaController(mc);
		String folder = Environment.getExternalStorageDirectory().getAbsolutePath();

		//videoview.setVideoURI(Uri.parse("http://media.w3.org/2010/05/sintel/trailer.mp4"));
		videoview.setVideoPath(folder + "/trailer.mp4");
        videoview.requestFocus();
        videoview.start();
    }
}
 