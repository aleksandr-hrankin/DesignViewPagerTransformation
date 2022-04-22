package ua.antibyte.designviewpagertransitions

import android.view.View

fun View.setOnDoubleClickListener(action: (view: View) -> Unit) =
    this.setOnClickListener(DoubleClickListener(action))