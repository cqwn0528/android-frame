package com.android.frame_master.ui.activity

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.android.frame_master.R
import com.android.frame_master.util.SystemUtil
import com.frame.basic_library.base.basic.BasicActivity
import java.util.ArrayList

/**
 * Created by Administrator on 2018/1/9
 * <p>
 * 导航
 */
class NavigationActivity : BasicActivity(), ViewPager.OnPageChangeListener {

    private val list = ArrayList<View>()

    override fun setLayoutId(): Int {
        return R.layout.activity_navigation
    }

    override fun initView() {
        val pager = findViewById<ViewPager>(R.id.LoginPager)
        initList()
        pager.adapter = LoginAdapter(list)
        pager.addOnPageChangeListener(this)
    }

    private fun initList() {
        list.add(View.inflate(this, R.layout.item_navigation, null))
        list.add(View.inflate(this, R.layout.item_navigation, null))
        list.add(View.inflate(this, R.layout.item_navigation, null))
        list[0].findViewById<View>(R.id.LoginView_Relatice)
            .setBackgroundResource(R.drawable.navigation_1)
        list[1].findViewById<View>(R.id.LoginView_Relatice)
            .setBackgroundResource(R.drawable.navigation_2)
        list[2].findViewById<View>(R.id.LoginView_Relatice)
            .setBackgroundResource(R.drawable.navigation_3)
    }

    /*
    * *****************************************Btn Listener*****************************************
    */
    override fun onPageScrollStateChanged(arg0: Int) {}

    override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {

    }

    override fun onPageSelected(arg0: Int) {
        clearSelectAll(list[arg0])

        when (arg0) {
            0 -> {
                val mImg = list[arg0].findViewById<View>(R.id.img1) as ImageView
                mImg.setImageResource(R.drawable.navigation_dot_select)
            }
            1 -> {
                val mImg = list[arg0].findViewById<View>(R.id.img2) as ImageView
                mImg.setImageResource(R.drawable.navigation_dot_select)
            }
            2 -> {
                val mImg = list[arg0].findViewById<View>(R.id.img3) as ImageView
                mImg.setImageResource(R.drawable.navigation_dot_select)

                val mBtn = list[arg0].findViewById<View>(R.id.LoginInBtn) as TextView
                mBtn.visibility = View.VISIBLE
                mBtn.setOnClickListener { isFirstLogin() }
            }
            else -> {
            }
        }
    }


    /*
    * *****************************************Private Method*****************************************
    */
    private fun clearSelectAll(v: View) {
        val img1 = v.findViewById<View>(R.id.img1) as ImageView
        val img2 = v.findViewById<View>(R.id.img2) as ImageView
        val img3 = v.findViewById<View>(R.id.img3) as ImageView
        img1.setImageResource(R.drawable.navigation_dot_normal)
        img2.setImageResource(R.drawable.navigation_dot_normal)
        img3.setImageResource(R.drawable.navigation_dot_normal)
    }

    private fun isFirstLogin() {
        SystemUtil.startActivity(this, LoginActivity::class.java)
        finish()
    }

    /*
     * *****************************************Inner Class*****************************************
     */

    private inner class LoginAdapter(private val list: List<View>) : PagerAdapter() {

        override fun getCount(): Int {
            return list.size
        }

        override fun isViewFromObject(arg0: View, arg1: Any): Boolean {
            return arg0 === arg1
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            container.addView(list[position])
            return list[position]
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(list[position])
        }
    }
}