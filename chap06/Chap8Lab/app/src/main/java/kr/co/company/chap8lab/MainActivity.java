package kr.co.company.chap8lab;
// 소스만 입력하고 Alt+Enter를 눌러서 import 문장을 자동으로 생성한다.

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MyView mMyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMyView = (MyView) findViewById(R.id.myview);
    }

    public void redraw(View v) {
        mMyView.invalidate();
    }
}