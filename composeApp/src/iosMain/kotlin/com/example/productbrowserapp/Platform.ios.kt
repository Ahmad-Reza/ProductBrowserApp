package com.example.productbrowserapp

import platform.UIKit.*

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): Platform = IOSPlatform()

actual fun shareProduct(text: String) {
    val window = UIApplication.sharedApplication.keyWindow
    val rootViewController = window?.rootViewController
    
    val activityItems = listOf(text)
    val activityController = UIActivityViewController(activityItems, null)
    
    rootViewController?.presentViewController(activityController, true, null)
}
