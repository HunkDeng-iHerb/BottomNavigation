package com.iherb.bottomnavigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.iherb.bottomnavigation.R
import com.iherb.bottomnavigation.base.events.NavigationBackEvent
import com.iherb.bottomnavigation.base.events.NavigationToEvent
import kotlinx.android.synthetic.main.fragment_product_detail.*
import org.greenrobot.eventbus.EventBus
import java.util.*

class ProductDetailFragment : Fragment() {
    var urlName: String = "null"
    var stack: String = "null"

    companion object {

        private const val URL_NAME = "URL_NAME"
        private const val STACK = "STACK"

        fun getInstance(urlName: String, stack: String): ProductDetailFragment {
            val arguments = Bundle()
            arguments.putString(this.URL_NAME, urlName)
            arguments.putString(STACK, stack)
            val pdFragment = ProductDetailFragment()
            pdFragment.arguments = arguments
            return pdFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        urlName = arguments?.getString(URL_NAME)!!
        stack = arguments?.getString(STACK)!!
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_product_detail, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pid_tv.text = getString(R.string.pid_number, urlName)
        product_list_btn.setOnClickListener {
            EventBus.getDefault().post(NavigationToEvent("/c?stackName=$stack&time=${Date()}", stack))
        }
        title_bar.getBackBtn().setOnClickListener {
            EventBus.getDefault().post(NavigationBackEvent(stack))
        }
    }
}