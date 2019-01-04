package me.chaozhouzhang.didi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created on 2019/1/3 19:49
 *
 * @author zhangchaozhou
 */
public class ScrollLayout extends NestedScrollView {

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
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }
}
