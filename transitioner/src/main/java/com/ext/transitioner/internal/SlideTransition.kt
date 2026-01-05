package com.ext.transitioner.internal

import android.view.View
import com.ext.transitioner.TransitionConfig

internal object SlideTransition {

    fun apply(view: View, config: TransitionConfig) {
        val parentWidth = (view.parent as View).width

        view.translationX = parentWidth.toFloat()
        view.alpha = 0f

        view.animate()
            .translationX(0f)
            .alpha(1f)
            .setDuration(config.duration)
            .setStartDelay(config.startDelay)
            .start()
    }
}