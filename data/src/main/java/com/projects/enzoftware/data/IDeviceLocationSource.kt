package com.projects.enzoftware.data

import com.projects.enzoftware.domain.Location

interface IDeviceLocationSource {

    fun getDeviceLocation() : Location
}