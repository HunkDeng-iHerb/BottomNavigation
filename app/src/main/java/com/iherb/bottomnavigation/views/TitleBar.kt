package com.iherb.bottomnavigation.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import com.iherb.bottomnavigation.R
import kotlinx.android.synthetic.main.view_title_bar.view.*

class TitleBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    init {
        LayoutInflater.from(context).inflate(R.layout.view_title_bar, this,true)
    }
    fun getBackBtn(): View = back_btn
}