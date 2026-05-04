package br.edu.ifsp.scl.sc3038432.fasttripplanner.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.edu.ifsp.scl.sc3038432.fasttripplanner.calculateTotal
import br.edu.ifsp.scl.sc3038432.fasttripplanner.ui.components.PrimaryButton
import java.text.NumberFormat
import java.util.Locale

// pt-BR monetary format: R$ 1.234,56
private val currencyFormat = NumberFormat
    .getCurrencyInstance(Locale.forLanguageTag("pt-BR"))

@Composable
fun TripSummaryScreen(
    destination: String,
    days: Int,
    budget: Double,
    accommodation: String,
    hasTransport: Boolean,
    hasFood: Boolean,
    hasTours: Boolean,
    onNewTrip: () -> Unit
) {
    // calculate in the composition
    val total = calculateTotal(
        days = days,
        budget = budget,
        accommodation = accommodation,
        hasTransport = hasTransport,
        hasFood = hasFood,
        hasTours = hasTours
    )

    val totalFormatted = currencyFormat.format(total)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Resumo da Viagem",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        SummarySection(title = "Destino") {
            SummaryRow(label = "Local", value = destination)
        }

        Spacer(modifier = Modifier.height(12.dp))

        SummarySection(title = "Dados da viagem") {
            SummaryRow(label = "Duração", value = "$days dia${if (days > 1) "s" else ""}")
            SummaryRow(
                label = "Orçamento diário",
                value = currencyFormat.format(budget)
            )
            SummaryRow(label = "Hospedagem", value = accommodation)
        }

        Spacer(modifier = Modifier.height(12.dp))

        SummarySection(title = "Serviços adicionais") {
            // List only the selected services or No services selected
            val services = buildList {
                if (hasTransport) add("Transporte")
                if (hasFood) add("Alimentação")
                if (hasTours) add("Passeios")
            }
            if (services.isEmpty()) {
                Text(text = "Nenhum serviço adicional", fontSize = 14.sp)
            } else {
                services.forEach { service ->
                    Text(text = "• $service", fontSize = 14.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Total
        Text(
            text = "Total estimado",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = totalFormatted,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        PrimaryButton(
            text = "Novo Planejamento",
            onClick = onNewTrip
        )
    }
}

/** Section with title and content */
@Composable
private fun SummarySection(
    title: String,
    content: @Composable () -> Unit
) {
    Text(
        text = title,
        fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold
    )
    Spacer(modifier = Modifier.height(4.dp))
    Column(modifier = Modifier.padding(start = 12.dp)) {
        content()
    }
}


@Composable
private fun SummaryRow(label: String, value: String) {
    Text(text = "$label: $value", fontSize = 14.sp)
}

@Preview(showBackground = true)
@Composable
private fun TripSummaryScreenPreview() {
    TripSummaryScreen(
        destination = "NY",
        days = 7,
        budget = 500.0,
        accommodation = "Conforto",
        hasTransport = true,
        hasFood = true,
        hasTours = false,
        onNewTrip = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun TripSummaryScreenNoServicesPreview() {
    TripSummaryScreen(
        destination = "Curitiba",
        days = 3,
        budget = 200.0,
        accommodation = "Economica",
        hasTransport = false,
        hasFood = false,
        hasTours = false,
        onNewTrip = {}
    )
}