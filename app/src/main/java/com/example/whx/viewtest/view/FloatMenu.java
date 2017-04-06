package com.example.whx.viewtest.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whx on 2016/11/5.
 */

public class FloatMenu {

    public static final int TYPE_LINE = 123;
    public static final int TYPE_SWEEP = 456;

    /**
     * 悬浮按钮
     */
    private View mMenuView;
    /**
     * 显示类型，线形or环形
     */
    private int mType;
    /**
     * 开始角度
     */
    private int startAngle;
    /**
     * 结束角度
     */
    private int endAngle;
    /**
     * 弹出的子view
     */
    private List<View> subViews;
    /**
     * 容器
     */
    private FrameLayout container;
    /**
     * 是否开启动画
     */
    private boolean animated;
    /**
     * 半径
     */
    private int radius;
    /**
     * 是否显示子菜单
     */
    private boolean open;

    private FloatMenu(View mMenuView, int mType, int startAngle, int endAngle,
                      int radius, List<View> subViews, boolean animated) {
        this.mMenuView = mMenuView;
        this.mType = mType;
        this.startAngle = startAngle;
        this.endAngle = endAngle;
        this.radius = radius;
        this.animated = animated;

        this.open = false;

        this.mMenuView.setOnClickListener(new ActionMenuViewListener());
    }
    private class ActionMenuViewListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            toggle(animated);
        }
    }

    /**
     *
     * @param animated
     */
    private void toggle(boolean animated) {

        if(open) {
            close(animated);
        }else {
            open(animated);
        }
    }

    /**
     * 显示子菜单
     * @param animated
     */
    private void open(boolean animated) {

    }

    /**
     * 关闭子菜单
     * @param animated
     */
    private void close(boolean animated) {

    }
    public static class Builder {

        private View menuView;
        private int mType;
        private int startAngle;
        private int endAngle;
        private int radius;
        private List<View> subViews;
        private boolean animated;

        public Builder(Context context) {

            subViews = new ArrayList<>();
        }

        public Builder attachTo(View menuView) {
            this.menuView = menuView;
            return this;
        }
        public Builder setType(int type) {
            this.mType = type;
            return this;
        }
        public Builder setStartAngle(int startAngle) {
            this.startAngle = startAngle;
            return this;
        }
        public Builder setEndAngle(int endAngle) {
            this.endAngle = endAngle;
            return this;
        }
        public Builder setAnimated(boolean animated) {
            this.animated = animated;
            return this;
        }
        public FloatMenu build() {
            return new FloatMenu(menuView, mType, startAngle,
                    endAngle, radius, subViews, animated);
        }
    }
}
