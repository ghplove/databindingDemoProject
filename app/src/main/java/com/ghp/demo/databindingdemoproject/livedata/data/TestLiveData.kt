package com.ghp.demo.databindingdemoproject.livedata.data

import android.arch.lifecycle.LiveData
import android.content.Context
import java.lang.ref.WeakReference
import android.net.wifi.WifiManager
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.IntentFilter
import android.util.Log


class TestLiveData() : LiveData<String>() {
    private val TAG = "TestLiveData"

    var mContextWeakReference: WeakReference<Context>? = null
    private constructor(context: Context) : this() {
        this.mContextWeakReference = WeakReference(context)
    }

    companion object {
        var shared: TestLiveData? = null
    }
    fun getInstance(context: Context): TestLiveData? {
        if (shared == null) {
            shared = TestLiveData(context)
        }
        return shared
    }

    /**
     * 当这个方法被调用时，
     * 表示LiveData的观察者数量从0变为了1，
     * 这时就我们的位置监听来说，就应该注册我们的时间监听了。
     */
    override fun onActive() {
        super.onActive()
        registerReceiver()
    }

    /**
     * 这个方法被调用时，
     * 表示LiveData的观察者数量变为了0，
     * 既然没有了观察者，也就没有理由再做监听，此时我们就应该将位置监听移除。
     */
    override fun onInactive() {
        super.onInactive()
        unregisterReceiver()
    }

    private fun registerReceiver() {
        val intentFilter = IntentFilter()
        intentFilter.addAction(WifiManager.RSSI_CHANGED_ACTION)
        mContextWeakReference?.get()?.registerReceiver(mReceiver, intentFilter)
    }

    private fun unregisterReceiver() {
        mContextWeakReference?.get()?.unregisterReceiver(mReceiver)
    }


    private val mReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val action = intent.action
            Log.d(TAG, "action = " + action)
            if (WifiManager.RSSI_CHANGED_ACTION == action) {
                val wifiRssi = intent.getIntExtra(WifiManager.EXTRA_NEW_RSSI, -200)
                val wifiLevel = WifiManager.calculateSignalLevel(
                        wifiRssi, 4)
                Log.d(TAG, "wifiRssi = " + wifiRssi)
                Log.d(TAG, "wifiLevel = " + wifiLevel)
                shared?.setValue("wifiRssi = " + wifiRssi + "  wifiLevel = " + wifiLevel)
            }
        }
    }
}