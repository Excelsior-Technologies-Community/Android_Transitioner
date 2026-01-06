package com.ext.transitioner.internal

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.ext.transitioner.FragmentTransition
import com.ext.transitioner.R

internal object FragmentTransitionHandler {

    fun apply(
        fragmentManager: FragmentManager,
        containerId: Int,
        fragment: Fragment,
        transition: FragmentTransition,
        addToBackStack: Boolean
    ) {
        val transaction = fragmentManager.beginTransaction()

        when (transition) {
            FragmentTransition.FADE ->
                transaction.setCustomAnimations(
                    R.anim.fade_in,
                    R.anim.fade_out,
                    R.anim.fade_in,
                    R.anim.fade_out
                )

            FragmentTransition.SLIDE_RIGHT ->
                transaction.setCustomAnimations(
                    R.anim.slide_in_right,
                    R.anim.slide_out_left,
                    R.anim.slide_in_left,
                    R.anim.slide_out_right
                )

            FragmentTransition.SLIDE_LEFT ->
                transaction.setCustomAnimations(
                    R.anim.slide_in_left,
                    R.anim.slide_out_right,
                    R.anim.slide_in_right,
                    R.anim.slide_out_left
                )

            FragmentTransition.SLIDE_UP ->
                transaction.setCustomAnimations(
                    R.anim.slide_in_up,
                    R.anim.slide_out_down,
                    R.anim.slide_in_down,
                    R.anim.slide_out_up
                )

            FragmentTransition.SLIDE_DOWN ->
                transaction.setCustomAnimations(
                    R.anim.slide_in_down,
                    R.anim.slide_out_up,
                    R.anim.slide_in_up,
                    R.anim.slide_out_down
                )
        }

        transaction.replace(containerId, fragment)

        if (addToBackStack) {
            transaction.addToBackStack(fragment::class.java.simpleName)
        }

        transaction.commit()
    }
}
