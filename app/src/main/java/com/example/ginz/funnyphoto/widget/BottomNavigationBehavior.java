package com.example.ginz.funnyphoto.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

public class BottomNavigationBehavior
        extends CoordinatorLayout.Behavior<BottomNavigationView> {

    private static final int MIN_CONSUME = 5;
    private IBottomMenuBehaviorListener mIBottomMenuBehavior;

    public BottomNavigationBehavior(IBottomMenuBehaviorListener iBottomMenuBehavior) {
        this.mIBottomMenuBehavior = iBottomMenuBehavior;
    }

    public BottomNavigationBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout,
                                       @NonNull BottomNavigationView child,
                                       @NonNull View directTargetChild,
                                       @NonNull View target, int axes, int type) {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL;
    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout,
                               @NonNull BottomNavigationView child, @NonNull View target,
                               int dxConsumed, int dyConsumed, int dxUnconsumed,
                               int dyUnconsumed, int type) {
        if(dyConsumed > MIN_CONSUME){
            mIBottomMenuBehavior.onScrollDown();
        } else if(dyConsumed < -MIN_CONSUME){
            mIBottomMenuBehavior.onScrollUp();
        }
    }
}
