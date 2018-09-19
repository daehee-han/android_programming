package kr.co.company.optionmenu1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuItem item1 = menu.add(0, 1, 0, "사과");
        item1.setIcon(R.drawable.ic_launcher);
        item1.setAlphabeticShortcut('a');
        menu.add(0, 2, 0, "포도").setIcon(R.drawable.ic_launcher);
        menu.add(0, 3, 0, "바나나").setIcon(R.drawable.ic_launcher);

        return true;
    }
}
