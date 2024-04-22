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
    val meals: Boolean,
    @SerialName("accommodation")
    val accommodation: Boolean,
    @SerialName("sport")
    val sport: Boolean,
    @SerialName("hiking")
    val hiking: Boolean,
    @SerialName("fun")
    val fun_fun: Boolean,
    @SerialName("events")
    val events: Boolean
)