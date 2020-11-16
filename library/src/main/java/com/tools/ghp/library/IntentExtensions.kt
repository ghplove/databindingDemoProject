package com.tools.ghp.library

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.routeToActivity(appCompatActivity: Class<*>, bundle: Bundle = Bundle(), requestCode: Int? = null) {
    val intent = Intent(this, appCompatActivity)
    intent.putExtras(bundle)
    if (requestCode != null) {
        this.startActivityForResult(intent, requestCode)
    } else {
        this.startActivity(intent)
    }
}