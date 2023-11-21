package com.schoolsnyc.a20231120_babeenakurian_nycschools.ui.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import com.schoolsnyc.a20231120_babeenakurian_nycschools.R
import com.schoolsnyc.a20231120_babeenakurian_nycschools.databinding.SchoolDetailsFragmentBinding
import com.schoolsnyc.a20231120_babeenakurian_nycschools.models.SatScores
import com.schoolsnyc.a20231120_babeenakurian_nycschools.models.SchoolDetails
import com.schoolsnyc.a20231120_babeenakurian_nycschools.ui.school.adapter.SchoolListPagedAdapter

class SchoolDetailsFragment : DialogFragment() {
    private var mViewModel: SchoolDetailsViewModel? = null
    private var binding: SchoolDetailsFragmentBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.school_details_fragment, container, false)
        val mBinding=binding
        return mBinding?.getRoot()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(SchoolDetailsViewModel::class.java)
        if (arguments != null) {
            val schoolDetails =
                arguments!!.getParcelable<SchoolDetails>(SchoolListPagedAdapter.SCHOOL_DETAILS)
            binding!!.schoolDetails = schoolDetails
            mViewModel!!.getSatScore(schoolDetails!!.dbn)?.observe(this) { satScores: SatScores? ->
                if (satScores == null) {
                    //binding!!.satBodyCL.visibility = View.GONE
                  //  binding!!.satNoResultBodyCL.visibility = View.VISIBLE
                } else {
                    binding!!.satScores = satScores
                   // binding!!.satBodyCL.visibility = View.VISIBLE
                   // binding!!.satNoResultBodyCL.visibility = View.GONE
                }
            }
            binding!!.llPhoneButton.setOnClickListener { v: View? ->
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:" + schoolDetails.phoneNumber)
                startActivity(intent)
            }
            binding!!.llWebsiteButton.setOnClickListener { v: View? ->
                var website: String? = ""
                website = if (schoolDetails.website!!.contains("http")) {
                    schoolDetails.website
                } else {
                    "https://" + schoolDetails.website
                }
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(website))
                startActivity(intent)
            }
            binding!!.llEmailButton.setOnClickListener { v: View? ->
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "plain/text"
                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(schoolDetails.schoolEmail))
                startActivity(intent)
            }
            binding!!.llMapButton.setOnClickListener { v: View? ->
                val uri = ("geo:"
                        + schoolDetails.latitude + ","
                        + schoolDetails.longitude + "?q="
                        + schoolDetails.schoolName + ", "
                        + schoolDetails.primaryAddressLine1 + ", "
                        + schoolDetails.city + ", "
                        + schoolDetails.stateCode)
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                intent.setPackage("com.google.android.apps.maps")
                startActivity(intent)
            }
            binding!!.btCloseButton.setOnClickListener { v: View? -> dismiss() }
        }
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.WRAP_CONTENT
            dialog.window!!.setLayout(width, height)
        }
    }

    companion object {
        private val TAG = SchoolDetailsFragment::class.java.simpleName
        @JvmStatic
        fun newInstance(): SchoolDetailsFragment {
            return SchoolDetailsFragment()
        }
    }
}