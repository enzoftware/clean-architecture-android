package com.projects.enzoftware.fakegeolocation.ui.presenter

import com.projects.enzoftware.fakegeolocation.ui.model.Location
import com.projects.enzoftware.fakegeolocation.ui.model.toPresentationModel
import com.projects.enzoftware.usecases.GetLocations
import com.projects.enzoftware.usecases.RequestNewLocation
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import org.jetbrains.anko.coroutines.experimental.bg
import com.projects.enzoftware.domain.Location as DomainLocation

class MainPresenter (var view : View?, val getLocations: GetLocations, val requestNewLocation: RequestNewLocation){
    interface View{
        fun renderLocations(locations: List<Location>)
    }

    fun onCreate() = launch(UI){
        val locations = bg { getLocations() }.await()
        view?.renderLocations(locations.map(DomainLocation::toPresentationModel))
    }

    fun newLocationClicked() = launch(UI){
        val locations = bg { requestNewLocation() }.await()
        view?.renderLocations(locations.map(DomainLocation::toPresentationModel))
    }

    fun onDestroy() {
        view = null
    }
}