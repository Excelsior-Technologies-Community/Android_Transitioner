package com.ext.transitioner.views

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.ext.transitioner.utils.applyTransitionAttributes

class TransitionerTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    init {
        applyTransitionAttributes(context, attrs)
    }
}
