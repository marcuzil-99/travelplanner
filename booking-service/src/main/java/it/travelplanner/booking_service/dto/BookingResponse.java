package it.travelplanner.booking_service.dto;

public record BookingResponse(
    Long id,
    String customerName,
    String customerEmail,
    String destination,
    String status
) {}