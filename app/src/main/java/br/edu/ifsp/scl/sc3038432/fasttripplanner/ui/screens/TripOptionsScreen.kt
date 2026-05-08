package br.edu.ifsp.scl.sc3038432.fasttripplanner.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifsp.scl.sc3038432.fasttripplanner.ui.components.AccommodationSelector
import br.edu.ifsp.scl.sc3038432.fasttripplanner.ui.components.PrimaryButton
import br.edu.ifsp.scl.sc3038432.fasttripplanner.ui.components.ServiceCheckboxGroup

/*
 * Second screen. Displays a summary of the trip data received from TripInputScreen,
 * allows selecting accommodation type and additional services,
 * and navigates to the summary screen with the collected options.
 */
@Composable
fun TripOptionsScreen(
    destination: String,
    days: Int,
    budget: Double,
    onBack: ()-> Unit,
    onCalculate: (
            accommodation: String,
            hasTransport: Boolean,
            hasFood: Boolean,
            hasEconomic: Boolean,
            hasTours: Boolean
            ) -> Unit
) {
    var accommodation by rememberSaveable { mutableStateOf("Economica") }
    var hasTransport by rememberSaveable { mutableStateOf(false) }
    var hasFood by rememberSaveable { mutableStateOf(false) }
    var hasTours by rememberSaveable { mutableStateOf(false) }
    // new mode
    var hasEconomic by rememberSaveable {mutableStateOf(false)}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Opções da viagem",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        // Resume of the previous screen
        Text( text = "Destino: $destination" )
        Text( text = "Dias: $days | Orçamento diario: R$ ${"%.2f".format(budget)}" )

        Spacer(modifier = Modifier.height(20.dp))


        //{if (days > 1) "s" else ""}
        AccommodationSelector(
            selected = if (hasEconomic) "Economica" else accommodation ,
            onSelectionChange = { accommodation = it }
        )

        Spacer(modifier = Modifier.height(20.dp))

        ServiceCheckboxGroup(
            hasTransport = hasTransport,
            hasFood = hasFood,
            hasTours = if(hasEconomic) false else hasTours,
            hasEconomic = hasEconomic,
            onTransportChange = { hasTransport = it },
            onFoodChange = { hasFood = it },
            onToursChange = { hasTours = it },
            onEconomicChange = { hasEconomic = it }
        )

        Spacer(modifier = Modifier.height(24.dp))



        Spacer(modifier = Modifier.height(24.dp))
        // Buttons Row
        Row {
            PrimaryButton(
                text = "Voltar",
                onClick = onBack,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            PrimaryButton(
                text = "Calcular",
                onClick = { onCalculate(accommodation, hasTransport, hasFood, hasEconomic, hasTours) },
                modifier = Modifier.weight(2f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TripOptionsScreenPreview() {
    TripOptionsScreen(
        destination = "São Carlos",
        days = 7,
        budget = 500.0,
        onBack = {},
        onCalculate = { _, _, _, _,_ -> }
    )
}