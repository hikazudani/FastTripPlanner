package br.edu.ifsp.scl.sc3038432.fasttripplanner.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/* Text field with a label above the input. */
@Composable
fun LabeledTextField(
    label: String,
    value: String,
    onValueChange: ( String ) -> Unit,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default // Allows defining the keyboard type
) {
    Column( modifier = modifier ) {
        Text( text = label, modifier = Modifier.padding( bottom = 4.dp) )
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = keyboardOptions
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LabeledTextFieldPreview() {
    LabeledTextField(
        label = "Destino",
        value = "São Carlos",
        onValueChange = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun LabeledTextFieldNumericPreview() {
    LabeledTextField(
        label = "Dias",
        value = "7",
        onValueChange = {},
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}