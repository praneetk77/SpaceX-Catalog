package com.example.spacex.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.spacex.databinding.FragmentLaunchesBinding

class LaunchesFragment : Fragment() {

    private lateinit var binding : FragmentLaunchesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLaunchesBinding.inflate(inflater)
        return binding.root
    }

}