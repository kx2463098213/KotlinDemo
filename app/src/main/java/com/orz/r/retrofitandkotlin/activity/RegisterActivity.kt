package com.orz.r.retrofitandkotlin.activity

import com.orz.r.retrofitandkotlin.R
import com.orz.r.retrofitandkotlin.util.toast
import kotlinx.android.synthetic.main.activity_register.*

/**
 * Created by Administrator on 2017/5/25.
 */
class RegisterActivity: android.support.v7.app.AppCompatActivity(), android.view.View.OnClickListener, com.orz.r.retrofitandkotlin.view.IRegisterView {

    private var mRegisterPresenter: com.orz.r.retrofitandkotlin.presenter.IRegisterPresenter? = null


    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.orz.r.retrofitandkotlin.R.layout.activity_register)
        initVar()
        initView()
    }

    fun initVar(){
        mRegisterPresenter = com.orz.r.retrofitandkotlin.presenter.RegisterPresenter(this)
    }

    fun initView(){
        setTitle(R.string.register)
        btn_register.setOnClickListener(this)
    }

    companion object{
        fun startActivity(ctx: android.content.Context){
            val intent: android.content.Intent = android.content.Intent(ctx, RegisterActivity::class.java)
            ctx.startActivity(intent)
        }
    }

    override fun onClick(v: android.view.View?) {
        when(v?.id){
            com.orz.r.retrofitandkotlin.R.id.btn_register ->
                register()
        }
    }

    fun register(){
        if (checkRegister()){
            val base64pwd: String = String(android.util.Base64.encode(getPwd().toByteArray(), android.util.Base64.DEFAULT))
            mRegisterPresenter!!.register(getUserName(),base64pwd,getEmail())
        }
    }

    fun checkRegister(): Boolean{
        if (android.text.TextUtils.isEmpty(getUserName())){
            input_name.requestFocus()
            input_name.error = "用户名不能为空!"
            return false
        }
        if (android.text.TextUtils.isEmpty(getPwd())){
            input_pwd.requestFocus()
            input_pwd.error = "密码不能为空!"
            return false
        }
        if (!getPwd().equals(getConfirmPwd())){
            input_confirm_pwd.requestFocus()
            input_confirm_pwd.error = "密码和确认密码不匹配!"
            return false
        }
        if (android.text.TextUtils.isEmpty(getEmail())){
            input_email.requestFocus()
            input_email.error = "邮箱地址不能为空"
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

    override fun getConfirmPwd(): String {
        return input_confirm_pwd.text.toString()
    }

    override fun getEmail(): String {
        return input_email.text.toString()
    }

    override fun registerSuccess() {
        toast("注册成功!")
        finish()
    }

    override fun registerFail(msg: String) {
        toast("注册失败,${msg}")
    }

}