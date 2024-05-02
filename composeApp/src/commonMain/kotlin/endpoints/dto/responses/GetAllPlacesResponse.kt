package endpoints.dto.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a response containing information about all places.
 * @property[id] The unique identifier/UUID of the place.
 * @property[name_name] The name of the place.
 * @property[image_name] The name of the image associated with the place.
 * @property[description] The description of the place.
 * @property[contact] The contact information of the place.
 * @property[address] The address of the place.
 * @property[gps] The GPS coordinates of the place.
 * @property[meals] Boolean: If the category of the place is type meals.
 * @property[accommodation] Boolean: If the category of the place is type accommodation.
 * @property[sport] Boolean: If the category of the place is type sport.
 * @property[hiking] Boolean: If the category of the place is type hiking.
 * @property[fun_fun] Boolean: If the category of the place is type fun.
 * @property[events] Boolean: If the category of the place is type events.
 * @property[image_data] Optional data representing the image in bytes.
 */
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