package com.schoolsnyc.a20231120_babeenakurian_nycschools.di



import com.schoolsnyc.a20231120_babeenakurian_nycschools.NYCApplication
import com.schoolsnyc.a20231120_babeenakurian_nycschools.repositories.ApiDataSourceFactory
import com.schoolsnyc.a20231120_babeenakurian_nycschools.ui.details.SchoolDetailsViewModel
import com.schoolsnyc.a20231120_babeenakurian_nycschools.ui.school.SchoolListViewModel
import com.schoolsnyc.a20231120_babeenakurian_nycschools.ui.school.adapter.SchoolViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(application: NYCApplication?)
    fun inject(schoolListViewModel: SchoolListViewModel?)
    fun inject(schoolViewModel: SchoolViewModel?)
    fun inject(schoolDetailsViewModel: SchoolDetailsViewModel?)
}