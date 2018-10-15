package com.projects.enzoftware.usecases

import com.projects.enzoftware.data.LocationRepository
import com.projects.enzoftware.domain.Location

class GetLocations(private val locationRepository: LocationRepository) {
    operator fun invoke(): List<Location> = locationRepository.getSavedLocations()
}