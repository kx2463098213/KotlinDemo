package com.orz.r.retrofitandkotlin.presenter

import com.orz.r.retrofitandkotlin.model.IRegisterModel
import com.orz.r.retrofitandkotlin.model.RegisterModel
import com.orz.r.retrofitandkotlin.view.IRegisterView

/**
 * Created by Administrator on 2017/5/25.
 */
class RegisterPresenter(val registerView: IRegisterView): IRegisterPresenter, IRegisterPresenter.OnRegisterCallBack{

    val mRegisterModel: IRegisterModel

    init {
        mRegisterModel = RegisterModel()
        println("生成一个RegisterPresenter对象")
    }

    override fun register(name: String, pwd: String, email: String) {
        mRegisterModel.register(this, name, pwd, email)
    }

    override fun registerSuccess() {
        registerView.registerSuccess()
    }

    override fun registerFail(message: String) {
        registerView.registerFail(message)
    }

}