package com.schoolsnyc.a20231120_babeenakurian_nycschools.repositories

import android.util.Log
import android.widget.Toast
import androidx.paging.PageKeyedDataSource
import com.schoolsnyc.a20231120_babeenakurian_nycschools.NYCApplication
import com.schoolsnyc.a20231120_babeenakurian_nycschools.models.SchoolDetails
import com.schoolsnyc.a20231120_babeenakurian_nycschools.services.WebService
import com.schoolsnyc.a20231120_babeenakurian_nycschools.utils.ErrorUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ApiDataSource @Inject constructor(
    private val webService: WebService,
    private val errorUtils: ErrorUtils
) : PageKeyedDataSource<Int, SchoolDetails?>() {
    /*
     * Loading initial set of data (first 10 commits)
     * */
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, SchoolDetails?>
    ) {
        webService.getSchoolDetails(PAGE_SIZE, PAGE_START_INDEX)
            ?.enqueue(object : Callback<List<SchoolDetails?>?> {
                override fun onResponse(
                    call: Call<List<SchoolDetails?>?>,
                    response: Response<List<SchoolDetails?>?>
                ) {
                    Log.i(TAG, "loadInitial called for " + FIRST_PAGE + " page")
                    if (response.isSuccessful) {
                        if (response.body() != null) {
                            callback.onResult(response.body()!!, null, PAGE_START_INDEX + PAGE_SIZE)
                        }
                    } else {
                        val error = errorUtils.parseError(response)
                        if (error != null) {
                            showErrorToast(error.message)
                        }
                    }
                }

                override fun onFailure(call: Call<List<SchoolDetails?>?>, t: Throwable) {
                    showErrorToast("Error - " + t.message)
                }
            })
    }

    /*
     * Loading previous data set (previous 10 commits)
     * */
    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, SchoolDetails?>) {
        webService.getSchoolDetails(PAGE_SIZE, params.key)
            ?.enqueue(object : Callback<List<SchoolDetails?>?> {
                override fun onResponse(
                    call: Call<List<SchoolDetails?>?>,
                    response: Response<List<SchoolDetails?>?>
                ) {
                    Log.i(TAG, "loadInitial called for " + params.key + " page")
                    if (response.isSuccessful) {
                        if (response.body() != null) {
                            val key = if (params.key > PAGE_SIZE) params.key - PAGE_SIZE else null
                            callback.onResult(response.body()!!, key)
                        }
                    } else {
                        val error = errorUtils.parseError(response)
                        if (error != null) {
                            showErrorToast(error.message)
                        }
                    }
                }

                override fun onFailure(call: Call<List<SchoolDetails?>?>, t: Throwable) {
                    showErrorToast("Error - " + t.message)
                }
            })
    }

    /*
     * Loading next set of data (next 10 commits)
     * */
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, SchoolDetails?>) {
        webService.getSchoolDetails(PAGE_SIZE, params.key)
            ?.enqueue(object : Callback<List<SchoolDetails?>?> {
                override fun onResponse(
                    call: Call<List<SchoolDetails?>?>,
                    response: Response<List<SchoolDetails?>?>
                ) {
                    Log.i(TAG, "loadInitial called for " + params.key + " page")
                    if (response.isSuccessful) {
                        if (response.body() != null) {
                            val key =
                                if (response.body()!!.size != 0) params.key + PAGE_SIZE else null
                            callback.onResult(response.body()!!, key)
                        }
                    } else {
                        val error = errorUtils.parseError(response)
                        if (error != null) {
                            showErrorToast(error.message)
                        }
                    }
                }

                override fun onFailure(call: Call<List<SchoolDetails?>?>, t: Throwable) {
                    showErrorToast("Error - " + t.message)
                }
            })
    }

    /*
     * Helper method for Error Toast
     * */
    private fun showErrorToast(error: String) {
        Toast.makeText(NYCApplication.application?.applicationContext, error, Toast.LENGTH_LONG)
            .show()
    }

    companion object {
        private val TAG = ApiDataSource::class.java.simpleName
        private const val FIRST_PAGE = 1
        private const val PAGE_START_INDEX = 0
        const val PAGE_SIZE = 10
    }
}