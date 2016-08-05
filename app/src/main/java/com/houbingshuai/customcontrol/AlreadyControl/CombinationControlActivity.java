package com.houbingshuai.customcontrol.AlreadyControl;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageButton;

import com.houbingshuai.customcontrol.R;
import com.houbingshuai.customcontrol.utils.AnimationUtil;

/**
 * Created by Administrator on 2016/8/4.
 */
public class CombinationControlActivity extends Activity {

    private ImageButton iv_button;
    private boolean isBackKey = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.already_control_main);
        initView();
        initData();
    }

    private void initView() {
        iv_button = findView(R.id.iv_button);
    }

    private void initData() {
        iv_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationUtil.rotationRightHand(iv_button);
                new Thread(new Runnable() {//为了体现效果，延迟350毫秒显示，增加了一个线程
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(350);
                            handler.sendEmptyMessage(0);//在线程中不能直接修改控件背景，所以启用了handler

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            AnimationUtil.rotationRight(iv_button);
            if (isBackKey) { //如果是返回键，点击之后转变成菜单键
                isBackKey = false;
                iv_button.setImageDrawable(getResources().getDrawable(R.mipmap.menu));
            } else {//否者如果是菜单键，点击之后转变成返回键
                isBackKey = true;
                iv_button.setImageDrawable(getResources().getDrawable(R.mipmap.back));
            }
        }
    };

    protected <T extends View> T findView(int id) {
        //return返回view时,加上泛型T
        return (T) findViewById(id);
    }
}
