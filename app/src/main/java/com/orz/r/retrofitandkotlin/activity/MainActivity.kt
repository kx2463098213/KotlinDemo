package com.orz.r.retrofitandkotlin.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.orz.r.retrofitandkotlin.R

/**
 * Created by Administrator on 2017/5/26.
 */
class MainActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle(R.string.main_title)
    }

    companion object{
        fun startActivity(ctx: Context){
            val i: Intent = Intent(ctx, MainActivity::class.java)
            ctx.startActivity(i)
        }
    }
}