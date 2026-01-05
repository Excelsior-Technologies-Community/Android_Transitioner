package com.ext.transitioner.internal

import android.view.View
import com.ext.transitioner.TransitionConfig

internal object FadeTransition {

    fun apply(view: View, config: TransitionConfig) {
        view.alpha = 0f
        view.animate()
            .alpha(1f)
            .setDuration(config.duration)
            .setStartDelay(config.startDelay)
            .start()
    }
}