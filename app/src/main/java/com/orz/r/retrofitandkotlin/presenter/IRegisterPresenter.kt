package com.orz.r.retrofitandkotlin.presenter

/**
 * Created by Administrator on 2017/5/26.
 */
interface IRegisterPresenter{
    fun register(name: String, pwd: String, email: String)

    interface OnRegisterCallBack{
        fun registerSuccess()
        fun registerFail(message: String)
    }
}