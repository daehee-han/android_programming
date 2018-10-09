package kr.co.company.mylunarlander;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    /** A handle to the thread that's actually running the animation. */
    private LunarView.LunarThread mLunarThread;

    /** A handle to the View in which the game is running. */
    private LunarView mLunarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // tell system to use the layout defined in our XML file
        setContentView(R.layout.activity_main);

        // get handles to the LunarView from XML, and its LunarThread
        mLunarView = (LunarView) findViewById(R.id.lunar);
        mLunarThread = mLunarView.getThread();

    }

    /**
     * Invoked when the Activity loses user focus.
     */
    @Override
    protected void onPause() {
        super.onPause();
        mLunarView.getThread().pause(); // pause game when Activity pauses
    }

    /**
     * Notification that something is about to happen, to give the Activity a
     * chance to save state.
     *
     * @param outState a Bundle into which this Activity should save its state
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // just have the View's thread save its state into our Bundle
        super.onSaveInstanceState(outState);
        mLunarThread.saveState(outState);
    }
}
