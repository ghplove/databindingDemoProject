package com.ghp.demo.databindingdemoproject.extension

import android.os.Build
import androidx.annotation.MainThread
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import java.util.function.Function

/**
 * 相比Transformations.map
 * 是直接将数据转换
 */
@RequiresApi(Build.VERSION_CODES.N)
@MainThread
fun <X, Y> map(source: LiveData<X>, func: Function<X, Y>): LiveData<Y> {
    val result = MediatorLiveData<Y>()
//    result.addSource(source) { x ->
//        result.value = func.apply(x)
//    }
    result.value = source.value?.let { func.apply(it) }
    return result
}