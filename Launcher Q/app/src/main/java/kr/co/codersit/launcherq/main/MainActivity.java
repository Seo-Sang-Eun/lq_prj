package kr.co.codersit.launcherq.main;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.codersit.launcherq.R;

public class MainActivity extends AppCompatActivity {
    private void LOG(String str) { Log.i(getClass().getSimpleName(), str); }

    private RelativeLayout rl_before_screen;
    private RelativeLayout rl_after_screen;

    private Button bt_testbtn;

    private TextView tv_date;
    private TextView tv_battery;
    private TextView tv_isam;
    private TextView tv_time;

    private Context mContext = this;

    private GestureDetector mGestureDetector;

    private int deviceWidth;
    private int deviceHeight;
    private int deviceRealWidth;
    private int deviceRealHeight;

    private int statusBarHeight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initListener();

        // need oders
        initViews();
        initOnclick();
        initValues();
    }

    private void initValues() {

        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowmanager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        windowmanager.getDefaultDisplay().getMetrics(displayMetrics);

        deviceWidth = displayMetrics.widthPixels;
        deviceHeight = displayMetrics.heightPixels;

        windowmanager.getDefaultDisplay().getRealMetrics(displayMetrics);

        deviceRealWidth = displayMetrics.widthPixels;
        deviceRealHeight = displayMetrics.heightPixels;

        statusBarHeight = deviceRealHeight - deviceHeight;



        firstPoint = new Point();
        curPoint = new Point();
    }

    private void initListener() {
        mGestureDetector = new GestureDetector(mContext,new MainGestureListener( ));
    }


    private void initViews() {

        //test btn

        bt_testbtn= (Button)findViewById(R.id.ac_main_bt_testbtn);

        ////

        rl_before_screen = (RelativeLayout)findViewById(R.id.ac_main_rl_before_screen);
        rl_after_screen = (RelativeLayout)findViewById(R.id.ac_main_rl_after_screen);

        tv_date = (TextView) findViewById(R.id.inc_main_screen_tv_date);
        tv_battery = (TextView) findViewById(R.id.inc_main_screen_tv_battery);
        tv_isam = (TextView) findViewById(R.id.inc_main_screen_tv_isam);
        tv_time = (TextView) findViewById(R.id.inc_main_screen_tv_time);

    }


    private void initOnclick() {


        bt_testbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//////////////////////   TEST BTN   //////////////////////





            }
        });


    }

    public static Point firstPoint;

    private Point curPoint;

    private final int START_MOTION_DISTANCE = 100;

    private final int ICON_DISTANCE = 200;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetector.onTouchEvent(event);

        curPoint.set((int)event.getX() , (int)event.getY());

        if( Math.sqrt( (double)( Math.pow( (double)(curPoint.x - firstPoint.x ),(double)2) + Math.pow( (double)(curPoint.y - firstPoint.y ),(double)2)) ) > START_MOTION_DISTANCE )
        {
            LOG("arrive START_MOTION_DISTANCE");

            rl_after_screen.setVisibility(View.VISIBLE);

            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);


            ImageView imageView1 = new ImageView(this);
            imageView1.setImageResource(R.drawable.b);
            imageView1.setPadding(  firstPoint.x - ICON_DISTANCE , firstPoint.y - ICON_DISTANCE  ,0,0);
            imageView1.setLayoutParams(layoutParams);

            ImageView imageView2 = new ImageView(this);
            imageView2.setImageResource(R.drawable.r);
            imageView2.setPadding(  firstPoint.x , firstPoint.y + statusBarHeight  ,0,0);
            imageView2.setLayoutParams(layoutParams);

            LOG(statusBarHeight + " << ");




            rl_after_screen.addView(imageView1);
            rl_after_screen.addView(imageView2);






















        }







        return super.onTouchEvent(event);
    }


}
