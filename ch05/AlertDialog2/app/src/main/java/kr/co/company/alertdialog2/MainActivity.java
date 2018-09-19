package kr.co.company.alertdialog2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int DIALOG_YES_NO_MESSAGE = 1;

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOG_YES_NO_MESSAGE:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("종료 확인 대화 상자")
                        .setMessage("애플리케이션을 종료하시겠습니까?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", // Yes 버튼
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int whichButton) {
                                        MainActivity.this.finish();
                                    }
                                })
                        .setNegativeButton("No",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int whichButton) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                return alert;
        }
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("LifeCycle", "onCreate() 호출");
        int restored = -1;
        if (savedInstanceState != null) {
            restored = savedInstanceState.getInt("count", -1);
        }
        Log.i("onCreate()", "count=" + restored);

        Button b = (Button) findViewById(R.id.Button01);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DIALOG_YES_NO_MESSAGE);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        int count = 100;
        outState.putInt("count", count);
        Log.i("onSaveInstanceState()", "count=" + count);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("LifeCycle", "onStart() 호출");
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.i("LifeCycle", "onRestart() 호출");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("LifeCycle", "onResume() 호출");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("LifeCycle", "onPause() 호출");
    }


    @Override
    public void onStop() {
        super.onStop();
        Log.i("LifeCycle", "onStop() 호출");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("LifeCycle", "onDestroy() 호출");
    }


}