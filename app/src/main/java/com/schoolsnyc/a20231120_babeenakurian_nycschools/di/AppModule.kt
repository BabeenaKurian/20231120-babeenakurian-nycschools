package com.schoolsnyc.a20231120_babeenakurian_nycschools.di


import com.schoolsnyc.a20231120_babeenakurian_nycschools.repositories.ApiDataSource
import com.schoolsnyc.a20231120_babeenakurian_nycschools.repositories.ApiDataSourceFactory
import com.schoolsnyc.a20231120_babeenakurian_nycschools.repositories.AppRepository
import com.schoolsnyc.a20231120_babeenakurian_nycschools.services.WebService
import com.schoolsnyc.a20231120_babeenakurian_nycschools.utils.ErrorUtils
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

   //we can have separate class for creating retrofit object and that can be injected and passed to provideWebService fun
    @Provides
   @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideWebService(retrofit: Retrofit): WebService {
        return retrofit.create(WebService::class.java)
    }


    companion object {
        private const val BASE_URL = "https://data.cityofnewyork.us/"
    }
}