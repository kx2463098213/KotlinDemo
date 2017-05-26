package com.orz.r.retrofitandkotlin.view

/**
 * Created by Administrator on 2017/5/25.
 */
interface ILoginView{
    fun getUserName(): String
    fun getPwd(): String

    fun loginSuccess()
    fun loginFail(msg: String)
}