package com.app.i_commerce.widget

import android.view.Gravity
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.snackbar.Snackbar

/**
 * Created by Leon Truzqy Zainun on 30,December,2020
 */
class Snackbar(layout: View, message: String) {
    private var sb: Snackbar = Snackbar.make(layout, message, Snackbar.LENGTH_SHORT)

    init {
        val view = sb.view
        val params: CoordinatorLayout.LayoutParams = view.layoutParams as CoordinatorLayout.LayoutParams
        params.gravity = Gravity.CENTER_HORIZONTAL
        params.topMargin = 20
        view.layoutParams = params
    }

    fun show() {
        sb.show()
    }
}