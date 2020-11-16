package com.ghp.demo.databindingdemoproject.navigation.bottomNavigationView

import android.annotation.SuppressLint
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView


@SuppressLint("RestrictedApi")
fun BottomNavigationView.disableShiftMode() {
    val menuView = this.getChildAt(0) as BottomNavigationMenuView
    try {
        val shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
        shiftingMode.isAccessible = true
        shiftingMode.setBoolean(menuView, false)
        shiftingMode.isAccessible = false
        for (i in 0 until menuView.childCount) {
            val item = menuView.getChildAt(i) as BottomNavigationItemView
//TODO
// 下面注释的这行代码 item.setShiftingMode(false)
// 适用于28以下，28优化了这项，可以设置
// navigation.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_SELECTED
// 或者xml:app:labelVisibilityMode="selected"

//            item.setShiftingMode(false)
            // set once again checked value, so view will be updated

            item.setChecked(item.itemData.isChecked)
        }
    } catch (e: NoSuchFieldException) {
        Log.e("BottomNavigationView","Unable to get shift mode field: $e")
    } catch (e: IllegalAccessException) {
        Log.e("BottomNavigationView","Unable to change value of shift mode: $e")
    }
}