package com.ghp.demo.databindingdemoproject.lifecycles.interfaces

import android.arch.lifecycle.DefaultLifecycleObserver

/**
 * 直接实现 DefaultLifecycleObserver 接口，必须用" implementation "android.arch.lifecycle:common-java8:1.1.1" "，另外 minsdkversion 要大于24
 */
interface IPresenter: DefaultLifecycleObserver {


}