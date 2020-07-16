package com.jetbrains.handson.mpp.mobile


data class Response(
    val nextOutboundQuery: String? = null,
    val numberOfChildren: Int? = null,
    val outboundJourneys: List<OutboundJourneysItem?>? = null,
    val numberOfAdults: Int? = null,
    val previousOutboundQuery: String? = null,
    val bookingMessages: BookingMessages? = null
)

data class OutboundJourneysItem(
    val departureTime: String? = null,
    val bulletins: List<BulletinsItem?>? = null,
    val tickets: List<TicketsItem?>? = null,
    val journeyId: String? = null,
    val journeyDurationInMinutes: Int? = null,
    val stationMessages: List<Any?>? = null,
    val originStation: OriginStation? = null,
    val journeyOptionToken: String? = null,
    val arrivalTime: String? = null,
    val legs: List<LegsItem?>? = null,
    val primaryTrainOperator: PrimaryTrainOperator? = null,
    val isFastestJourney: Boolean? = null,
    val destinationStation: DestinationStation? = null,
    val status: String? = null
)

data class BulletinsItem(
    val severity: String? = null,
    val description: String? = null,
    val id: Int? = null,
    val title: String? = null,
    val category: String? = null
)

data class TicketsItem(
    val ticketOptionToken: String? = null,
    val fareId: String? = null,
    val ftot: String? = null,
    val ticketClass: String? = null,
    val pricingItem: PricingItem? = null,
    val ticketCategory: String? = null,
    val numberOfTickets: Int? = null,
    val name: String? = null,
    val description: String? = null,
    val ticketType: String? = null,
    val priceInPennies: Int? = null
)

data class PricingItem(
    val breakdown: List<BreakdownItem?>? = null,
    val subTotalInPennies: Int? = null
)

data class BreakdownItem(
    val ticketCount: Int? = null,
    val passenger: String? = null,
    val costInPennies: Int? = null
)

data class OriginStation(
    val nlc: String? = null,
    val crs: String? = null,
    val displayName: String? = null
)

data class LegsItem(
    val mode: String? = null,
    val origin: Origin? = null,
    val legId: String? = null,
    val destination: Destination? = null,
    val durationInMinutes: Int? = null,
    val type: String? = null,
    val trainOperator: TrainOperator? = null,
    val rsid: String? = null,
    val additionalFacilitiesInformation: String? = null,
    val trainFacilities: List<TrainFacilitiesItem?>? = null,
    val departureDateTime: String? = null,
    val arrivalDateTime: String? = null,
    val status: String? = null
)

data class Origin(
    val nlc: String? = null,
    val crs: String? = null,
    val displayName: String? = null
)

data class Destination(
    val nlc: String? = null,
    val crs: String? = null,
    val displayName: String? = null
)

data class TrainOperator(
    val code: String? = null,
    val name: String? = null
)

data class TrainFacilitiesItem(
    val code: String? = null,
    val name: String? = null
)

data class PrimaryTrainOperator(
    val code: String? = null,
    val name: String? = null
)

data class DestinationStation(
    val nlc: String? = null,
    val crs: String? = null,
    val displayName: String? = null
)

data class BookingMessages(
    val messageCentreTitle: String? = null,
    val messages: List<Any?>? = null,
    val doNotShowAgainText: String? = null
)