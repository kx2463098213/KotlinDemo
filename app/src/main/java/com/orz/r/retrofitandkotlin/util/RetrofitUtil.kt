package com.orz.r.retrofitandkotlin.util

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Administrator on 2017/5/26.
 */
class RetrofitUtil<T> {

    companion object{


        fun <T> getService(url: String, service: Class<T>): T{
            return create(url).create(service)
        }

        private fun  create(url: String): Retrofit {
            val level: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BODY
            val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                message -> Log.i("kotlin", "OkHttp: " + message)
            })
            loggingInterceptor.level = level

            val okHttpClientBuilder = OkHttpClient.Builder()
            okHttpClientBuilder.connectTimeout(30, TimeUnit.SECONDS)
            okHttpClientBuilder.readTimeout(10, TimeUnit.SECONDS)
            okHttpClientBuilder.addInterceptor(loggingInterceptor)

            return Retrofit.Builder().baseUrl(url).client(okHttpClientBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
    }

}