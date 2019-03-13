package com.iherb.bottomnavigation.base

import androidx.fragment.app.Fragment
import com.iherb.bottomnavigation.fragments.ProductDetailFragment
import com.iherb.bottomnavigation.fragments.ProductListFragment

class DeeplinkParser {
    companion object {
        fun getFragmentByUrl(url: String, stack: String): Fragment? {
            return when {
                url.startsWith("/c") -> ProductListFragment.getInstance(url, stack)
                url.startsWith("/pid") -> ProductDetailFragment.getInstance(url, stack)
                else -> null
            }
        }
    }
}