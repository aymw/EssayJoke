package com.qiyei.framework.mvp.presenter

import com.qiyei.framework.mvp.view.IBaseView
import com.trello.rxlifecycle2.LifecycleProvider
import javax.inject.Inject

/**
 * @author Created by qiyei2015 on 2018/9/22.
 * @version: 1.0
 * @email: 1273482124@qq.com
 * @description: MVP 中Presenter基类,持有View的引用
 */
abstract class BasePresenter<T:IBaseView> {

    /**
     * 公共基类View
     */
    lateinit var mView:T
    /**
     * 用作RxLifeCycle
     */
    @Inject
    lateinit var mLifecycleProvider: LifecycleProvider<*>

    /**
     * 定位的TAG
     */
    abstract fun getTAG():String

}