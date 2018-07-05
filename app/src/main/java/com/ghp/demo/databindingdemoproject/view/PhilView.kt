package com.ghp.demo.databindingdemoproject.view

import android.content.Context
import android.databinding.BindingAdapter
import android.databinding.InverseBindingAdapter
import android.databinding.InverseBindingListener
import android.support.v4.widget.NestedScrollView
import android.util.AttributeSet
import android.util.Log

/**
 * Created by Phil on 2017/8/25.
 */

class PhilView(context: Context, attrs: AttributeSet) : NestedScrollView(context, attrs) {

    companion object {
        val TAG = "调试"
        var isRefreshing = false
        var mInverseBindingListener: InverseBindingListener? = null
        var mOnRefreshingListener: OnRefreshingListener? = null

        @BindingAdapter(value = "refreshing", requireAll = false)
        @JvmStatic fun setRefreshing(view: PhilView, refreshing: Boolean) {
            if (isRefreshing == refreshing) {
                //防止死循环
                Log.d(TAG, "重复设置")
                return
            } else {
                Log.d(TAG, "setRefreshing $refreshing")
                isRefreshing = refreshing
            }
        }

        @InverseBindingAdapter(attribute = "refreshing", event = "refreshingAttrChanged")
        @JvmStatic fun getRefreshing(view: PhilView): Boolean {
            return isRefreshing
        }

        @BindingAdapter(value = arrayOf("refreshingAttrChanged"), requireAll = false)
        @JvmStatic fun setRefreshingAttrChanged(view: PhilView, inverseBindingListener: InverseBindingListener?) {
            Log.d(TAG, "setRefreshingAttrChanged")

            if (inverseBindingListener == null) {
                mOnRefreshingListener = null
            } else {
                mInverseBindingListener = inverseBindingListener
                mOnRefreshingListener = object : OnRefreshingListener() {
                    override fun startRefreshing() {
                        super.startRefreshing()
                    }

                    override fun stopRefreshing() {
                        super.stopRefreshing()
                    }
                }
            }
        }

    }

    override fun onScrollChanged(x: Int, y: Int, oldx: Int, oldy: Int) {
        super.onScrollChanged(x, y, oldx, oldy)

        if (y < oldy && y == 0) {
            if (isRefreshing) {
                Log.d(TAG, "正在刷新，请勿重复加载")
                return
            } else {
                longTimeTask()
            }
        }
    }

    abstract class OnRefreshingListener {
        open fun startRefreshing() {
            isRefreshing = true
            mInverseBindingListener!!.onChange()
        }

        open fun stopRefreshing() {
            isRefreshing = false
            mInverseBindingListener!!.onChange()
        }
    }

    private fun longTimeTask() {
        Thread(Runnable {
            mOnRefreshingListener!!.startRefreshing()

            try {
                //假设这里做了一个长时间的耗时操作
                Thread.sleep(5000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            mOnRefreshingListener!!.stopRefreshing()
        }).start()
    }

}

