package com.projects.enzoftware.fakegeolocation.ui.adapters

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.projects.enzoftware.fakegeolocation.R
import com.projects.enzoftware.fakegeolocation.ui.inflate
import com.projects.enzoftware.fakegeolocation.ui.model.Location
import kotlinx.android.synthetic.main.view_location_item.view.*
import kotlin.properties.Delegates

class LocationsAdapter : RecyclerView.Adapter<LocationsAdapter.ViewHolder>() {

    var items: List<Location> by Delegates.observable(emptyList()) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(parent.inflate(R.layout.view_location_item))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(private val containerView: View) : RecyclerView.ViewHolder(containerView){

        @SuppressLint("SetTextI18n")
        fun bind(location: Location) {
            with(location) {
                containerView.locationCoordinates.text = coordinates
                containerView.locationDate.text = date
            }
        }
    }
}