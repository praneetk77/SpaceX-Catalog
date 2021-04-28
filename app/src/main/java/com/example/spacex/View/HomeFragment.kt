package com.example.spacex.View

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.apollographql.apollo.coroutines.await
import com.apollographql.apollo.exception.ApolloException
import com.example.rocketreserver.LaunchListQuery
import com.example.spacex.Adapter.LaunchListAdapter

import com.example.spacex.ViewModel.HomeViewModel
import com.example.spacex.apolloClient
import com.example.spacex.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var homeViewModel : HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


//        binding.launches.layoutManager = LinearLayoutManager(requireContext())
//
//        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
//        homeViewModel.getLaunches()
//        val adapter = LaunchListAdapter(homeViewModel.data.value!!)
//        homeViewModel.data.observe(viewLifecycleOwner,{
//            val adapter = LaunchListAdapter(it)
//            binding.progressBar.visibility = View.GONE
//            binding.launches.visibility = View.VISIBLE
//            binding.launches.adapter = adapter
//        })



        lifecycleScope.launchWhenResumed {
            val response = try {
                apolloClient.query(LaunchListQuery()).await()
            } catch (e: ApolloException) {
                Log.d("LaunchList", "Failure", e)
                null
            }

            val launches = response?.data?.launches?.launches?.filterNotNull()
            if (launches != null && !response.hasErrors()) {
                Log.d("LaunchList", "Comes here")
                binding.progressBar.visibility = View.GONE
                binding.launches.visibility = View.VISIBLE
                val adapter = LaunchListAdapter(launches)
                binding.launches.layoutManager = LinearLayoutManager(requireContext())
                binding.launches.adapter = adapter
            }else{
                Log.d("LaunchList", "Failure 2")
            }
        }
    }

}