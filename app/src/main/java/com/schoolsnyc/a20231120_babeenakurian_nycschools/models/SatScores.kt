package com.schoolsnyc.a20231120_babeenakurian_nycschools.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SatScores {
    @SerializedName("dbn")
    @Expose
    var dbn: String? = null

    @SerializedName("school_name")
    @Expose
    var schoolName: String? = null

    @JvmField
    @SerializedName("num_of_sat_test_takers")
    @Expose
    var numOfSatTestTakers: String? = null

    @JvmField
    @SerializedName("sat_critical_reading_avg_score")
    @Expose
    var satCriticalReadingAvgScore: String? = null

    @JvmField
    @SerializedName("sat_math_avg_score")
    @Expose
    var satMathAvgScore: String? = null

    @JvmField
    @SerializedName("sat_writing_avg_score")
    @Expose
    var satWritingAvgScore: String? = null
}