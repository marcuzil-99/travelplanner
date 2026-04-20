package it.travelplanner.booking_service.dto;

import it.travelplanner.booking_service.entity.Booking;

public record NotificationRequest (
		
		Booking booking,
		String subject
		
		){}
