package com.orz.r.retrofitandkotlin.presenter

import com.orz.r.retrofitandkotlin.model.ILoginModel
import com.orz.r.retrofitandkotlin.model.LoginModel
import com.orz.r.retrofitandkotlin.view.ILoginView

/**
 * Created by Administrator on 2017/5/25.
 */
class LoginPresenter(val loginView: ILoginView):ILoginPresenter,ILoginPresenter.OnLoginCallBack {


    val mLoginModel: ILoginModel

    init {
        mLoginModel = LoginModel()
        println("生成一个LoginPresenter对象")
    }

    override fun login(userName: String, pwd: String) {
        mLoginModel.login(this, userName, pwd)
    }

    override fun loginSuccess() {
        loginView.loginSuccess()
    }

    override fun loginFail(message: String) {
        loginView.loginFail(message)
    }
}