package week3.w33_programming_assignment.taxi_park

fun driver(i: Int) = Driver("D-$i")
fun passenger(i: Int) = Passenger("P-$i")

fun drivers(indices: List<Int>) = indices.map(::driver).toSet()
fun drivers(range: IntRange) = drivers(range.toList())
fun drivers(vararg indices: Int) = drivers(indices.toList())

fun passengers(indices: List<Int>) = indices.map(::passenger).toSet()
fun passengers(range: IntRange) = passengers(range.toList())
fun passengers(vararg indices: Int) = passengers(indices.toList())

fun taxiPark(driverIndexes: IntRange, passengerIndexes: IntRange, vararg trips: Trip) =
    TaxiPark(drivers(driverIndexes), passengers(passengerIndexes), trips.toList())

fun trip(
    driverIndex: Int,
    passengerIndexes: List<Int>,
    duration: Int = 10,
    distance: Double = 3.0,
    discount: Double? = null
) =
    Trip(driver(driverIndex), passengers(passengerIndexes), duration, distance, discount)

fun trip(driverIndex: Int, passenger: Int, duration: Int = 10, distance: Double = 3.0, discount: Double? = null) =
    Trip(driver(driverIndex), passengers(passenger), duration, distance, discount)

fun TaxiPark.display() = buildString {
    appendln()
    appendln("Taxi park:")
    appendln("Drivers: ${allDrivers.map { it.name }}")
    appendln("Passengers: ${allPassengers.map { it.name }}")
    appendln("Trips: ${trips.map { it.display() }}")
}

fun Trip.display(): String {
    val discountText = discount?.let { ", $it" } ?: ""
    return "(${driver.name}, ${passengers.map { it.name }}, $duration, $distance$discountText)"
}

fun main() {
    val taxi = taxiPark(
        0..5, 0..5,
        trip(3, listOf(2), duration = 5, distance = 4.0, discount = 0.3),
        trip(3, listOf(5, 2, 0), duration = 13, distance = 1.0, discount = 0.2),
        trip(2, listOf(1, 2, 0), duration = 33, distance = 23.0),
        trip(2, listOf(5, 4), duration = 16, distance = 5.0),
        trip(0, listOf(2, 1), duration = 37, distance = 20.0),
        trip(1, listOf(2, 4), duration = 18, distance = 22.0),
        trip(3, listOf(5), duration = 20, distance = 27.0, discount = 0.1),
        trip(1, listOf(0, 4), duration = 18, distance = 13.0, discount = 0.1),
        trip(4, listOf(1, 3), duration = 19, distance = 31.0, discount = 0.2),
        trip(3, listOf(4), duration = 29, distance = 11.0, discount = 0.1)
    )


    println(
        taxi.trips
            .groupBy {
                val start = it.duration / 10 * 10
                val end = start + 9
                start..end
            }
            .toList()
            .maxByOrNull { (_, group) -> group.size }
            ?.first
    )



}