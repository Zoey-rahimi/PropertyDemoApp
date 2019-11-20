package com.zoey.propertydemoapp.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zoey.propertydemoapp.R

fun ImageView.loadImage(url: String?, progressDrawable: CircularProgressDrawable?) {
    val option = RequestOptions
        .placeholderOf(progressDrawable)
        .error(R.drawable.ic_placeholder)
    Glide.with(context)
        .setDefaultRequestOptions(option)
        .load(url)
        .into(this)
}

@BindingAdapter("android:imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    view.loadImage(imageUrl, getProgressDrawable(context = view.context))
}

fun getProgressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
}