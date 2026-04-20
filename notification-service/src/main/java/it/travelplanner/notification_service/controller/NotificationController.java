package it.travelplanner.notification_service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.travelplanner.notification_service.dto.NotificationRequest;
import it.travelplanner.notification_service.service.NotificationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class NotificationController {
	
	private final NotificationService nService;
	
	@PostMapping
	public String sendNotification(@RequestBody NotificationRequest request) {
		return nService.sendNotification(request.booking(), request.subject());
	}

}
