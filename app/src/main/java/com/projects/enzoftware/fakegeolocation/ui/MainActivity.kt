package com.projects.enzoftware.fakegeolocation.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.projects.enzoftware.data.LocationRepository
import com.projects.enzoftware.fakegeolocation.R
import com.projects.enzoftware.fakegeolocation.framework.FakeLocationSource
import com.projects.enzoftware.fakegeolocation.framework.MemoryLocationPersistenceSource
import com.projects.enzoftware.fakegeolocation.ui.adapters.LocationsAdapter
import com.projects.enzoftware.fakegeolocation.ui.model.Location
import com.projects.enzoftware.fakegeolocation.ui.presenter.MainPresenter
import com.projects.enzoftware.usecases.GetLocations
import com.projects.enzoftware.usecases.RequestNewLocation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainPresenter.View {

    private val locationsAdapter = LocationsAdapter()
    private val presenter: MainPresenter

    init {
        val persistence = MemoryLocationPersistenceSource()
        val deviceLocation = FakeLocationSource()
        val locationsRepository = LocationRepository(persistence, deviceLocation)
        presenter = MainPresenter(
                this,
                GetLocations(locationsRepository),
                RequestNewLocation(locationsRepository)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler.adapter = locationsAdapter
        newLocationBtn.setOnClickListener { presenter.newLocationClicked() }
        presenter.onCreate()

    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun renderLocations(locations: List<Location>) {
        locationsAdapter.items = locations
    }
}
