package br.edu.ifsp.scl.sc3038432.fasttripplanner


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.edu.ifsp.scl.sc3038432.fasttripplanner.ui.screens.TripOptionsScreen

/*
 * Receives trip data from TripInputActivity,
 * collects accommodation and service options,
 * and navigates to the summary screen with all data.
 */
class TripOptionsActivity : ComponentActivity() {

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate(savedInstanceState)

        val destination = intent.getStringExtra("destination") ?: ""
        val days = intent.getIntExtra("days", 0)
        val budget = intent.getDoubleExtra("budget", 0.0)

        setContent {
            TripOptionsScreen(
                destination = destination,
                days = days,
                budget = budget,
                onBack = { finish() },
                onCalculate = { accommodation, hasTransport, hasFood, hasEconomic, hasTours ->
                    val nextIntent = Intent(this, TripSummaryActivity::class.java)

                    nextIntent.putExtra("destination", destination)
                    nextIntent.putExtra("days", days)
                    nextIntent.putExtra("budget", budget)

                    nextIntent.putExtra("accommodation", accommodation)
                    nextIntent.putExtra("hasTransport", hasTransport)
                    nextIntent.putExtra("hasFood", hasFood)
                    nextIntent.putExtra("hasEconomic", hasEconomic)
                    nextIntent.putExtra("hasTours", hasTours)

                    startActivity(nextIntent)
                }
            )
        }
    }

}
