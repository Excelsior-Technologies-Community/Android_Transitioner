package com.ext.transitioner.utils

import android.view.View
import com.ext.transitioner.TransitionConfig
import com.ext.transitioner.TransitionType
import com.ext.transitioner.Transitioner

fun View.transition(
    type: TransitionType,
    config: TransitionConfig = TransitionConfig()
) {
    Transitioner.apply(this, type, config)
}