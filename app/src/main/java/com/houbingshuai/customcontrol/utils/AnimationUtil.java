package com.houbingshuai.customcontrol.utils;

import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;

/**
 * Created by Administrator on 2016/8/4.
 */
public class AnimationUtil {
    public static void rotationRightHand(ImageButton iv_button) {
        AnimationSet animationSet = new AnimationSet(true);
        RotateAnimation rota = new RotateAnimation( //旋转画面
                0f, 120f,                          //从0度到120度顺时针旋转
                Animation.RELATIVE_TO_SELF, 0.5f,//相对于自己x轴旋转值也就是中心
                Animation.RELATIVE_TO_SELF, 0.5f); //相对于y轴旋转值
        rota.setDuration(350);
        ScaleAnimation scale = new ScaleAnimation( //渐变 -尺寸缩放
                1f,1f,                              //动画起始、结束时X坐标上的伸缩尺寸
                1f,1f,                              //动画起始、结束时Y坐标上的伸缩尺寸
                Animation.RELATIVE_TO_SELF, 0.5f,//相对于x轴旋转值
                Animation.RELATIVE_TO_SELF, 0.5f);
        animationSet.addAnimation(rota);
        animationSet.addAnimation(scale);
        iv_button.startAnimation(animationSet);
    }

    public static void rotationRight(ImageButton iv_button) {
        AnimationSet animationSet = new AnimationSet(true);
        RotateAnimation rota = new RotateAnimation(
                350f, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rota.setDuration(150);
        ScaleAnimation scale = new ScaleAnimation(
                1f,1f,
                1f,1f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animationSet.addAnimation(rota);
        animationSet.addAnimation(scale);
        iv_button.startAnimation(animationSet);
    }
}
