package com.d121211060.Bola.ui.activities.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.d121211060.Bola.data.models.Result
import com.d121211060.Bola.ui.activities.detail.DetailActivity
import com.d121211060.Bola.ui.theme.D121211060BolaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            D121211060BolaTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val mainViewModel: MainViewModel = viewModel(factory = MainViewModel.Factory)
                    MatchListScreen(mainViewModel.mainUiState)

                }
            }
        }
    }

    @Composable
    fun CenterText(text: String) {
        // Wrap the content with a Box to apply the centering modifiers
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp), // Optional padding
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
            )
        }
    }

    @Composable
    private fun MatchListScreen(mainUiState: MainUiState, modifier: Modifier = Modifier) {
        when (mainUiState) {
            is MainUiState.Loading -> CenterText(text = "Loading...")
            is MainUiState.Error -> CenterText(text = "Something Error")
            is MainUiState.Success -> MatchList(mainUiState.match)
        }
    }

    @Composable
    fun MatchList(matches: List<com.d121211060.Bola.data.models.Result>, modifier: Modifier = Modifier) {
        LazyColumn(modifier = modifier) {
            items(matches) { match ->
                MatchItem(match = match)
            }
        }
    }

    @Composable
    fun MatchItem(match: Result) {
        Box(
            modifier = Modifier
                .padding(16.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp),)
                .clickable {
                    val intent = Intent(this, DetailActivity::class.java)
                    intent.putExtra("MATCH", match)
                    startActivity(intent)
                }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                // Match Teams
                Text(
                    text = "${match.event_home_team} vs ${match.event_away_team}",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Match Score
                Text(
                    text = "${match.event_time}",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Other details like venue, date, etc. can be added here
                Text(
                    text = "Venue: ${match.stage_name}",
                    style = MaterialTheme.typography.bodySmall
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Date: ${match.event_status}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
