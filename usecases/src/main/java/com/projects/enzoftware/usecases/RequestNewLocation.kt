package com.projects.enzoftware.usecases

import com.projects.enzoftware.data.LocationRepository
import com.projects.enzoftware.domain.Location

class RequestNewLocation(private val locationsRepository : LocationRepository){
    operator fun invoke() : List<Location> = locationsRepository.requestNewLocation()
}
