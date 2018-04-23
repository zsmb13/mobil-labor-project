package hu.bme.aut.stewe.rebrickableclient.ui

import android.support.design.widget.Snackbar
import android.view.View


fun View.longSnack(msg: String) =
        Snackbar.make(this, msg, Snackbar.LENGTH_LONG).show()

fun View.shortSnack(msg: String) =
        Snackbar.make(this, msg, Snackbar.LENGTH_SHORT)