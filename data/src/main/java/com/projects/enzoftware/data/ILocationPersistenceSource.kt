package com.projects.enzoftware.data

import com.projects.enzoftware.domain.Location

interface ILocationPersistenceSource {

    fun getPersistedLocations() : List<Location>
    fun saveNewLocation(location: Location)

}