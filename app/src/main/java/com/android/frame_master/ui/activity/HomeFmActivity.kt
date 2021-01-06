package com.android.frame_master.ui.activity

import androidx.fragment.app.FragmentTransaction
import com.android.frame_master.R
import com.android.frame_master.ui.fragment.HomeFragment
import com.android.frame_master.ui.fragment.MyFragment
import com.android.frame_master.ui.fragment.SecondFragment
import com.android.frame_master.ui.fragment.ThirdFragment
import com.android.frame_master.util.ResUtil
import com.frame.basic_library.base.basic.BasicActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFmActivity : BasicActivity() {

    private lateinit var homeFragment: HomeFragment
    private lateinit var secondFragment: SecondFragment
    private lateinit var thirdFragment: ThirdFragment
    private lateinit var myFragment: MyFragment

    private lateinit var fragmentTransaction: FragmentTransaction

    override fun setLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initData() {
        selectFragmentById(R.id.mTab1Rel)
    }

    override fun initListener() {
        mTab1Rel.setOnClickListener {
            selectFragmentById(id = it.id)
        }
        mTab2Rel.setOnClickListener {
            selectFragmentById(id = it.id)
        }
        mTab3Rel.setOnClickListener {
            selectFragmentById(id = it.id)
        }
        mTab4Rel.setOnClickListener {
            selectFragmentById(id = it.id)
        }
    }

    private fun selectFragmentById(id: Int) {
        //Fragment管理者
        fragmentTransaction = supportFragmentManager.beginTransaction()
        //隐藏Fragment
        hintUnSelFragment(fragmentTransaction)
        //重置样式
        resetStyle()
        // 修改选中样式
        setTabSelectedStyle(id)
        // 顯示選中Fragment
        showSelectedFragment(id, fragmentTransaction)
    }

    private fun showSelectedFragment(id: Int, ft: FragmentTransaction) {
        when (id) {
            R.id.mTab1Rel -> if (this::homeFragment.isInitialized) {
                ft.show(homeFragment)
            } else {
                homeFragment = HomeFragment()
                ft.add(R.id.mHomeGroup, homeFragment)
            }

            R.id.mTab2Rel -> if (this::secondFragment.isInitialized) {
                ft.show(secondFragment)
            } else {
                secondFragment = SecondFragment()
                ft.add(R.id.mHomeGroup, secondFragment)
            }

            R.id.mTab3Rel -> if (this::thirdFragment.isInitialized) {
                ft.show(thirdFragment)
            } else {
                thirdFragment = ThirdFragment()
                ft.add(R.id.mHomeGroup, thirdFragment)
            }

            R.id.mTab4Rel ->
                if (this::myFragment.isInitialized) {
                    ft.show(myFragment)
                } else {
                    myFragment = MyFragment()
                    ft.add(R.id.mHomeGroup, myFragment)
                }
            else -> {
                throw IllegalArgumentException("table id error")
            }
        }
        ft.commit()
    }

    private fun hintUnSelFragment(ft: FragmentTransaction) {
        if (this::homeFragment.isInitialized) {
            ft.hide(homeFragment)
        }
        if (this::secondFragment.isInitialized) {
            ft.hide(secondFragment)
        }
        if (this::thirdFragment.isInitialized) {
            ft.hide(thirdFragment)
        }
        if (this::myFragment.isInitialized) {
            ft.hide(myFragment)
        }
    }

    private fun resetStyle() {
        mTab1Img.setImageResource(R.drawable.home_tab1_dark)
        mTab2Img.setImageResource(R.drawable.home_tab2_dark)
        mTab3Img.setImageResource(R.drawable.home_tab3_dark)
        mTab4Img.setImageResource(R.drawable.home_tab4_dark)
        mTab1Tv.setTextColor(ResUtil.getResColor(R.color.colorBlack))
        mTab2Tv.setTextColor(ResUtil.getResColor(R.color.colorBlack))
        mTab3Tv.setTextColor(ResUtil.getResColor(R.color.colorBlack))
        mTab4Tv.setTextColor(ResUtil.getResColor(R.color.colorBlack))
    }

    private fun setTabSelectedStyle(id: Int) {
        when (id) {
            R.id.mTab1Rel -> {
                mTab1Img.setImageResource(R.drawable.home_tab1_light)
                mTab1Tv.setTextColor(ResUtil.getResColor(R.color.colorPrimary))
            }
            R.id.mTab2Rel -> {
                mTab2Img.setImageResource(R.drawable.home_tab2_light)
                mTab2Tv.setTextColor(ResUtil.getResColor(R.color.colorPrimary))
            }
            R.id.mTab3Rel -> {
                mTab3Img.setImageResource(R.drawable.home_tab3_light)
                mTab3Tv.setTextColor(ResUtil.getResColor(R.color.colorPrimary))
            }
            R.id.mTab4Rel -> {
                mTab4Img.setImageResource(R.drawable.home_tab4_light)
                mTab4Tv.setTextColor(ResUtil.getResColor(R.color.colorPrimary))
            }
            else -> {
                throw IllegalArgumentException("table id error")
            }
        }
    }
}