package com.example.productbrowserapp

import android.content.Intent
import android.os.Build

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

lateinit var activityContext: android.content.Context

actual fun shareProduct(text: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, text)
    }
    activityContext.startActivity(Intent.createChooser(intent, "Share Product").apply {
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    })
}
