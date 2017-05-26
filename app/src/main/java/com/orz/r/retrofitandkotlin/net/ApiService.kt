package com.orz.r.retrofitandkotlin.net

import com.orz.r.retrofitandkotlin.bean.LoginResponse
import com.orz.r.retrofitandkotlin.bean.RegisterResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by Administrator on 2017/5/26.
 */

class ApiService{

    /**
     * 用户注册接口
     */
    interface Register{
        @FormUrlEncoded
        @POST("rigister")
        fun toRegister(@Field("username") name: String,
                       @Field("password") pwd: String,
                       @Field("email") email: String,
                       @Field("key") key: String):Call<RegisterResponse>
    }

    /**
     * 用户登录接口
     */
    interface Login{
        @FormUrlEncoded
        @POST("login")
        fun toLogin(@Field("username") name: String,
                    @Field("password") pwd: String,
                    @Field("key") key: String):Call<LoginResponse>
    }
}