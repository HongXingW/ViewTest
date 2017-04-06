package com.example.whx.viewtest.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * 一个自定义view动画类，实现view围绕 y 轴旋转，同时沿着 z 轴平移
 * Created by whx on 2016/11/9.
 */

public class Rotate3dAnimation extends Animation {

    private final float mFromDegree;
    private final float mToDegree;
    private final float mCenterX;
    private final float mCenterY;
    private final float mDepthZ;
    private final boolean mReverse;
    private Camera mCamera;

    /**
     * 构造方法
     * @param mFromDegree 开始角度
     * @param mToDegree 结束角度
     * @param mCenterX 旋转中心点的 x坐标
     * @param mCenterY 旋转中心点的 y坐标
     * @param mDepthZ z轴的平移长度
     * @param mReverse 动画是否翻转
     */
    public Rotate3dAnimation(float mFromDegree, float mToDegree, float mCenterX,
                             float mCenterY, float mDepthZ, boolean mReverse) {
        this.mFromDegree = mFromDegree;
        this.mToDegree = mToDegree;
        this.mCenterX = mCenterX;
        this.mCenterY = mCenterY;
        this.mDepthZ = mDepthZ;
        this.mReverse = mReverse;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mCamera = new Camera();
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {

        float degrees = mFromDegree + ((mToDegree - mFromDegree) * interpolatedTime);

        final float centerX = mCenterX;
        final float centerY = mCenterY;

        final Camera camera = mCamera;

        final Matrix matrix = t.getMatrix();

        camera.save();
        if(mReverse) {
            camera.translate(0f, 0f, mDepthZ * interpolatedTime);
        } else {
            camera.translate(0f, 0f, mDepthZ * (1f - interpolatedTime));
        }

        camera.rotateY(degrees);
        camera.getMatrix(matrix);
        camera.restore();

        matrix.preTranslate(-centerX, -centerY);
        matrix.postTranslate(centerX, centerY);

    }
}
