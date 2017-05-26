package com.orz.r.retrofitandkotlin.model

import com.orz.r.retrofitandkotlin.presenter.ILoginPresenter

/**
 * Created by Administrator on 2017/5/25.
 */
interface ILoginModel{
    fun login(callBack: ILoginPresenter.OnLoginCallBack, name: String, pwd: String)
}