package com.d121211060.Bola.ui.activities.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.d121211060.Bola.data.models.Result
import com.d121211060.Bola.ui.theme.D121211060BolaTheme

class DetailActivity : ComponentActivity() {

    private var selectedMatch: Result? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectedMatch = intent.getParcelableExtra("MATCH")
        setContent {
            D121211060BolaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailScreen()
                }
            }
        }
    }

    @Composable
    fun DetailScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Match Teams
            Text(
                text = "${selectedMatch?.event_home_team} vs ${selectedMatch?.event_away_team}",
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Match Score
            Text(
                text = "${selectedMatch?.event_time}",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Match Poster
//            AsyncImage(
//                model = ImageRequest.Builder(context = LocalContext.current)
//                    .data("Your Image URL Here")
//                    .crossfade(true)
//                    .build(),
//                contentDescription = "Match Poster",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(400.dp)
//                    .clip(RoundedCornerShape(8.dp)),
//                contentScale = ContentScale.Crop
//            )

            Spacer(modifier = Modifier.height(16.dp))

            // Other details like venue, date, etc. can be added here
            Text(
                text = "Venue: ${selectedMatch?.stage_name}",
                style = MaterialTheme.typography.bodySmall
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Date: ${selectedMatch?.event_status}",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}