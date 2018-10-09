package kr.co.company.webdownload;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button btnDownload = (Button) findViewById(R.id.download);
		OnClickListener downloadListener = new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isNetworkAvailable()) {
					EditText url = (EditText) findViewById(R.id.url);
					DownloadTask downloadTask = new DownloadTask();
					downloadTask.execute(url.getText().toString());

				} else {
					Toast.makeText(getBaseContext(),
							"Network is not Available", Toast.LENGTH_SHORT)
							.show();
				}
			}

		};
		btnDownload.setOnClickListener(downloadListener);
	}

	private boolean isNetworkAvailable() {
		boolean available = false;
		ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		if (networkInfo != null && networkInfo.isAvailable())
			available = true;

		return available;
	}

	private String downloadUrl(String strUrl) throws IOException {
		String s = null;
		byte[] buffer = new byte[1000];
		InputStream iStream = null;
		try {
			URL url = new URL(strUrl);
			HttpURLConnection urlConnection = (HttpURLConnection) url
					.openConnection();

			urlConnection.connect();

			iStream = urlConnection.getInputStream();
			iStream.read(buffer);
			s = new String(buffer);
		} catch (Exception e) {
			Log.d("Exception download", e.toString());
		} finally {
			iStream.close();

		}
		return s;
	}

	private class DownloadTask extends AsyncTask<String, Integer, String> {
		String s = null;

		@Override
		protected String doInBackground(String... url) {

			try {
				s = downloadUrl(url[0]);
			} catch (Exception e) {
				Log.d("Background Task", e.toString());
			}
			return s;
		}

		@Override
		protected void onPostExecute(String result) {
			TextView tView = (TextView) findViewById(R.id.text);
			tView.setText(result);
			Toast.makeText(getBaseContext(),
					"Web page downloaded successfully", Toast.LENGTH_SHORT)
					.show();
		}
	}
}