package com.orz.r.retrofitandkotlin.activity

import android.app.ProgressDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Base64
import android.view.View
import com.orz.r.retrofitandkotlin.R
import com.orz.r.retrofitandkotlin.presenter.LoginPresenter
import com.orz.r.retrofitandkotlin.util.toast
import com.orz.r.retrofitandkotlin.view.ILoginView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener, ILoginView {

    private var mLoginPresenter: LoginPresenter? = null
    private var dialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initVar()
        initView()
    }

    fun initView(){
        setTitle(R.string.login)
        btn_login.setOnClickListener(this)
        btn_to_register.setOnClickListener(this)
    }

    fun initVar(){
        mLoginPresenter = LoginPresenter(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_to_register ->
                RegisterActivity.Companion.startActivity(this)
            R.id.btn_login ->
                login()
        }
    }

    fun login(){
        if (checkLogin()){
            dialog = ProgressDialog.show(this, "", "正在登录...")
            dialog!!.setCancelable(false)
            val base64pwd = String(Base64.encode(getPwd().toByteArray(), Base64.DEFAULT))
            mLoginPresenter!!.login(getUserName(), base64pwd)
        }
    }

    fun checkLogin():Boolean{
        if (TextUtils.isEmpty(getUserName())){
            input_name.requestFocus()
            input_name.error = "用户名不能为空!"
            return false
        }
        if (TextUtils.isEmpty(getPwd())){
            input_pwd.requestFocus()
            input_pwd.error = "密码不能为空!"
            return false
        }
        return true
    }

    override fun getUserName(): String {
        return input_name.text.toString()
    }

    override fun getPwd(): String {
        return input_pwd.text.toString()
    }

    override fun loginSuccess() {
        dialog!!.cancel()
        toast("登录成功")
        MainActivity.startActivity(this)
        finish()
    }

    override fun loginFail(msg: String) {
        dialog!!.cancel()
        toast("登录失败，${msg}")
    }
}
