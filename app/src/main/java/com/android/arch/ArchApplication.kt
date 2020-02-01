package com.android.arch

import android.app.Application
import android.content.Context
import com.android.arch.dagger.DaggerArchApplicationComponent
import com.android.repository.dagger.ArchServiceModel
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class ArchApplication : Application(), HasAndroidInjector {

    var mDispatchingAndroidInjector: DispatchingAndroidInjector<Any>?=null @Inject set

    override fun onCreate() {
        super.onCreate()
        androidInjector()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }

    fun initApplicationComponents(){
        DaggerArchApplicationComponent.builder()
            .archServiceModel(ArchServiceModel())
            .build().inject(this)

    }


    fun injectIfNecessary() {
        if(mDispatchingAndroidInjector==null){
            synchronized(this){
                if(mDispatchingAndroidInjector==null){
                    initApplicationComponents()
                }
            }
        }
    }

    override fun androidInjector(): AndroidInjector<Any>? {
        injectIfNecessary()
        return mDispatchingAndroidInjector
    }
}