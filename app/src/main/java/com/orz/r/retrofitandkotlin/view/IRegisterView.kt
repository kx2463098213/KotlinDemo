package com.orz.r.retrofitandkotlin.view

/**
 * Created by Administrator on 2017/5/25.
 */
interface IRegisterView{
    fun getUserName(): String
    fun getPwd(): String
    fun getConfirmPwd(): String
    fun getEmail(): String

    fun registerSuccess()
    fun registerFail(msg: String)
}