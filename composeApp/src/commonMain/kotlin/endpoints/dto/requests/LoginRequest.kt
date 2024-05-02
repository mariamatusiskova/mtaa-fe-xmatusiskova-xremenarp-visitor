package endpoints.dto.requests

import kotlinx.serialization.Serializable

/**
 * Represents a login request with a username and password.
 *
 * @property[username] The username provided for authentication.
 * @property[password] The password provided for authentication.
 */
@Serializable
class LoginRequest (
    val username: String,
    val password: String
)