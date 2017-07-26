package kr.co.codersit.launcherq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout rl_before_screen;
    RelativeLayout rl_after_screen;

    Button bt_testbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();






    }

    private void initViews() {

        //test btn

        bt_testbtn= (Button)findViewById(R.id.ac_main_bt_testbtn);

        ////

        rl_before_screen = (RelativeLayout)findViewById(R.id.ac_main_rl_before_screen);
        rl_after_screen = (RelativeLayout)findViewById(R.id.ac_main_rl_after_screen);







    }
}
