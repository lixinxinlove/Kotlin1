package com.lxx.kotlin1.activity

import android.content.Context
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import com.lxx.kotlin1.R
import com.lxx.kotlin1.fragment.HomeFragment

class FragmentActivity : BaseActivity() {

    var viewPage: ViewPager? = null

    var context: Context? = null

    var mTabLayout: TabLayout? = null

    override fun findContextView(): Int {
        return R.layout.activity_fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
    }

    override fun findView() {
        mTabLayout = findViewById(R.id.tab_layout) as TabLayout
        viewPage = findViewById(R.id.view_pager) as ViewPager
    }

    override fun initData() {


        var list = mutableListOf<Fragment>()
        for (i in 0..10) {
            var fragment = HomeFragment()
            var bundle = Bundle()
            bundle?.putInt("key", i)
            fragment.arguments = bundle
            list.add(fragment)
        }
        var adapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager, list)
        viewPage?.adapter = adapter
        mTabLayout?.setupWithViewPager(viewPage)

    }


    class ViewPagerAdapter(fm: FragmentManager, var list: List<Fragment>) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return list[position]
        }

        override fun getCount(): Int {
            return list.size
        }

        override fun getPageTitle(position: Int): CharSequence {
            return position.toString()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
