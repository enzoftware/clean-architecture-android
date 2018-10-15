package com.projects.enzoftware.fakegeolocation.framework

import com.projects.enzoftware.data.ILocationPersistenceSource
import com.projects.enzoftware.domain.Location

class MemoryLocationPersistenceSource  : ILocationPersistenceSource{

    private var locations : List<Location> = emptyList()

    override fun getPersistedLocations(): List<Location> {
        return locations
    }

    override fun saveNewLocation(location: Location) {
        locations += location
    }
}