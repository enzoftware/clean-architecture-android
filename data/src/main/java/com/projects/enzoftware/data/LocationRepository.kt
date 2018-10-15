package com.projects.enzoftware.data

import com.projects.enzoftware.domain.Location

class LocationRepository(private val locationPersistanceSource : ILocationPersistenceSource,
                         private val deviceLocationSource: IDeviceLocationSource){

    fun getSavedLocations() : List<Location> = locationPersistanceSource.getPersistedLocations()

    fun requestNewLocation() : List<Location>{
        val newLocation = deviceLocationSource.getDeviceLocation()
        locationPersistanceSource.saveNewLocation(newLocation)
        return getSavedLocations()
    }


}
