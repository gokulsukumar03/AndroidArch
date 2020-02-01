package com.android.arch.dagger

import android.app.Application
import com.android.arch.ArchApplication
import com.android.repository.dagger.ArchServiceModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ArchServiceModel::class])
interface ArchApplicationComponent {

    fun inject(application : Application)
}