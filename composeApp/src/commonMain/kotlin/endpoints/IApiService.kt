/**
 * Interface defining API service methods.
 */

package endpoints

import TokenManager
import endpoints.dto.requests.LoginRequest
import endpoints.dto.requests.SignupRequest
import endpoints.dto.responses.DetailResponse
import endpoints.dto.responses.GetAllPlacesResponse

interface IApiService {
    /**
     * Retrieves all places from the API request.
     *
     * @param[tokenManager] TokenManager instance for authentication.
     * @return List of GetAllPlacesResponse containing information about all places.
     */
    suspend fun apiGetAllPlaces(tokenManager: TokenManager): List<GetAllPlacesResponse>
    /**
     * Registration process.
     *
     * @param[signupRequest] SignupRequest (instance) object containing user registration details.
     * @return DetailResponse containing registration status and details, null if an error occurs.
     */
    suspend fun postSignup(signupRequest: SignupRequest): DetailResponse? // could be null in case sth goes wrong\
    /**
     * Login process.
     *
     * @param[loginRequest] SignupRequest (instance) object containing user login credentials.
     * @return String containing token, null if an error occurs.
     */
    suspend fun postLogin(loginRequest: LoginRequest): String?
    /**
     * Edits user profile.
     *
     * @param[tokenManager] TokenManager instance for authentication.
     * @param[editProfileRequest] Any (instance) object representing the request for profile editing.
     * @return DetailResponse containing status and details from request, null if an error occurs.
     */
    suspend fun patchEditProfile(tokenManager: TokenManager, editProfileRequest: Any): DetailResponse?
    /**
     * Deletes user account.
     *
     * @param[tokenManager] TokenManager instance for authentication.
     * @return DetailResponse containing status and details from request, null if an error occurs.
     */
    suspend fun deleteAccount(tokenManager: TokenManager): DetailResponse?
}