package com.projects.enzoftware.fakegeolocation.framework

import com.projects.enzoftware.data.IDeviceLocationSource
import com.projects.enzoftware.data.ILocationPersistenceSource
import com.projects.enzoftware.domain.Location
import java.util.*

class FakeLocationSource : IDeviceLocationSource {

    private val random : Random = Random(System.currentTimeMillis())

    override fun getDeviceLocation(): Location = Location(random.nextDouble() * 180 - 90,
                                                        random.nextDouble()*360-180,
                                                                Date())




}