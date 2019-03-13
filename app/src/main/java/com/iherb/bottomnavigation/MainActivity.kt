package com.iherb.bottomnavigation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.iherb.bottomnavigation.fragments.CartFragment
import com.iherb.bottomnavigation.fragments.HomeFragment
import com.iherb.bottomnavigation.fragments.MeFragment
import com.iherb.bottomnavigation.fragments.ShopFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                home_view_pager.currentItem = 0
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_shop -> {
                home_view_pager.currentItem = 1
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_cart -> {
                home_view_pager.currentItem = 2
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_me -> {
                home_view_pager.currentItem = 3
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        home_view_pager.adapter = HomepageViewPagerAdapter(supportFragmentManager)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}


class HomepageViewPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            1 -> ShopFragment.getInstance()
            2 -> CartFragment.getInstance()
            3 -> MeFragment.getInstance()
            else -> HomeFragment.getInstance()
        }
    }

    override fun getCount(): Int = 4

}