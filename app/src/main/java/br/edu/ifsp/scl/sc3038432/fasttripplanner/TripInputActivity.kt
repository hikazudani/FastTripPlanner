package br.edu.ifsp.scl.sc3038432.fasttripplanner

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.edu.ifsp.scl.sc3038432.fasttripplanner.ui.screens.TripInputScreen


class TripInputActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripInputScreen(
                onNext = { destination, days, budget ->
                    val intent = Intent(this, TripOptionsActivity::class.java)
                    intent.putExtra("destination", destination)
                    intent.putExtra("days", days)
                    intent.putExtra("budget", budget)
                    startActivity(intent)
                }
            )
        }
    }
}