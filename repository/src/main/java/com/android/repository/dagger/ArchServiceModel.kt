package com.android.repository.dagger

import com.android.repository.constant.RepositoryConstant
import com.android.repository.service.ArchServiceRequest
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class ArchServiceModel {

    @Singleton
    @Provides
    fun provideArchRequest(client : OkHttpClient) : ArchServiceRequest {
        return Retrofit.Builder()
            .baseUrl(RepositoryConstant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .callbackExecutor(Executors.newSingleThreadExecutor())
            .client(client)
            .build()
            .create(ArchServiceRequest::class.java)
    }

    @Singleton
    @Provides
    fun provideOKHttpClient(loggingInterceptor : HttpLoggingInterceptor) : OkHttpClient{
        return OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .addInterceptor(loggingInterceptor)
            .build()
    }


}