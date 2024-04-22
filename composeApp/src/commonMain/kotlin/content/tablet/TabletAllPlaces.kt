package content.tablet

import TokenManagerProvider
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import endpoints.dto.responses.GetAllPlacesResponse
import getPlatform
import kotlinx.coroutines.launch
import menu.navigationState
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun loadTabletAllPlaces(context: Any?) {

    val scope = rememberCoroutineScope()
    val platform = getPlatform()
    val client = platform.create()
    val tokenManager = context?.let { TokenManagerProvider.provideTokenManager(it) }
    val placesState = remember { mutableStateOf<List<GetAllPlacesResponse>?>(null) }

    scope.launch {
        val places = tokenManager?.let { it1 ->
            client.apiGetAllPlaces(
                it1
            )
        }
        placesState.value = places
    }

    LazyColumn {
        // Use placesState.value to get the list of places
        itemsIndexed(placesState.value.orEmpty()) { index, place ->
            Spacer(modifier = Modifier.height(10.dp))

            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(backgroundColor = if (navigationState.darkmode) Color.Gray else Color(0xFFA1A556)),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(
                        text = place.name_name,
                        color = Color(0xFFE4E4E4),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = place.description,
                        color = Color(0xFFE4E4E4),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                    Text(
                        text = "Contact: ${place.contact}",
                        color = Color(0xFFE4E4E4),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                    Text(
                        text = "Address: ${place.address}",
                        color = Color(0xFFE4E4E4),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(top = 4.dp)
                    )

                }
            }
        }
    }
}