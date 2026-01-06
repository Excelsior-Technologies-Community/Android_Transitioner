package com.ext.transitioner.internal

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.ext.transitioner.*
import com.ext.transitioner.R

internal object TransitionAttributeParser {

    fun applyFromXml(
        view: View,
        context: Context,
        attrs: AttributeSet?
    ) {
        if (attrs == null) return

        val typedArray = context.obtainStyledAttributes(
            attrs,
            R.styleable.TransitionerView
        )

        val typeValue = typedArray.getInt(
            R.styleable.TransitionerView_transitionType,
            -1
        )

        val duration = typedArray.getInt(
            R.styleable.TransitionerView_transitionDuration,
            300
        )

        val delay = typedArray.getInt(
            R.styleable.TransitionerView_transitionDelay,
            0
        )

        val autoStart = typedArray.getBoolean(
            R.styleable.TransitionerView_transitionAutoStart,
            false
        )

        typedArray.recycle()

        if (typeValue == -1 || !autoStart) return

        val type = when (typeValue) {
            0 -> TransitionType.FADE
            1 -> TransitionType.SLIDE
            2 -> TransitionType.SCALE
            else -> return
        }

        view.post {
            Transitioner.apply(
                view,
                type,
                TransitionConfig(
                    duration = duration.toLong(),
                    startDelay = delay.toLong()
                )
            )
        }
    }
}
