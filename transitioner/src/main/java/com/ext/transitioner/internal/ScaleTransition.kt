package com.ext.transitioner.internal

import android.view.View
import com.ext.transitioner.TransitionConfig

internal object ScaleTransition {

    fun apply(view: View, config: TransitionConfig) {
        view.scaleX = 0.8f
        view.scaleY = 0.8f
        view.alpha = 0f

        view.animate()
            .scaleX(1f)
            .scaleY(1f)
            .alpha(1f)
            .setDuration(config.duration)
            .setStartDelay(config.startDelay)
            .start()
    }
}