package com.schoolsnyc.a20231120_babeenakurian_nycschools

import android.app.Application
import com.schoolsnyc.a20231120_babeenakurian_nycschools.di.AppComponent
import com.schoolsnyc.a20231120_babeenakurian_nycschools.di.AppModule
import com.schoolsnyc.a20231120_babeenakurian_nycschools.di.DaggerAppComponent

class NYCApplication : Application() {
    var appComponent: AppComponent? = null // Instance for Dagger 2 Component
    override fun onCreate() {
        super.onCreate()
        application = this

        // Instantiate instance for Dagger 2 Component
        appComponent = DaggerAppComponent.builder().appModule(AppModule()).build()
        appComponent!!.inject(this)
    }


    companion object {
        var application: NYCApplication? = null
            private set
    }
}