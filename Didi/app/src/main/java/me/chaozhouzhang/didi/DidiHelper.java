package me.chaozhouzhang.didi;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;

/**
 * Helper class for determining the current scroll positions for scrollable views. Currently works
 * for ListView, ScrollView and RecyclerView, but the library users can override it to add support
 * for other views.
 * 此类是为了确定滑动视图的当前滑动位置。目前支持ListView，ScrollView 和 RecyclerView，但是用户们可以重写它来支持其他视图。
 *
 * @author zhangchaozhou
 */
public class DidiHelper {
    /**
     * Returns the current scroll position of the scrollable view. If this method returns zero or
     * less, it means at the scrollable view is in a position such as the panel should handle
     * scrolling. If the method returns anything above zero, then the panel will let the scrollable
     * view handle the scrolling
     *
     * 返回滑动视图的当前位置。如果这个方法返回的是0或者小于0，这意味着滑动视图位于面板需要处理滑动的位置。如果这个方法返回的是大于0，那么面板会让滑动视图处理滑动。
     * @param scrollableView the scrollable view 滑动视图
     * @param isSlidingUp    whether or not the panel is sliding up or down 向上滑或者向下滑
     * @return the scroll position 滑动位置
     */
    public int getScrollableViewScrollPosition(View scrollableView, boolean isSlidingUp) {
        if (scrollableView == null) {
            return 0;
        }
        if (scrollableView instanceof ScrollView) {
            if (isSlidingUp) {
                return scrollableView.getScrollY();
            } else {
                ScrollView sv = ((ScrollView) scrollableView);
                View child = sv.getChildAt(0);
                return (child.getBottom() - (sv.getHeight() + sv.getScrollY()));
            }
        } else if (scrollableView instanceof ListView && ((ListView) scrollableView).getChildCount() > 0) {
            ListView lv = ((ListView) scrollableView);
            if (lv.getAdapter() == null) {
                return 0;
            }
            if (isSlidingUp) {
                View firstChild = lv.getChildAt(0);
                // Approximate the scroll position based on the top child and the first visible item
                return lv.getFirstVisiblePosition() * firstChild.getHeight() - firstChild.getTop();
            } else {
                View lastChild = lv.getChildAt(lv.getChildCount() - 1);
                // Approximate the scroll position based on the bottom child and the last visible item
                return (lv.getAdapter().getCount() - lv.getLastVisiblePosition() - 1) * lastChild.getHeight() + lastChild.getBottom() - lv.getBottom();
            }
        } else if (scrollableView instanceof RecyclerView && ((RecyclerView) scrollableView).getChildCount() > 0) {
            RecyclerView rv = ((RecyclerView) scrollableView);
            RecyclerView.LayoutManager lm = rv.getLayoutManager();
            if (rv.getAdapter() == null) {
                return 0;
            }
            if (isSlidingUp) {
                View firstChild = rv.getChildAt(0);
                // Approximate the scroll position based on the top child and the first visible item
                return rv.getChildLayoutPosition(firstChild) * lm.getDecoratedMeasuredHeight(firstChild) - lm.getDecoratedTop(firstChild);
            } else {
                View lastChild = rv.getChildAt(rv.getChildCount() - 1);
                // Approximate the scroll position based on the bottom child and the last visible item
                return (rv.getAdapter().getItemCount() - 1) * lm.getDecoratedMeasuredHeight(lastChild) + lm.getDecoratedBottom(lastChild) - rv.getBottom();
            }
        } else {
            return 0;
        }
    }
}
