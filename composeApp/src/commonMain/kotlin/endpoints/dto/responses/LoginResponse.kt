package endpoints.dto.responses

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a response containing a JWT token after a successful login attempt.
 *
 * @property jwtToken The JWT token generated for the authenticated user.
 */
@Serializable
class LoginResponse (
    @SerialName("jwt_token")
    val jwtToken: String
)