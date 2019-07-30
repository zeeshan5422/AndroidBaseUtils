package com.zues.baseutils

import android.content.Context
import android.widget.Toast

/* ---  Created by akhtarz on 7/30/2019. ---*/
object MyToast {

    fun show(context: Context, text: String, length: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(context, text, length).show()
    }
}