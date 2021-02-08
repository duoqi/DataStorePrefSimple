package com.example.datastoreprefsimple

import android.app.Application
import android.content.Context

/**
 * author：tdq
 * date：2021/2/7
 * description：
 */
class App : Application() {

    companion object {

        private lateinit var mContext: Context
        fun getContext() = mContext
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
    }
}