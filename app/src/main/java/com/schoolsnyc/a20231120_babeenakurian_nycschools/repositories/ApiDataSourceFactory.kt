package com.schoolsnyc.a20231120_babeenakurian_nycschools.repositories

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.schoolsnyc.a20231120_babeenakurian_nycschools.models.SchoolDetails

import javax.inject.Inject

class ApiDataSourceFactory @Inject constructor(private val mApiDataSource: ApiDataSource) :
    DataSource.Factory<Any?, Any?>() {
    private val dataSourceMutableLiveData =
        MutableLiveData<PageKeyedDataSource<Int, SchoolDetails>>()
    val pageKeyedDataSource: PageKeyedDataSource<Int, SchoolDetails> =  mApiDataSource as PageKeyedDataSource<Int, SchoolDetails>
    override fun create(): DataSource<Any?, Any?>? {
        dataSourceMutableLiveData.postValue(pageKeyedDataSource)
        return mApiDataSource as DataSource<Any?, Any?>?
    }
}