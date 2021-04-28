package com.example.spacex.ViewModel


import android.util.Log
import com.apollographql.apollo.coroutines.await
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo.exception.ApolloException
import com.example.rocketreserver.LaunchListQuery
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.spacex.apolloClient
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val data: MutableLiveData<List<LaunchListQuery.Launch>> = MutableLiveData()

    fun getLaunches() {
        viewModelScope.launch{
            try {
                val response = apolloClient.query(LaunchListQuery()).await()
                data.value = response?.data?.launches?.launches?.filterNotNull()
            } catch (e: ApolloException) {
                Log.d("LaunchList", "Failure", e)
                null
            }
        }
    }

}