package com.example.spacex.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rocketreserver.LaunchListQuery
import com.example.spacex.R
import com.example.spacex.databinding.LaunchItemBinding

class LaunchListAdapter(val launches : List<LaunchListQuery.Launch>) : RecyclerView.Adapter<LaunchListAdapter.ViewHolder>() {

    class ViewHolder(val binding: LaunchItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LaunchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        println("Launch item called")
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val launch = launches.get(position)
        holder.binding.site.text = launch.site ?: ""
        holder.binding.id.text = launch.id
        holder.binding.missionName.text = launch.mission?.name
        holder.binding.imageView.load(launch.mission?.missionPatch){
            placeholder(R.drawable.ic_stat_name)
        }
    }

    override fun getItemCount(): Int {
        return launches.size
    }

}