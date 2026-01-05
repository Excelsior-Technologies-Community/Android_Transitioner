package com.ext.transitioner

import android.view.View
import com.ext.transitioner.internal.FadeTransition
import com.ext.transitioner.internal.ScaleTransition
import com.ext.transitioner.internal.SlideTransition

object Transitioner {

    fun apply(
        view: View,
        type: TransitionType,
        config: TransitionConfig = TransitionConfig()
    ) {
        when (type) {
            TransitionType.FADE -> FadeTransition.apply(view, config)
            TransitionType.SLIDE -> SlideTransition.apply(view, config)
            TransitionType.SCALE -> ScaleTransition.apply(view, config)
        }
    }
}