package com.dsergei.run.network

import kotlinx.serialization.Serializable

@Serializable
data class CreateRunRequest(
    val durationMillis: Long,
    val distanceMeters: Int,
    val epochMillis: Long,
    val lat: Double,
    val long: Double,
    val totalElevationMeters: Int,
    val id: String
)