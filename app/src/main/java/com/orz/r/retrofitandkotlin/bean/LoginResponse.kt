package com.orz.r.retrofitandkotlin.bean

/**
 * Created by Administrator on 2017/5/26.
 */
data class LoginResponse(val retCode: String,
                         val msg: String,
                         val result: LoginResult)

data class  LoginResult(val token: String, val uid: String)