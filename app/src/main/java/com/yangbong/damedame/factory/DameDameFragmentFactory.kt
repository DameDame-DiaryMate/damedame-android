package com.yangbong.damedame.factory

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.yangbong.core_ui.util.Injector
import com.yangbong.core_ui.util.ResolutionMetrics
import com.yangbong.main.home.HomeFragment
import com.yangbong.main.my_profile.MyProfileFragment
import dagger.hilt.android.EntryPointAccessors

class DameDameFragmentFactory(activity: AppCompatActivity) : FragmentFactory() {
    private val resolutionMetrics: ResolutionMetrics by lazy {
        EntryPointAccessors.fromActivity(
            activity,
            Injector.ResolutionMetricsInjector::class.java
        ).resolutionMetrics()
    }

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            HomeFragment::class.java.name -> HomeFragment(resolutionMetrics)
            SearchFragment::class.java.name -> SearchFragment(resolutionMetrics)
            MyProfileFragment::class.java.name -> MyProfileFragment(resolutionMetrics)
            else -> super.instantiate(classLoader, className)
        }
    }
}