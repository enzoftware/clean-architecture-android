package com.projects.enzoftware.fakegeolocation.ui.model

import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import com.projects.enzoftware.domain.Location as DomainLocation

data class Location (val coordinates: String, val date: String)

fun DomainLocation.toPresentationModel(): Location
        = Location("${latitude.toPrettifiedString()} , ${longitude.toPrettifiedString()}",
                    date.toPrettifiedString())

private fun Date.toPrettifiedString(): String
        = SimpleDateFormat.getDateTimeInstance().run { format(this@toPrettifiedString) }

private fun Double.toPrettifiedString(): String {
    val df = DecimalFormat("#.###")
    df.roundingMode = RoundingMode.CEILING
    return df.format(this)
}