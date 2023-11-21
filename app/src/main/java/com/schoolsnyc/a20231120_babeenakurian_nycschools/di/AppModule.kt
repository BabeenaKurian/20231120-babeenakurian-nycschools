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
    @Provides
    fun provideInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    fun provideHttpClient(interceptor: HttpLoggingInterceptor?): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient?): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideWebService(retrofit: Retrofit): WebService {
        return retrofit.create(WebService::class.java)
    }

    @Provides
    fun provideErrorUtils(retrofit: Retrofit?): ErrorUtils {
        return ErrorUtils(retrofit)
    }

    @Provides
    fun provideDataSource(webService: WebService?, errorUtils: ErrorUtils?): ApiDataSource {
        return ApiDataSource(webService!!, errorUtils!!)
    }

    @Provides
    @Singleton
    fun provideDataSourceFactory(apiDataSource: ApiDataSource): ApiDataSourceFactory {
        return ApiDataSourceFactory(apiDataSource)
    }

    @Provides
    fun provideRepository(
        webService: WebService?,
        errorUtils: ErrorUtils?,
        dataSourceFactory: ApiDataSourceFactory?
    ): AppRepository {
        return AppRepository(webService!!, errorUtils!!, dataSourceFactory!!)
    }

    companion object {
        private const val BASE_URL = "https://data.cityofnewyork.us/"
    }
}