package com.iherb.bottomnavigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.iherb.bottomnavigation.R
import com.iherb.bottomnavigation.base.events.NavigationToEvent
import kotlinx.android.synthetic.main.fragment_home.*
import org.greenrobot.eventbus.EventBus
import java.util.*

class HomeFragment : StackFragment() {

    companion object {

        fun getInstance() = HomeFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        product_detail_btn.setOnClickListener {
            EventBus.getDefault().post(NavigationToEvent("/pid?stackName=${stackName()}&time=${Date()}", stackName()))
        }
        product_list_btn.setOnClickListener {
            EventBus.getDefault().post(NavigationToEvent("/c?stackName=${stackName()}&time=${Date()}", stackName()))
        }
    }

    override fun stackName(): String = "home"

    override fun rootView(): Int = R.id.root
}