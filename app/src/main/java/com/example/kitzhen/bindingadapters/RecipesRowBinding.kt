package com.example.kitzhen.bindingadapters

import android.widget.TextView
import androidx.databinding.BindingAdapter

class RecipesRowBinding {

    companion object {

        @BindingAdapter("setNumberOfLikes")
        @JvmStatic
        fun setNumberOfLikes(textView: TextView, likes: Int) {
            textView.text = likes.toString()
        }

    }
}