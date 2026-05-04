package br.edu.ifsp.scl.sc3038432.fasttripplanner.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifsp.scl.sc3038432.fasttripplanner.R
import br.edu.ifsp.scl.sc3038432.fasttripplanner.ui.components.LabeledTextField
import br.edu.ifsp.scl.sc3038432.fasttripplanner.ui.components.PrimaryButton

@Composable
fun TripInputScreen(
    onNext: (destination: String, days: Int, budget: Double) -> Unit
) {

    var destination by rememberSaveable { mutableStateOf("") }
    var days by rememberSaveable { mutableStateOf("") }
    var budget by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = stringResource(R.string.app_name),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        LabeledTextField(
            label = "Destino",
            value = destination,
            onValueChange = { destination = it }
        )
        LabeledTextField(
            label = "Número de dias",
            value = days,
            onValueChange = { days = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        LabeledTextField(
            label = "Orçamento diário (R$)",
            value = budget,
            onValueChange = { budget = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )

        PrimaryButton(
            text = "Próximo",
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TripInputScreenPreview(){
    TripInputScreen(onNext = { _, _, _ ->})
}

