package it.travelplanner.booking_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BookingRequest(

    @NotBlank(message = "Customer name is required")
    @Size(max = 100, message = "Customer name must be at most 100 characters")
    String customerName,

    @NotBlank(message = "Customer email is required")
    @Email(message = "Customer email must be valid")
    @Size(max = 100, message = "Customer email must be at most 100 characters")
    String customerEmail,

    @NotBlank(message = "Destination is required")
    @Size(max = 100, message = "Destination must be at most 100 characters")
    String destination
) {}