package com.houbingshuai.customcontrol.ExtendControl;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/8/9.
 * 步骤
 * 1.测量--onMeasure（指定控件宽高）
 * 2.摆放--onLayout（其中View没有此步骤，ViewGroup有此步骤，摆放所有控件）
 * 3.绘制--onDraw（绘制控件内容）
 */
public class ExtendTextView extends TextView {
    Paint paint1, paint2;
    Canvas canvas;
    private String controlText;
    onChangedTextListener changedTextListener;

    /**
     * 用于代码创建控件
     *
     * @param context
     */
    public ExtendTextView(Context context) {
        super(context);
        initView();
    }

    /**
     * 用于xml使用，可以自定义属性
     *
     * @param context
     * @param attrs
     */
    public ExtendTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    /**
     * 用于xml使用，可以自定义属性，如果制定了样式，走此构造函数
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public ExtendTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ExtendTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    private void initView() {
        canvas = new Canvas();
        paint1 = new Paint();
        paint1.setColor(Color.BLUE);
        paint1.setStyle(Paint.Style.FILL);
        paint2 = new Paint();
        paint2.setColor(Color.YELLOW);
        paint2.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint1);
        canvas.drawRect(10, 10, getMeasuredWidth() - 10, getMeasuredHeight() - 10, paint2);
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
    }


    public void setControlText(String controlText) {
        this.controlText = controlText;
        setText(controlText);
    }

    public void setChangedText(onChangedTextListener changedTextListener) {
        this.changedTextListener = changedTextListener;
    }

    public interface onChangedTextListener {
        void onChangedUpload(String s);
    }


    //重新触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_UP: //当手抬起时响应事件
                if (changedTextListener != null) {
                    changedTextListener.onChangedUpload("7654321");
                }
                break;

        }
        invalidate();//重新绘制界面
        return true;//消费用户触摸事件，才可以收到其他事件
    }
}
