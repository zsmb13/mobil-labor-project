package hu.bme.aut.stewe.rebrickableclient.ui

import android.support.annotation.LayoutRes
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide


fun View.longSnack(msg: String) =
        Snackbar.make(this, msg, Snackbar.LENGTH_LONG).show()

fun View.shortSnack(msg: String) =
        Snackbar.make(this, msg, Snackbar.LENGTH_SHORT)

fun ViewGroup.inflate(@LayoutRes layoutId: Int, attachToRoot: Boolean = false) =
        LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)!!

fun ImageView.loadFromUrl(url: String?) =
        Glide.with(context).load(url).into(this)

