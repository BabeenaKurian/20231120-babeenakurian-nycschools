package com.schoolsnyc.a20231120_babeenakurian_nycschools.ui.school.adapter

import androidx.recyclerview.widget.RecyclerView
import com.schoolsnyc.a20231120_babeenakurian_nycschools.databinding.SchoolListItemBinding

class SchoolPagedViewHolder internal constructor(@JvmField val itemBinding: SchoolListItemBinding) :
    RecyclerView.ViewHolder(
        itemBinding.root
    ) {

    fun bind(schoolViewModel: SchoolViewModel?) {
        itemBinding.viewModel = schoolViewModel
    }
}