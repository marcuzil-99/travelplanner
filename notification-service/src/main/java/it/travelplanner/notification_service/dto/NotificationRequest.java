package it.travelplanner.notification_service.dto;

public record NotificationRequest (
		
		BookingDto booking,
		String subject
		
		){}
