package com.orz.r.retrofitandkotlin.model

import com.orz.r.retrofitandkotlin.Constant
import com.orz.r.retrofitandkotlin.bean.LoginResponse
import com.orz.r.retrofitandkotlin.bean.RegisterResponse
import com.orz.r.retrofitandkotlin.net.ApiService
import com.orz.r.retrofitandkotlin.presenter.ILoginPresenter
import com.orz.r.retrofitandkotlin.util.RetrofitUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.concurrent.thread

/**
 * Created by Administrator on 2017/5/25.
 */
class LoginModel: ILoginModel{
    private var callBack: ILoginPresenter.OnLoginCallBack? = null

    override fun login(callBack: ILoginPresenter.OnLoginCallBack, name: String, pwd: String) {
        this.callBack = callBack
        println("登录")
        val mLogin: ApiService.Login = RetrofitUtil.getService(Constant.REQUEST_BASE_URL, ApiService.Login::class.java)
        val longCall = mLogin.toLogin(name, pwd, Constant.KEY)
        longCall.enqueue(object: Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>?, response: Response<LoginResponse>?) {
                var result: LoginResponse? = response!!.body()
                if (result != null && "200".equals(result.retCode)){
                    callBack.loginSuccess()
                }else{
                    callBack.loginFail(result!!.msg)
                }
            }

            override fun onFailure(call: Call<LoginResponse>?, t: Throwable?) {
                callBack.loginFail("登录失败")
            }

        })
    }


}