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

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val mainScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewBinding.textView2.setOnClickListener {
            mainScope.launch {
                UserDataStore.saveStringData(stringPreferencesKey(DataStoreKey.userTest), "abcde")
            }
        }

        mViewBinding.textView1.setOnClickListener {
            mainScope.launch {
                UserDataStore.readStringData(stringPreferencesKey(DataStoreKey.userTest)).collect { Log.e("avv", it) }
            }

        }

        mViewBinding.clear.setOnClickListener {
            mainScope.launch {
                UserDataStore.clearAllData()
            }

        }
    }

}