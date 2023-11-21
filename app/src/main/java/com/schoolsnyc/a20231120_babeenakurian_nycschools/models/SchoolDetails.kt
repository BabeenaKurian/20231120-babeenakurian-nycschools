package com.schoolsnyc.a20231120_babeenakurian_nycschools.models

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.Objects

class SchoolDetails private constructor(`in`: Parcel) : Parcelable {
    @JvmField
    @SerializedName("dbn")
    @Expose
    var dbn: String?

    @JvmField
    @SerializedName("school_name")
    @Expose
    var schoolName: String?

    @SerializedName("boro")
    @Expose
    var boro: String?

    @SerializedName("overview_paragraph")
    @Expose
    var overviewParagraph: String?

    @SerializedName("academicopportunities1")
    @Expose
    var academicopportunities1: String?

    @SerializedName("academicopportunities2")
    @Expose
    var academicopportunities2: String?

    @SerializedName("academicopportunities3")
    @Expose
    var academicopportunities3: String?

    @SerializedName("academicopportunities4")
    @Expose
    var academicopportunities4: String?

    @SerializedName("academicopportunities5")
    @Expose
    var academicopportunities5: String?

    @JvmField
    @SerializedName("phone_number")
    @Expose
    var phoneNumber: String?

    @SerializedName("fax_number")
    @Expose
    var faxNumber: String?

    @JvmField
    @SerializedName("school_email")
    @Expose
    var schoolEmail: String?

    @JvmField
    @SerializedName("website")
    @Expose
    var website: String?

    @SerializedName("finalgrades")
    @Expose
    var finalgrades: String?

    @JvmField
    @SerializedName("total_students")
    @Expose
    var totalStudents: String?

    @SerializedName("start_time")
    @Expose
    var startTime: String?

    @SerializedName("end_time")
    @Expose
    var endTime: String?

    @SerializedName("extracurricular_activities")
    @Expose
    var extracurricularActivities: String?

    @SerializedName("attendance_rate")
    @Expose
    var attendanceRate: String?

    @JvmField
    @SerializedName("primary_address_line_1")
    @Expose
    var primaryAddressLine1: String?

    @JvmField
    @SerializedName("city")
    @Expose
    var city: String?

    @JvmField
    @SerializedName("zip")
    @Expose
    var zip: String?

    @JvmField
    @SerializedName("state_code")
    @Expose
    var stateCode: String?

    @JvmField
    @SerializedName("latitude")
    @Expose
    var latitude: String?

    @JvmField
    @SerializedName("longitude")
    @Expose
    var longitude: String?

    init {
        dbn = `in`.readString()
        schoolName = `in`.readString()
        boro = `in`.readString()
        overviewParagraph = `in`.readString()
        academicopportunities1 = `in`.readString()
        academicopportunities2 = `in`.readString()
        academicopportunities3 = `in`.readString()
        academicopportunities4 = `in`.readString()
        academicopportunities5 = `in`.readString()
        phoneNumber = `in`.readString()
        faxNumber = `in`.readString()
        schoolEmail = `in`.readString()
        website = `in`.readString()
        finalgrades = `in`.readString()
        totalStudents = `in`.readString()
        startTime = `in`.readString()
        endTime = `in`.readString()
        extracurricularActivities = `in`.readString()
        attendanceRate = `in`.readString()
        primaryAddressLine1 = `in`.readString()
        city = `in`.readString()
        zip = `in`.readString()
        stateCode = `in`.readString()
        latitude = `in`.readString()
        longitude = `in`.readString()
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as SchoolDetails
        return dbn == that.dbn
    }

    override fun hashCode(): Int {
        return Objects.hash(dbn)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(dbn)
        dest.writeString(schoolName)
        dest.writeString(boro)
        dest.writeString(overviewParagraph)
        dest.writeString(academicopportunities1)
        dest.writeString(academicopportunities2)
        dest.writeString(academicopportunities3)
        dest.writeString(academicopportunities4)
        dest.writeString(academicopportunities5)
        dest.writeString(phoneNumber)
        dest.writeString(faxNumber)
        dest.writeString(schoolEmail)
        dest.writeString(website)
        dest.writeString(finalgrades)
        dest.writeString(totalStudents)
        dest.writeString(startTime)
        dest.writeString(endTime)
        dest.writeString(extracurricularActivities)
        dest.writeString(attendanceRate)
        dest.writeString(primaryAddressLine1)
        dest.writeString(city)
        dest.writeString(zip)
        dest.writeString(stateCode)
        dest.writeString(latitude)
        dest.writeString(longitude)
    }

    companion object {
        @JvmField
        val CREATOR: Creator<SchoolDetails?> = object : Creator<SchoolDetails?> {
            override fun createFromParcel(`in`: Parcel): SchoolDetails? {
                return SchoolDetails(`in`)
            }

            override fun newArray(size: Int): Array<SchoolDetails?> {
                return arrayOfNulls(size)
            }
        }
    }
}