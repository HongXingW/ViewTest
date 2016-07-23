package com.example.whx.viewtest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

import com.nineoldandroids.view.ViewHelper;

/**
 * 跟随手指滑动的textview
 * Created by whx on 2016/7/23.
 */
public class SimpleView extends TextView{

    private static final String TAG = "SimpleView";

    private float mLastX = 0;
    private float mLastY = 0;

    public SimpleView(Context context) {
        super(context);
    }

    public SimpleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SimpleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getRawX();
        float y = event.getRawY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                float deltaX = x - mLastX;
                float deltaY = y - mLastY;
                Log.e(TAG,"move, deltaX: "+deltaX+" deltaY: "+deltaY);

                float translationX = ViewHelper.getTranslationX(this) + deltaX;
                float translationY = ViewHelper.getTranslationY(this) + deltaY;

                ViewHelper.setTranslationX(this,translationX);
                ViewHelper.setTranslationY(this,translationY);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }

        mLastX = x;
        mLastY = y;

        return true;
    }
}
