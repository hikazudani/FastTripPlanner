package br.edu.ifsp.scl.sc3038432.fasttripplanner.ui.screens

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifsp.scl.sc3038432.fasttripplanner.R
import br.edu.ifsp.scl.sc3038432.fasttripplanner.ui.components.LabeledTextField
import br.edu.ifsp.scl.sc3038432.fasttripplanner.ui.components.PrimaryButton

/*
 * First screen of the app. Collects destination, number of days
 * and daily budget, validates the inputs and navigates to the options screen.
 */
@Composable
fun TripInputScreen(
    onNext: (destination: String, days: Int, budget: Double) -> Unit
) {

    val context = LocalContext.current

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
            onClick = {
                val error = validateInputs(destination, days, budget)
                if ( error == null ) {
                    onNext(destination, days.toInt(), budget.toDouble() )
                } else {
                    Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
                }
            }
        )
    }
}

private fun validateInputs(destination: String, days: String, budget: String): String? {
    if ( destination.isBlank() ) {
        return "Informe o destino"
    }

    val parsedDays = days.toIntOrNull()

    if (parsedDays == null || parsedDays <= 0) {
        return "Informe um número de dias válido"
    }

    val parsedBudget = budget.toDoubleOrNull()

    if (parsedBudget == null || parsedBudget <= 0) {
        return "Informe um orçamento válido"
    }

    return null
}

@Preview(showBackground = true)
@Composable
private fun TripInputScreenPreview(){
    TripInputScreen(onNext = { _, _, _ ->})
}

