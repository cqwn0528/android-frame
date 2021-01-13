package com.android.frame_master.ui.activity

import androidx.fragment.app.FragmentTransaction
import com.android.frame_master.R
import com.android.frame_master.databinding.ActivityFmHomeBinding
import com.android.frame_master.ui.fragment.HomeFragment
import com.android.frame_master.ui.fragment.MyFragment
import com.android.frame_master.ui.fragment.SecondFragment
import com.android.frame_master.ui.fragment.ThirdFragment
import com.android.frame_master.util.ResUtil
import com.frame.basic_library.base.basic.BasicActivity

class HomeFmActivity : BasicActivity<ActivityFmHomeBinding>() {

    private lateinit var homeFragment: HomeFragment
    private lateinit var secondFragment: SecondFragment
    private lateinit var thirdFragment: ThirdFragment
    private lateinit var myFragment: MyFragment

    private lateinit var fragmentTransaction: FragmentTransaction

    override fun initData() {
        selectFragmentById(binding.mTab1Rel.id)
    }

    override fun initListener() {
        binding.mTab1Rel.setOnClickListener {
            selectFragmentById(id = it.id)
        }
        binding.mTab2Rel.setOnClickListener {
            selectFragmentById(id = it.id)
        }
        binding.mTab3Rel.setOnClickListener {
            selectFragmentById(id = it.id)
        }
        binding.mTab4Rel.setOnClickListener {
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
            binding.mTab1Rel.id -> if (this::homeFragment.isInitialized) {
                ft.show(homeFragment)
            } else {
                homeFragment = HomeFragment()
                ft.add(binding.mHomeGroup.id, homeFragment)
            }

            binding.mTab2Rel.id -> if (this::secondFragment.isInitialized) {
                ft.show(secondFragment)
            } else {
                secondFragment = SecondFragment()
                ft.add(binding.mHomeGroup.id, secondFragment)
            }

            binding.mTab3Rel.id -> if (this::thirdFragment.isInitialized) {
                ft.show(thirdFragment)
            } else {
                thirdFragment = ThirdFragment()
                ft.add(binding.mHomeGroup.id, thirdFragment)
            }

            binding.mTab4Rel.id ->
                if (this::myFragment.isInitialized) {
                    ft.show(myFragment)
                } else {
                    myFragment = MyFragment()
                    ft.add(binding.mHomeGroup.id, myFragment)
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
        binding.mTab1Img.setImageResource(R.drawable.home_tab1_dark)
        binding.mTab2Img.setImageResource(R.drawable.home_tab2_dark)
        binding.mTab3Img.setImageResource(R.drawable.home_tab3_dark)
        binding.mTab4Img.setImageResource(R.drawable.home_tab4_dark)
        binding.mTab1Tv.setTextColor(ResUtil.getResColor(R.color.colorBlack))
        binding.mTab2Tv.setTextColor(ResUtil.getResColor(R.color.colorBlack))
        binding.mTab3Tv.setTextColor(ResUtil.getResColor(R.color.colorBlack))
        binding.mTab4Tv.setTextColor(ResUtil.getResColor(R.color.colorBlack))
    }

    private fun setTabSelectedStyle(id: Int) {
        when (id) {
            binding.mTab1Rel.id -> {
                binding.mTab1Img.setImageResource(R.drawable.home_tab1_light)
                binding.mTab1Tv.setTextColor(ResUtil.getResColor(R.color.colorPrimary))
            }
            binding.mTab2Rel.id -> {
                binding.mTab2Img.setImageResource(R.drawable.home_tab2_light)
                binding.mTab2Tv.setTextColor(ResUtil.getResColor(R.color.colorPrimary))
            }
            binding.mTab3Rel.id -> {
                binding.mTab3Img.setImageResource(R.drawable.home_tab3_light)
                binding.mTab3Tv.setTextColor(ResUtil.getResColor(R.color.colorPrimary))
            }
            binding.mTab4Rel.id -> {
                binding.mTab4Img.setImageResource(R.drawable.home_tab4_light)
                binding.mTab4Tv.setTextColor(ResUtil.getResColor(R.color.colorPrimary))
            }
            else -> {
                throw IllegalArgumentException("table id error")
            }
        }
    }
}