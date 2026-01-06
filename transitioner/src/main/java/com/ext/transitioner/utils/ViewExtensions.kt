package com.ext.transitioner.utils

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.ext.transitioner.TransitionConfig
import com.ext.transitioner.TransitionType
import com.ext.transitioner.Transitioner
import com.ext.transitioner.internal.TransitionAttributeParser

fun View.transition(
    type: TransitionType,
    config: TransitionConfig = TransitionConfig()
) {
    Transitioner.apply(this, type, config)
}

fun View.applyTransitionAttributes(
    context: Context,
    attrs: AttributeSet?
) {
    TransitionAttributeParser.applyFromXml(this, context, attrs)
}