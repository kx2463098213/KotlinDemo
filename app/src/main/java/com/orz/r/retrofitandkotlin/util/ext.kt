package com.orz.r.retrofitandkotlin.util

import android.content.Context
import android.widget.Toast

/**
 * Created by Administrator on 2017/5/26.
 */
fun Context.toast(msg: String){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}