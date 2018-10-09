package kr.co.company.imagedownload;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnDownload = (Button) findViewById(R.id.btn_download);

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText etUrl = (EditText) findViewById(R.id.et_url);
                final ImageView iView = (ImageView) findViewById(R.id.iv_image);
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            URL url = new URL(etUrl.getText().toString());
                            HttpURLConnection urlConnection = (HttpURLConnection) url
                                    .openConnection();
                            urlConnection.connect();
                            InputStream iStream = urlConnection.getInputStream();
                            final Bitmap bitmap = BitmapFactory.decodeStream(iStream);
                            iView.post(new Runnable() {
                                @Override
                                public void run() {
                                    iView.setImageBitmap(bitmap);
                                }
                            });
                        } catch (Exception e) {
                            Toast.makeText(getBaseContext(), "Image downloaded error",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });

                t.start();

            }
        });
    }
}

