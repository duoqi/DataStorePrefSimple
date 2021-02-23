package com.example.datastoreprefsimple

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

/**
 * author：tdq
 * date：2021/2/23
 * description：基类fragment
 */
@Suppress("UNCHECKED_CAST")
open class BaseFragment<T : ViewBinding> : Fragment() {

    protected lateinit var mViewBinding: T

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val type = javaClass.genericSuperclass as ParameterizedType
        val aClass = type.actualTypeArguments[0] as Class<*>
        mViewBinding = aClass.getDeclaredMethod("inflate", LayoutInflater::class.java, ViewGroup::class.java, Boolean::class.java).invoke(null, inflater, container, false) as T
        return mViewBinding.root
    }
}