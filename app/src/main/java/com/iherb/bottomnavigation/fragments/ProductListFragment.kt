package com.iherb.bottomnavigation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.iherb.bottomnavigation.R
import com.iherb.bottomnavigation.base.events.NavigationBackEvent
import com.iherb.bottomnavigation.base.events.NavigationToEvent
import kotlinx.android.synthetic.main.fragment_product_list.*
import org.greenrobot.eventbus.EventBus
import java.util.*

class ProductListFragment : Fragment() {
    private lateinit var urlName: String
    private lateinit var stack: String

    companion object {

        private const val URL_NAME = "urlName"
        private const val STACK = "stack"

        fun getInstance(urlName: String, stack: String): ProductListFragment {
            val arguments = Bundle()
            arguments.putString(URL_NAME, urlName)
            arguments.putString(STACK, stack)
            val pdFragment = ProductListFragment()
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
        return inflater.inflate(R.layout.fragment_product_list, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pid_tv.text = getString(R.string.cid_number, urlName)
        title_bar.getBackBtn().setOnClickListener {
            EventBus.getDefault().post(NavigationBackEvent(stack))
        }
        product_detail_btn.setOnClickListener {
            EventBus.getDefault().post(NavigationToEvent("/pid?stackName=$stack&time=${Date()}", stack))
        }
    }
}