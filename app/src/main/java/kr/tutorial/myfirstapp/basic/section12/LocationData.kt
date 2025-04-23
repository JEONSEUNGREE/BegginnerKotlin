package kr.tutorial.myfirstapp.basic.section12

data class LocationData(
    val latitude: Double,
    val longitude: Double
)

data class GeocodingResponse(
    val results: List<GeocodingResult>,
    val status: String
)

data class GeocodingResult (
    val formatted_address: String
)