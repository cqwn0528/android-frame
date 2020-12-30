package com.frame.basic_library.base.basic

import android.content.Context
import androidx.appcompat.app.AppCompatDialog
import com.frame.basic_library.R

class BasicDialog(context: Context?) : AppCompatDialog(context, R.style.translation_dialog) {

    init {
        setCanceledOnTouchOutside(false)
    }
}