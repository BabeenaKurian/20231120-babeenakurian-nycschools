package com.schoolsnyc.a20231120_babeenakurian_nycschools.services


import com.schoolsnyc.a20231120_babeenakurian_nycschools.models.SatScores
import com.schoolsnyc.a20231120_babeenakurian_nycschools.models.SchoolDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("resource/s3k6-pzi2.json")
    fun getSchoolDetails(
        @Query("\$limit") pageSize: Int,
        @Query("\$offset") startIndex: Int
    ): Call<List<SchoolDetails?>?>?

    @GET("resource/f9bf-2cp4.json")
    fun getSatScore(@Query("dbn") dbn: String?): Call<List<SatScores?>?>?

}