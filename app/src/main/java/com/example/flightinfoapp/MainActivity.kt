package com.example.flightinfoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flightinfoapp.ui.theme.FlightInfoAppTheme
import net.skyscanner.backpack.compose.card.BpkCard
import net.skyscanner.backpack.compose.card.BpkCardCorner
import net.skyscanner.backpack.compose.text.BpkText
import net.skyscanner.backpack.compose.theme.BpkTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlightInfoAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FlightInfoScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun FlightInfoScreen(modifier: Modifier = Modifier) {
    var flightNumber by remember { mutableStateOf("SK123") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        FlightCard(title = "Flight Number", value = flightNumber)
        FlightCard(title = "Departure", value = "JFK - 08:30 AM")
        FlightCard(title = "Arrival", value = "LAX - 11:45 AM")

        Button(onClick = { flightNumber = "SK456" }) {
            Text(text = "Update Flight Number")
        }
    }
}

@Composable
fun FlightCard(title: String, value: String) {
    BpkCard(
        modifier = Modifier.fillMaxWidth(),
        corner = BpkCardCorner.Large
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            BpkText(text = title, style = BpkTheme.typography.heading3)
            BpkText(text = value, style = BpkTheme.typography.bodyDefault)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FlightInfoPreview() {
    FlightInfoAppTheme {
        FlightInfoScreen()
    }
}