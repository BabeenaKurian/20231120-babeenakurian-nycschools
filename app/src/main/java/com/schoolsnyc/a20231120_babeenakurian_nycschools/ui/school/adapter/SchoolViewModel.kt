package com.schoolsnyc.a20231120_babeenakurian_nycschools.ui.school.adapter

import androidx.lifecycle.ViewModel
import com.schoolsnyc.a20231120_babeenakurian_nycschools.NYCApplication

class SchoolViewModel(
    schoolName: String,
    totalStudents: String,
    primaryAddressLine1: String,
    city: String,
    stateCode: String,
    zip: String
) : ViewModel() {
    @JvmField
    val schoolName: String
    @JvmField
    val totalStudents: String
    @JvmField
    val primaryAddressLine1: String
    @JvmField
    val city: String
    @JvmField
    val stateCode: String
    @JvmField
    val zip: String

    init {
        NYCApplication.application?.appComponent?.inject(this)
        this.schoolName = schoolName
        this.totalStudents = totalStudents
        this.primaryAddressLine1 = primaryAddressLine1
        this.city = city
        this.stateCode = stateCode
        this.zip = zip
    }
}