package com.projects.enzoftware.fakegeolocation.ui.adapters

import android.support.v7.app.AlertController
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.projects.enzoftware.domain.Location
import com.projects.enzoftware.fakegeolocation.ui.inflate

class LocationsAdapter(val items : List<Location>): RecyclerView.Adapter<LocationsAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(p0.inflate(0))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

    }


    class ViewHolder(view:View): RecyclerView.ViewHolder(view){

    }
}