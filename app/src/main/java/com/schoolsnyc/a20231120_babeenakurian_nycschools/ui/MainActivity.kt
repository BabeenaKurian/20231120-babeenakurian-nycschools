package com.schoolsnyc.a20231120_babeenakurian_nycschools.ui

import android.os.Bundle
import android.util.Log
import android.widget.SearchView.OnQueryTextListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.schoolsnyc.a20231120_babeenakurian_nycschools.R
import com.schoolsnyc.a20231120_babeenakurian_nycschools.models.SchoolDetails
import com.schoolsnyc.a20231120_babeenakurian_nycschools.ui.school.SchoolListViewModel
import com.schoolsnyc.a20231120_babeenakurian_nycschools.ui.school.adapter.SchoolListPagedAdapter
import java.util.Locale

class MainActivity : AppCompatActivity() {
    var mViewModel: SchoolListViewModel? = null
    var recyclerView: RecyclerView? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        mViewModel = ViewModelProviders.of(this).get(SchoolListViewModel::class.java)
        val mrecyclerView=recyclerView
        // Setup recycler view
        mrecyclerView?.setLayoutManager(LinearLayoutManager(this))
        mrecyclerView?.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        dataFromServer
    }

    val dataFromServer: Unit
        get() {
            // Instantiate PagedAdapter
            val adapter = SchoolListPagedAdapter(this)
            mViewModel!!.schoolDetailsList.observe(this) { schoolDetails: PagedList<SchoolDetails?> ->
                Log.i(TAG, "onChanged called and list size is: " + schoolDetails.size + ".")
                adapter.submitList(schoolDetails)
            }
            recyclerView!!.adapter = adapter
        }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}