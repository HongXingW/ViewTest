package com.example.whx.viewtest;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.whx.viewtest.animation.Rotate3dAnimation;


/**
 * Created by whx on 2016/7/23.
 */
public class SimpleDemoActivity extends AppCompatActivity{

    private static final String TAG = "SimpleDemoActivity";

    private ImageView imageView;
    private Button button, animatorBtn;
    private ImageView gifView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        imageView = (ImageView) findViewById(R.id.image);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rotate3dAnimation rotate3dAnimation = new Rotate3dAnimation(15f,90f,250,250,200,false);
                rotate3dAnimation.setDuration(3000);
                //rotate3dAnimation.setFillAfter(true);

                button.startAnimation(rotate3dAnimation);
                // TODO: 2016/11/9 动画执行完后crash
            }
        });

        gifView = (ImageView) findViewById(R.id.gif_view);
        AnimationDrawable drawable = (AnimationDrawable) gifView.getDrawable();
        drawable.start();

        animatorBtn = (Button) findViewById(R.id.animator);
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.property_animation);
        set.setTarget(animatorBtn);
        set.start();


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation_test);
        imageView.startAnimation(animation);

        super.onWindowFocusChanged(hasFocus);
    }
}
