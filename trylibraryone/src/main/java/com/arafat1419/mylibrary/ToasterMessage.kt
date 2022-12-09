package com.arafat1419.mylibrary

import android.content.Context
import android.widget.Toast

class ToasterMessage(private val context: Context) {
    fun show(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}