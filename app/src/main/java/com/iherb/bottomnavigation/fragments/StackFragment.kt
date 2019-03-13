package com.iherb.bottomnavigation.fragments

import android.view.View
import androidx.fragment.app.Fragment
import com.iherb.bottomnavigation.R
import com.iherb.bottomnavigation.base.DeeplinkParser
import com.iherb.bottomnavigation.base.events.NavigationBackEvent
import com.iherb.bottomnavigation.base.events.NavigationToEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

open class StackFragment: Fragment() {

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    open fun stackName(): String = "default"
    open fun rootView(): Int = 0

    @Subscribe
    fun onEvent(event: NavigationToEvent) {
        if (event.stack == stackName()) {
            // if events fired from child fragments
            val fragment = DeeplinkParser.getFragmentByUrl(event.url, stackName())
            fragment?.let {
                childFragmentManager.beginTransaction()
                    .add(rootView(), fragment, fragment::class.simpleName)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    @Subscribe
    fun onEvent(event: NavigationBackEvent) {
        if (event.stack == stackName()) {
            childFragmentManager.popBackStack()
        }
    }
}