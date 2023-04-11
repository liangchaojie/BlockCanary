package com.github.moduth.blockcanary.analyzer

import android.app.Application
import android.content.Context
import androidx.startup.Initializer
import com.github.moduth.blockcanary.R
import java.util.Collections.emptyList

internal class BlockCanaryStartupInitializer : Initializer<BlockCanaryStartupInitializer> {

    override fun create(context: Context) = apply {
        val application = context.applicationContext as Application
        val autoInstall = application.resources.getBoolean(R.bool.block_canary_auto_install)
        if (autoInstall) {
            BlockCanary.install(application, DefaultCanaryContext()).start()
        }
    }

    override fun dependencies() = emptyList<Class<out Initializer<*>>>()
}