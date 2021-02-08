package com.example.datastoreprefsimple

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.datastore.preferences.core.stringPreferencesKey
import com.example.datastoreprefsimple.databinding.ActivityMainBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val mainScope = MainScope()

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)
        mBinding.textView2.setOnClickListener {
            mainScope.launch {
                UserDataStore.saveStringData(stringPreferencesKey(DataStoreKey.userTest), "abcde")
            }
        }

        mBinding.textView1.setOnClickListener {
            mainScope.launch {
                UserDataStore.readStringData(stringPreferencesKey(DataStoreKey.userTest)).collect { Log.e("avv", it) }
            }

        }

        mBinding.clear.setOnClickListener {
            mainScope.launch {
                UserDataStore.clearAllData()
            }

        }
    }

}