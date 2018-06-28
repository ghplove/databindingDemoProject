package com.ghp.demo.databindingdemoproject.extension

import android.arch.core.util.Function
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.support.annotation.MainThread

/**
 * 相比Transformations.map
 * 是直接将数据转换
 */
@MainThread
fun <X, Y> map(source: LiveData<X>,
               func: Function<X, Y>): LiveData<Y> {
    val result = MediatorLiveData<Y>()
//    result.addSource(source) { x ->
//        result.value = func.apply(x)
//    }
    result.value = func.apply(source.value)
    return result
}