package com.ext.transitioner.internal

import android.app.Activity
import com.ext.transitioner.ActivityTransition
import com.ext.transitioner.R

internal object ActivityTransitionHandler {

    fun apply(activity: Activity, transition: ActivityTransition) {
        when (transition) {
            ActivityTransition.FADE ->
                activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)

            ActivityTransition.SLIDE_RIGHT ->
                activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

            ActivityTransition.SLIDE_LEFT ->
                activity.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)

            ActivityTransition.SLIDE_UP ->
                activity.overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_down)

            ActivityTransition.SLIDE_DOWN ->
                activity.overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_up)
        }
    }
}
