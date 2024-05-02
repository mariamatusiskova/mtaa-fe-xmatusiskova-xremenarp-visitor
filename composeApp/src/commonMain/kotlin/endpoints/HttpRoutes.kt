/**
 * The module contains an object for HTTP routes full of constants.
 */

package endpoints

/**
 * Object containing constants for various HTTP routes used in the application.
 */
object HttpRoutes {

    /**
     * Base URLs of the API. One for emulator and one for real device.
     */
    private const val API_BASE_URL = "http://10.0.2.2:8000" // on emulator
    //private const val API_BASE_URL = "http://10.10.40.110:8000" // on device (your IP address)

    /**
     * Endpoint for user signup.
     */
    const val SIGNUP_POST = "$API_BASE_URL/api/signup/"

    /**
     * Endpoint for user login.
     */
    const val LOGIN_POST = "$API_BASE_URL/api/login/"

    /**
     * Endpoint for editing user profile.
     */
    const val EDIT_PROFILE = "$API_BASE_URL/api/edit_profile/"

    /**
     * Endpoint for deleting user account.
     */
    const val DELETE_ACCOUNT = "$API_BASE_URL/api/delete_account/"

    /**
     * Endpoint for getting all places for client and server database.
     */
    const val API_GET_ALL_PLACES = "$API_BASE_URL/api/get_all_places/"
    const val SERVER_GET_ALL_PLACES = "$API_BASE_URL/server/get_all_places/"

    /**
     * Endpoint for accessing a specific place.
     */
    const val PLACE = "$API_BASE_URL/api/place/"

    /**
     * Endpoint for getting all user favourites places.
     */
    const val GET_ALL_FAVOURITES = "$API_BASE_URL/api/get_all_favourites/"

    /**
     * Endpoint for getting places based on user location.
     */
    const val LOCATION_PLACES = "$API_BASE_URL/api/location_places/"

    /**
     * Endpoint for getting places based on category.
     */
    const val PLACE_CATEGORY = "$API_BASE_URL/api/place_category/"

    /**
     * Endpoint for adding a favourite user place.
     */
    const val ADD_FAVOURITE = "$API_BASE_URL/api/add_favourite/"

    /**
     * Endpoint for deleting a favourite user place.
     */
    const val DELETE_FAVOURITE = "$API_BASE_URL/api/delete_favourite/"

    /**
     * Endpoint for adding or editing a note.
     */
    const val ADD_EDIT_NOTE = "$API_BASE_URL/api/add_edit_note/"

    /**
     * Endpoint for deleting a note.
     */
    const val DELETE_NOTE = "$API_BASE_URL/api/delete_note/"

    /**
     * Endpoint for getting a note.
     */
    const val GET_NOTE = "$API_BASE_URL/api/get_note/"

    /**
     * Endpoint for adding a user's own place.
     */
    const val ADD_MY_PLACE = "$API_BASE_URL/api/add_my_place/"

    /**
     * Endpoint for editing a user's own place.
     */
    const val EDIT_MY_PLACE = "$API_BASE_URL/api/edit_my_place/"

    /**
     * Endpoint for deleting a user's own place.
     */
    const val DELETE_MY_PLACE = "$API_BASE_URL/api/delete_my_place/"

    /**
     * Endpoint for getting all user's own places.
     */
    const val GET_MY_PLACES = "$API_BASE_URL/api/get_my_places/"

    /**
     * Endpoint for getting all user's own place according to id in the body of request.
     */
    const val GET_MY_PLACE = "$API_BASE_URL/api/get_my_place/"

    /**
     * Endpoint for updating the database.
     */
    const val UPDATE_DATABASE = "$API_BASE_URL/api/update_databse/"
}