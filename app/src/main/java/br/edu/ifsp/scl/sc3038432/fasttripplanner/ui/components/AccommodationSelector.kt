package br.edu.ifsp.scl.sc3038432.fasttripplanner.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val accommodationOptions = listOf("Economica", "Conforto", "Luxo")

/* Radio button group for selecting the accommodation type. */
@Composable
fun AccommodationSelector(
    selected: String,
    onSelectionChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column( modifier = modifier ) {
        Text(
            text = "Hospedagem",
            fontSize = 16.sp,
            modifier = Modifier.padding( bottom = 4.dp )
        )
        accommodationOptions.forEach { option ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp)
            ) {
                RadioButton(
                    selected = selected == option,
                    onClick = { onSelectionChange(option) }
                )
                Text(
                    text = option,
                    modifier = Modifier.padding( start = 8.dp )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AccommodationSelectorPreview() {
    AccommodationSelector(
        selected = accommodationOptions[1],
        onSelectionChange = {}
    )
}