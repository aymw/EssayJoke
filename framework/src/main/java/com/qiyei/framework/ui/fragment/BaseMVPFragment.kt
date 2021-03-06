package com.qiyei.framework.ui.fragment

import android.os.Bundle
import com.qiyei.framework.FrameworkApplication
import com.qiyei.framework.injection.component.ActivityComponent
import com.qiyei.framework.injection.component.DaggerActivityComponent
import com.qiyei.framework.injection.module.ActivityModule
import com.qiyei.framework.injection.module.LifecycleProviderModule
import com.qiyei.framework.mvp.presenter.BasePresenter
import com.qiyei.framework.mvp.view.IBaseView
import com.qiyei.sdk.https.dialog.LoadingManager
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

/**
 * @author Created by qiyei2015 on 2018/9/26.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description:
 */
abstract class BaseMVPFragment<T:BasePresenter<*>>:BaseFragment(),IBaseView {

    @Inject
    lateinit var mPresenter:T

    lateinit var mActivityComponet: ActivityComponent

    lateinit var mDialogTAG:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInjection()
        initComponentInject()
    }

    override fun showLoading() {
        mDialogTAG = this.javaClass.canonicalName
        LoadingManager.showDialog(fragmentManager,mDialogTAG)
    }

    override fun hideLoading() {
        LoadingManager.dismissDialog(fragmentManager,mDialogTAG)
    }

    override fun onError(text: String) {
        toast(text)
    }

    /**
     * 抽象函数
     */
    abstract fun initComponentInject()

    /**
     * 初始化注入
     */
    private fun initActivityInjection(){
        mActivityComponet = DaggerActivityComponent.builder()
                .appComponent((activity!!.application as FrameworkApplication).mAppComponent)
                .activityModule(ActivityModule(activity!!))
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .build()

    }

}