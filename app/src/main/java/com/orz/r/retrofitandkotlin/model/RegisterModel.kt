package com.orz.r.retrofitandkotlin.model

import com.orz.r.retrofitandkotlin.Constant
import com.orz.r.retrofitandkotlin.bean.RegisterResponse
import com.orz.r.retrofitandkotlin.net.ApiService
import com.orz.r.retrofitandkotlin.presenter.IRegisterPresenter
import com.orz.r.retrofitandkotlin.util.RetrofitUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Administrator on 2017/5/26.
 */
class RegisterModel: IRegisterModel{
    private var callback: IRegisterPresenter.OnRegisterCallBack? = null

    override fun register(callback: IRegisterPresenter.OnRegisterCallBack, name: String, pwd: String, email: String) {
        this.callback = callback
        println("注册")
        val mRegister: ApiService.Register = RetrofitUtil.getService(Constant.REQUEST_BASE_URL, ApiService.Register::class.java)
        val registerCall = mRegister.toRegister(name, pwd, email, Constant.KEY)
        registerCall.enqueue(object: Callback<RegisterResponse>{
            override fun onFailure(call: Call<RegisterResponse>?, t: Throwable?) {
                callback.registerFail("注册失败")
            }

            override fun onResponse(call: Call<RegisterResponse>?, response: Response<RegisterResponse>?) {
                var result: RegisterResponse? = response!!.body()
                if (result != null && "200".equals(result.retCode)){
                    callback.registerSuccess()
                }else{
                    callback.registerFail(result!!.msg)
                }
            }

        })

    }

}