package com.schoolsnyc.a20231120_babeenakurian_nycschools.ui.school

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.schoolsnyc.a20231120_babeenakurian_nycschools.NYCApplication
import com.schoolsnyc.a20231120_babeenakurian_nycschools.models.SchoolDetails
import com.schoolsnyc.a20231120_babeenakurian_nycschools.repositories.AppRepository
import javax.inject.Inject

class SchoolListViewModel : ViewModel() {
    @JvmField
    @Inject
    var appRepository: AppRepository? = null

    init {
        NYCApplication.application?.appComponent?.inject(this)
    }

    val schoolDetailsList: LiveData<PagedList<SchoolDetails?>>
        get() = appRepository!!.schoolDetailsList
}