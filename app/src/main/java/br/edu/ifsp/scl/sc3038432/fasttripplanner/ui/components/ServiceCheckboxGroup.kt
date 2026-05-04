package br.edu.ifsp.scl.sc3038432.fasttripplanner.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ServiceCheckboxGroup(
    hasTransport: Boolean,
    hasFood: Boolean,
    hasTours: Boolean,
    onTransportChange: (Boolean) -> Unit,
    onFoodChange: (Boolean) -> Unit,
    onToursChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Column( modifier = modifier ) {
        Text(
            text = "Serviços adicionais",
            fontSize = 16.sp,
            modifier = Modifier.padding( bottom = 4.dp )
        )

        ServiceCheckboxRow(
            label = "Transporte  (+ R$ 300)",
            checked = hasTransport,
            onCheckedChange = onTransportChange
        )
        ServiceCheckboxRow(
            label = "Alimentação (+ R$ 50/dia)",
            checked = hasFood,
            onCheckedChange = onFoodChange
        )
        ServiceCheckboxRow(
            label = "Passeios (+ R$ 120/dia)",
            checked = hasTours,
            onCheckedChange = onToursChange
        )
    }
}

@Composable
private fun ServiceCheckboxRow(
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding( vertical = 2.dp )
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        Text(
            text = label,
            modifier = Modifier.padding( start = 8.dp)
        )
    }
}

@Preview( showBackground = true )
@Composable
private fun ServiceCheckboxGroupPreview() {
    ServiceCheckboxGroup(
        hasTransport = true,
        hasFood = true,
        hasTours = true,
        onTransportChange = {},
        onFoodChange = {},
        onToursChange = {}
    )
}