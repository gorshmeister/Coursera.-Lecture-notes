package week3.w33_programming_assignment.taxi_park

/*
    task 1
 */
fun TaxiPark.findFakeDrivers1(): Set<Driver> =
    allDrivers.filter { d -> trips.none() { it.driver == d } }.toSet()

fun TaxiPark.findFakeDrivers2(): Set<Driver> =
    allDrivers - trips.map { it.driver }

/*
    task 2
 */
fun TaxiPark.findFaithfulPassengers1(minTrips: Int): Set<Passenger> =
    trips
        .flatMap { it.passengers }
        .groupBy { it }
        .filter { it.value.size >= minTrips }
        .map { it.key }
        .toSet()

fun TaxiPark.findFaithfulPassengers1moreBetter(minTrips: Int): Set<Passenger> =
    trips
        .flatMap(Trip::passengers)
        .groupBy { passenger -> passenger }
        .filterValues { group -> group.size >= minTrips }
        .keys

//  2 варианта решения

fun TaxiPark.findFaithfulPassengers2(minTrips: Int): Set<Passenger> =
    allPassengers
        .partition { p ->
            trips.sumBy { t ->
                if (p in t.passengers) 1 else 0
            } >= minTrips
        }
        .first
        .toSet()

fun TaxiPark.findFaithfulPassengers2moreBetter(minTrips: Int): Set<Passenger> =
    allPassengers
        .filter { p ->
            trips.count { p in it.passengers } >= minTrips
        }
        .toSet()

/*
    task 3
 */
fun TaxiPark.findFrequentPassengers1(driver: Driver): Set<Passenger> =
    trips
        .filter { trip -> trip.driver == driver }
        .flatMap(Trip::passengers)
        .groupBy { passenger -> passenger }
        .filterValues { group -> group.size > 1 }
        .keys

fun TaxiPark.findFrequentPassengers2(driver: Driver): Set<Passenger> =
    allPassengers
        .filter { p ->
            trips.count { it.driver == driver && p in it.passengers } > 1
        }
        .toSet()

/*
    task 4
 */
fun TaxiPark.findSmartPassengers1(): Set<Passenger> {
    val pair = trips.partition { it.discount is Double }
    return allPassengers
        .filter { passenger ->
            pair.first.count { it.passengers.contains(passenger) } >
                    pair.second.count() { it.passengers.contains(passenger) }
        }
        .toSet()

}

fun TaxiPark.findSmartPassengers1moreBetter(): Set<Passenger> {
    val (tripsWithDiscount, tripsWithoutDiscount) =
        trips.partition { it.discount != null }
    return allPassengers
        .filter { passenger ->
            tripsWithDiscount.count { passenger in it.passengers } >
                    tripsWithoutDiscount.count() { passenger in it.passengers }
        }
        .toSet()
}

/// 2
fun TaxiPark.findSmartPassengers2moreBetter(): Set<Passenger> =
    allPassengers.filter { p ->
        val withDiscount = trips.count { t -> p in t.passengers && t.discount != null }
        val withoutDiscount = trips.count { t -> p in t.passengers && t.discount == null }
        withDiscount > withoutDiscount
    }.toSet()

/*
    task 5
 */

fun TaxiPark.findTheMostFrequentTripDurationPeriod1(): IntRange? {
    return trips
        .groupBy {
            val start = it.duration / 10 * 10
            val end = start + 9
            start..end
        }
        .toList()
        .maxByOrNull { (_, group) -> group.size }
        ?.first
}

/*
    task 6
 */

fun TaxiPark.checkParetoPrinciple1(): Boolean {
    if (trips.isEmpty()) return false

    val totalIncome = trips.sumByDouble(Trip::cost)
    val sortedDriversIncome: List<Double> = trips
        .groupBy(Trip::driver)
        .map { (_, tripsByDriver) -> tripsByDriver.sumByDouble(Trip::cost) }
        .sortedDescending()

    val numberOfTopDrivers = (0.2 * allDrivers.size).toInt()
    val incomeByTopDrivers = sortedDriversIncome
        .take(numberOfTopDrivers) // take - берет колличество этих элементов с начала списка
        .sum()

    return incomeByTopDrivers >= 0.8 * totalIncome
}










