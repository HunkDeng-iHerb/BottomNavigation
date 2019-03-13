package com.iherb.bottomnavigation.views

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class NoScrollViewPager(context: Context, attrs: AttributeSet?) : ViewPager(context, attrs) {

    private var noScroll: Boolean = true

    fun setNoScroll(noScroll: Boolean) {
        this.noScroll = noScroll
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return !noScroll && super.onTouchEvent(event)
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return !noScroll && super.onInterceptTouchEvent(event)
    }
}