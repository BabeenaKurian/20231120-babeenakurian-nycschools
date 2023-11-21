package com.schoolsnyc.a20231120_babeenakurian_nycschools.utils

import com.schoolsnyc.a20231120_babeenakurian_nycschools.models.ApiError
import retrofit2.Response
import retrofit2.Retrofit
import java.io.IOException
import javax.inject.Inject

class ErrorUtils @Inject constructor(private val retrofit: Retrofit?) {
    /*
     * Helper method to convert response to ApiError object
     * */
    fun parseError(response: Response<*>): ApiError? {
        val converter = retrofit?.responseBodyConverter<ApiError>(
            ApiError::class.java, arrayOfNulls(0)
        )
        val apiError: ApiError?
        apiError = try {
            converter?.convert(response.errorBody())
        } catch (e: IOException) {
            return ApiError()
        }
        return apiError
    }
}