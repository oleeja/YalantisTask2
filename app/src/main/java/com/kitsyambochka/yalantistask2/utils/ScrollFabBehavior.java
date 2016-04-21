package com.kitsyambochka.yalantistask2.utils;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Developer on 16.04.2016.
 */
public class ScrollFabBehavior extends FloatingActionButton.Behavior {
    private static boolean sReactOnScroll = true;

    public ScrollFabBehavior(Context context, AttributeSet attrs) {
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View directTargetChild, View target, int nestedScrollAxes) {
        if (!sReactOnScroll) {
            return false;
        }
        if (nestedScrollAxes == 2 || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, nestedScrollAxes)) {
            return true;
        }
        return false;
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton child, View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
        if (dyConsumed > 0 && child.getVisibility() == View.VISIBLE) {
            child.hide();
        } else if (dyConsumed < 0 && child.getVisibility() != View.VISIBLE) {
            child.show();
        }
    }

    public static boolean isReactOnScroll() {
        return sReactOnScroll;
    }

    public static void setReactOnScroll(boolean reactOnScroll) {
        sReactOnScroll = reactOnScroll;
    }
}
