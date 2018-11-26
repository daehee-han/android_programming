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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class Student {

	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("email")
	@Expose
	private String email;
	@SerializedName("phone")
	@Expose
	private String phone;
	@SerializedName("age")
	@Expose
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}

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
					//downloadTask.execute(url.getText().toString());
					downloadTask.execute("http://10.0.2.2:9001/api/students");

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

			Log.i("RESPONSE", result);
			//Gson gson = new Gson();
			Gson gson = new GsonBuilder()
					.setLenient()
					.create();
			Student [] students = gson.fromJson("[{\"name\": \"kim\", \"email\": \"kim@gmail.com\", \"phone\": \"010-1234-0001\", \"age\": 10}]", Student[].class);
			Log.i("STUDENTS", students[0].getEmail());
		}
	}
}