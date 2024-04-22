package endpoints.dto.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class GetAllPlacesResponse (
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name_name: String,
    @SerialName("image_name")
    val image_name: String,
    @SerialName("description")
    val description: String,
    @SerialName("contact")
    val contact: String,
    @SerialName("address")
    val address: String,
    @SerialName("gps")
    val gps: String,
    @SerialName("meals")
    val meals: String,
    @SerialName("accomodation")
    val accommodation: String,
    @SerialName("sport")
    val sport: String,
    @SerialName("hiking")
    val hiking: String,
    @SerialName("fun")
    val fun_fun: String,
    @SerialName("events")
    val events: String,
    @SerialName("image_data")
    val image_data: String?
)