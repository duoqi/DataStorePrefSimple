package com.example.datastoreprefsimple

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType


/**
 * author：tdq
 * date：2021/2/23
 * description：基类activity
 */
@Suppress("UNCHECKED_CAST")
open class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    protected lateinit var mViewBinding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val type = javaClass.genericSuperclass as ParameterizedType
        val aClass = type.actualTypeArguments[0] as Class<T>
        val inflater = aClass.getDeclaredMethod("inflate", LayoutInflater::class.java)
        mViewBinding = inflater.invoke(null,layoutInflater) as T
        setContentView(mViewBinding.root)
    }
}