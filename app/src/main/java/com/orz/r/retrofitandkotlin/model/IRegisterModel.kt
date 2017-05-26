package com.orz.r.retrofitandkotlin.model

import com.orz.r.retrofitandkotlin.presenter.IRegisterPresenter

/**
 * Created by Administrator on 2017/5/25.
 */
interface IRegisterModel{
    fun register(callback: IRegisterPresenter.OnRegisterCallBack, name: String, pwd: String, email: String)
}