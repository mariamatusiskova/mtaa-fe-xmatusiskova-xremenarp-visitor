package endpoints

object HttpRoutes {

    private const val API_BASE_URL = "http://10.0.2.2:8000" // on emulator
    //private const val API_BASE_URL = "http://10.10.40.110:8000" // on device (your IP address)
    const val SIGNUP_POST = "$API_BASE_URL/api/signup/"
    const val LOGIN_POST = "$API_BASE_URL/api/login/"
    const val API_GET_ALL_PLACES = "$API_BASE_URL/api/get_all_places/"
    const val SERVER_GET_ALL_PLACES = "$API_BASE_URL/server/get_all_places/"
    const val PLACE = "$API_BASE_URL/api/place/"
    const val GET_ALL_FAVOURITES = "$API_BASE_URL/api/get_all_favourites/"
    const val LOCATION_PLACES = "$API_BASE_URL/api/location_places/"
    const val PLACE_CATEGORY = "$API_BASE_URL/api/place_category/"
    const val ADD_FAVOURITE = "$API_BASE_URL/api/add_favourite/"
    const val DELETE_FAVOURITE = "$API_BASE_URL/api/delete_favourite/"
    const val ADD_EDIT_NOTE = "$API_BASE_URL/api/add_edit_note/"
    const val DELETE_NOTE = "$API_BASE_URL/api/delete_note/"
    const val GET_NOTE = "$API_BASE_URL/api/get_note/"
    const val ADD_MY_PLACE = "$API_BASE_URL/api/add_my_place/"
    const val EDIT_MY_PLACE = "$API_BASE_URL/api/edit_my_place/"
    const val DELETE_MY_PLACE = "$API_BASE_URL/api/delete_my_place/"
    const val GET_MY_PLACES = "$API_BASE_URL/api/get_my_places/"
    const val GET_MY_PLACE = "$API_BASE_URL/api/get_my_place/"
    const val UPDATE_DATABASE = "$API_BASE_URL/api/update_databse/"
}

// 58367