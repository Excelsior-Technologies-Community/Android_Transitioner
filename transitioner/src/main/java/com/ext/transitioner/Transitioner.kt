package com.ext.transitioner

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.ext.transitioner.internal.ActivityTransitionHandler
import com.ext.transitioner.internal.FadeTransition
import com.ext.transitioner.internal.FragmentTransitionHandler
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

    fun startActivity(
        from: Activity,
        intent: Intent,
        transition: ActivityTransition = ActivityTransition.FADE
    ) {
        from.startActivity(intent)
        ActivityTransitionHandler.apply(from, transition)
    }

    fun finish(
        activity: Activity,
        transition: ActivityTransition = ActivityTransition.FADE
    ) {
        activity.finish()
        ActivityTransitionHandler.apply(activity, transition)
    }

    fun onBackPressed(
        activity: Activity,
        transition: ActivityTransition = ActivityTransition.FADE
    ) {
        activity.finish()
        ActivityTransitionHandler.apply(activity, transition)
    }

    fun replaceFragment(
        fragmentManager: FragmentManager,
        containerId: Int,
        fragment: Fragment,
        transition: FragmentTransition = FragmentTransition.FADE,
        addToBackStack: Boolean = true
    ) {
        FragmentTransitionHandler.apply(
            fragmentManager,
            containerId,
            fragment,
            transition,
            addToBackStack
        )
    }

}