package me.chaozhouzhang.didi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created on 2019/1/3 19:49
 *
 * @author zhangchaozhou
 */
public class ScrollLayout extends ScrollView {

    private boolean canScroll = true;


    public ScrollLayout(@NonNull Context context) {
        super(context);
    }

    public ScrollLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }






    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        System.out.println("can scroll " + canScroll);
        if (isCanScroll()) {
            return super.onInterceptTouchEvent(ev);
        } else {
            return false;
        }
    }


    public boolean isCanScroll() {
        return canScroll;
    }

    public ScrollLayout setCanScroll(boolean canScroll) {
        this.canScroll = canScroll;
        return this;
    }
}
