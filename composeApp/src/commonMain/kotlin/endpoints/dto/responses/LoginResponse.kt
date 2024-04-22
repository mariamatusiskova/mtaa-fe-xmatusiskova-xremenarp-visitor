package endpoints.dto.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class LoginResponse (
    @SerialName("jwt_token")
    val jwtToken: String
)