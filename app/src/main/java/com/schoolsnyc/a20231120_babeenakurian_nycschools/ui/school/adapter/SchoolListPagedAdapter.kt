package com.schoolsnyc.a20231120_babeenakurian_nycschools.ui.school.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import com.schoolsnyc.a20231120_babeenakurian_nycschools.databinding.SchoolListItemBinding
import com.schoolsnyc.a20231120_babeenakurian_nycschools.models.SchoolDetails
import com.schoolsnyc.a20231120_babeenakurian_nycschools.ui.details.SchoolDetailsFragment.Companion.newInstance
import java.util.Objects

class SchoolListPagedAdapter(private val context: Context) :
    PagedListAdapter<SchoolDetails?, SchoolPagedViewHolder>(
        AsyncDifferConfig.Builder<SchoolDetails>(diffCallback).build()
    ) {
    private var inflater: LayoutInflater? = null
    private var schoolDetails: PagedList<SchoolDetails?>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolPagedViewHolder {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.context)
        }
        val itemBinding = SchoolListItemBinding.inflate(
            inflater!!, parent, false
        )
        return SchoolPagedViewHolder(itemBinding)
    }
    override fun onBindViewHolder(holder: SchoolPagedViewHolder, position: Int) {
        val schoolViewModel = getData(Objects.requireNonNull(getItem(position)))
        holder.bind(schoolViewModel)
        holder.itemBinding.clSchoolItem.setOnClickListener { v: View? ->
            val fragmentManager = (context as AppCompatActivity).supportFragmentManager
            val schoolDetailsFragment = newInstance()
            val args = Bundle()
            args.putParcelable(SCHOOL_DETAILS, getItem(position))
            schoolDetailsFragment.arguments = args
            schoolDetailsFragment.show(fragmentManager, "school_details")
        }
    }

    private fun getData(schoolDetails: SchoolDetails?): SchoolViewModel {
        return SchoolViewModel(
            schoolDetails?.schoolName!!,
            schoolDetails?.totalStudents!!,
            schoolDetails?.primaryAddressLine1!!,
            schoolDetails?.city!!,
            schoolDetails?.stateCode!!,
            schoolDetails?.zip!!
        )
    }

    companion object {
        const val SCHOOL_DETAILS = "SchoolDetails"
        private val diffCallback: DiffUtil.ItemCallback<SchoolDetails> =
            object : DiffUtil.ItemCallback<SchoolDetails>() {
                override fun areItemsTheSame(
                    oldItem: SchoolDetails,
                    newItem: SchoolDetails
                ): Boolean {
                    return oldItem.dbn == newItem.dbn
                }

                override fun areContentsTheSame(
                    oldItem: SchoolDetails,
                    newItem: SchoolDetails
                ): Boolean {
                    return oldItem.equals(newItem)
                }
            }
    }
}