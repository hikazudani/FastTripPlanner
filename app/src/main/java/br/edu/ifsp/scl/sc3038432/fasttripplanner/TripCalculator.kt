package br.edu.ifsp.scl.sc3038432.fasttripplanner

// Constants for business rules
const val DAILY_FOOD_COST = 50.0
const val DAILY_TOUR_COST = 120.0
const val TRANSPORT_FIXED_FEE = 300.0

// Accommodation Multipliers
const val MULTIPLIER_COMFORT = 1.5
const val MULTIPLIER_LUXURY = 2.2
const val MULTIPLIER_ECONOMY = 1.0


/**
 * Calculates the total trip cost:
 * (Days * Budget * Multiplier) + Extra Costs
*/
fun calculateTotal(
    days: Int,
    budget: Double,
    accommodation: String,
    hasTransport: Boolean,
    hasFood: Boolean,
    hasTours: Boolean
): Double {
    val multiplier = when (accommodation) {
        "Conforto" -> MULTIPLIER_COMFORT
        "Luxo" -> MULTIPLIER_LUXURY
        else -> MULTIPLIER_ECONOMY
    }

    val base = days * budget * multiplier

    val extra = calculateExtra(days, hasTransport, hasFood, hasTours)

    return base + extra
}

/**
 * Calculates the sum of optional additional costs.
*/
private fun calculateExtra(
    days: Int,
    hasTransport: Boolean,
    hasFood: Boolean,
    hasTours: Boolean
): Double {
    var totalExtra = 0.0

    if ( hasTransport ) {
        totalExtra += TRANSPORT_FIXED_FEE
    }

    if ( hasFood ) {
        totalExtra += DAILY_FOOD_COST * days
    }

    if ( hasTours ) {
        totalExtra += DAILY_TOUR_COST * days
    }

    return totalExtra
}