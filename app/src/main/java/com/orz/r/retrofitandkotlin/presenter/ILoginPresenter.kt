package com.orz.r.retrofitandkotlin.presenter

/**
 * Created by Administrator on 2017/5/25.
 */
interface ILoginPresenter{
    fun login(userName: String, pwd: String){

    }

    interface OnLoginCallBack{
        fun loginSuccess()
        fun loginFail(message: String)
    }
}