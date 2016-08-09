package com.houbingshuai.customcontrol.ExtendControl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.houbingshuai.customcontrol.R;

/**
 * Created by Administrator on 2016/8/5.
 */
public class ExtendControl extends Activity {
    ExtendTextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extend_control_main);

        tv = (ExtendTextView) findViewById(R.id.tv_example);
        tv.setControlText("1234567");
    }
}
