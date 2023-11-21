package com.schoolsnyc.a20231120_babeenakurian_nycschools.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.schoolsnyc.a20231120_babeenakurian_nycschools.NYCApplication
import com.schoolsnyc.a20231120_babeenakurian_nycschools.models.SatScores
import com.schoolsnyc.a20231120_babeenakurian_nycschools.models.SchoolDetails
import com.schoolsnyc.a20231120_babeenakurian_nycschools.repositories.AppRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class SchoolDetailsViewModel : ViewModel() {
    @JvmField
    @Inject
    var appRepository: AppRepository? = null
    var schoolDetails: SchoolDetails? = null

    init {
        NYCApplication.application?.appComponent?.inject(this)
    }

    fun getSatScore(dbn: String?): MutableLiveData<SatScores?>? {
        var data:MutableLiveData<SatScores?>?=null
        viewModelScope.launch {
            try {
                data=appRepository!!.getSatScore(dbn)
            }catch (e: Exception){
            }
        }
        return data
    }
}