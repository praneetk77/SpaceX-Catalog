package com.example.spacex.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.spacex.databinding.FragmentCompanyBinding

class CompanyFragment : Fragment() {

    private lateinit var binding : FragmentCompanyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCompanyBinding.inflate(inflater)
        return binding.root
    }

}