package com.schoolsnyc.a20231120_babeenakurian_nycschools.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.schoolsnyc.a20231120_babeenakurian_nycschools.models.SatScores
import com.schoolsnyc.a20231120_babeenakurian_nycschools.models.SchoolDetails
import com.schoolsnyc.a20231120_babeenakurian_nycschools.services.WebService
import com.schoolsnyc.a20231120_babeenakurian_nycschools.utils.ErrorUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val webService: WebService,
    private val errorUtils: ErrorUtils,
    private val dataSourceFactory: ApiDataSourceFactory
) {
    private val config: PagedList.Config

    init {
        config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(ApiDataSource.PAGE_SIZE)
            .build()
    }

    val schoolDetailsList: LiveData<PagedList<SchoolDetails?>>
        get() = LivePagedListBuilder(
            dataSourceFactory,
            config
        ).build() as LiveData<PagedList<SchoolDetails?>>

    fun getSatScore(dbn: String?): MutableLiveData<SatScores?> {
        val satScore = MutableLiveData<SatScores?>()
        val call = webService.getSatScore(dbn)
        call!!.enqueue(object : Callback<List<SatScores?>?> {
            override fun onResponse(
                call: Call<List<SatScores?>?>,
                response: Response<List<SatScores?>?>
            ) {
                if (response.isSuccessful) {
                    if (response.body() != null && response.body()!!.size > 0) {
                        satScore.setValue(response.body()!![0])
                    } else {
                        satScore.setValue(null)
                    }
                } else {
                    satScore.setValue(null)
                }
            }

            override fun onFailure(call: Call<List<SatScores?>?>, t: Throwable) {
                Log.i(TAG, t.message!!)
                satScore.value = null
            }
        })
        return satScore
    }

    companion object {
        private val TAG = AppRepository::class.java.simpleName
    }
}