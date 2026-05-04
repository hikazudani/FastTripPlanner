package br.edu.ifsp.scl.sc3038432.fasttripplanner

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.edu.ifsp.scl.sc3038432.fasttripplanner.ui.screens.TripSummaryScreen

class TripSummaryActivity : ComponentActivity() {

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )

        val destination = intent.getStringExtra( "destination" ) ?: ""
        val days = intent.getIntExtra( "days", 0 )
        val budget = intent.getDoubleExtra( "budget", 0.0 )
        val accommodation = intent.getStringExtra( "accommodation" ) ?: "Economica"
        val hasTransport = intent.getBooleanExtra( "hasTransport", false )
        val hasFood = intent.getBooleanExtra( "hasFood", false )
        val hasTours = intent.getBooleanExtra( "hasTours", false )

        setContent {
            TripSummaryScreen(
                destination = destination,
                days = days,
                budget = budget,
                accommodation = accommodation,
                hasTransport = hasTransport,
                hasFood = hasFood,
                hasTours = hasTours,
                onNewTrip = {

                    val newIntent = Intent(this, TripInputActivity::class.java)
                    newIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(newIntent)
                }
            )
        }
    }
}
