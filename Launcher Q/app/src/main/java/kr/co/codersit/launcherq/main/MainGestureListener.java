package kr.co.codersit.launcherq.main;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by User on 2017-07-26.
 */

public class MainGestureListener extends GestureDetector.SimpleOnGestureListener {
    private void LOG(String str) { Log.i(getClass().getSimpleName(), str); }


    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {

        LOG("onDoubleTapEvent");

        return super.onDoubleTapEvent(e);
    }

    @Override
    public boolean onDown(MotionEvent e) {



        MainActivity.firstPoint.set((int)e.getX() , (int)e.getY());

        LOG("onDown");
        LOG("FIRST POINT : " + MainActivity.firstPoint.x + " " + MainActivity.firstPoint.y);

        return super.onDown(e);
    }


}
